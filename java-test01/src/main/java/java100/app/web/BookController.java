package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Book;
import java100.app.service.BookService;

@Controller
@RequestMapping("/book/")
public class BookController {


    @Autowired ServletContext servletContext;
    @Autowired BookService bookService;

    @RequestMapping("form")
    public String form() throws Exception  {

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "book/form";
    }


    @RequestMapping("add")
    public String add(
            Book book, 
            MultipartFile file) throws Exception  {

        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");

        // part파일은 uploadDir경로에 저장해라.
        String filename = this.writeUploadFile(file, uploadDir);


        // Book 객체에 저장한 파일명을 등록한다. 
        book.setPhoto(filename);

        // 게시글 등록
        bookService.add(book);

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect: list";
    }

    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }

        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }

        HashMap<String,Object> options = new HashMap<>();
        options.put("words",words);
        options.put("orderColumn",orderColumn);
        options.put("align",align);

        int totalCount = bookService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", bookService.list(pageNo, pageSize, options));

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "book/list";
    }


    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {

        model.addAttribute("book", bookService.get(no));


        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "book/view";
    }


    @RequestMapping("update")
    public String update(
            Book book,
            MultipartFile file) throws Exception  {

        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");


        String filename = this.writeUploadFile(file, uploadDir);

        // Book 객체에 저장한 파일명을 등록한다. 
        book.setPhoto(filename);
        bookService.update(book);


        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {


        bookService.delete(no);

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }



    long prevMillis = 0;
    int count = 0;

    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        if (filename != null) {
            return currMillis + "_" + count++ + extractFileExtName(filename);
        } 
        return filename;   
    }

    // 파일명에서 뒤의 확장자명을 추출한다.
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");

        if (dotPosition == -1)
            return "";

        return filename.substring(dotPosition);
    }

    private String writeUploadFile(MultipartFile part, String path) throws IOException {

        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        if (part.isEmpty()) {
            filename = null;
        }
        return filename;
    }  

}




