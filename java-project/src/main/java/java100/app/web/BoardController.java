package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Board;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

@Controller
@RequestMapping("/board/")
@SessionAttributes("loginUser")
public class BoardController {

    @Autowired ServletContext servletContext;
    @Autowired BoardService boardService;

    @RequestMapping("form")
    public String form() throws Exception  {

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/form";
    }

    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="title", required=false) String[] title,
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
        options.put("words",title);
        options.put("orderColumn",orderColumn);
        options.put("align",align);

        int totalCount = boardService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", boardService.list(pageNo, pageSize, options));

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/list";
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {

        boardService.viewCount(no);

        model.addAttribute("board", boardService.get(no));


        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/view";
    }

    // XML 설정으로 트랜잭션을 조정한다면 다음 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping("add")
    public String add(
            Board board, 
            MultipartFile[] file,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception  {

        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");

        // 업로드 파일 정보를 저장할 List 객체 준비
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        // 클라이언트가 보낸 파일을 저장하고,
        // 그 파일명(저장할 때 사용한 파일명)을 목록에 추가한다.
        for (MultipartFile part: file) {
            if (part.isEmpty())
                continue;

            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);

            uploadFiles.add(new UploadFile(filename));
        }

        // Board 객체에 저장한 파일명을 등록한다. 
        board.setFiles(uploadFiles);

        board.setWriter(loginUser);
        // 게시글 등록
        boardService.add(board);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }



    @RequestMapping("update")
    public String update(
            Board board,
            MultipartFile[] file) throws Exception  {

        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");

        // 업로드 파일 정보를 저장할 List 객체 준비
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        // 클라이언트가 보낸 파일을 저장하고,
        // 그 파일명(저장할 때 사용한 파일명)을 목록에 추가한다.
        for (MultipartFile part: file) {
            if (part.isEmpty())
                continue;

            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);

            uploadFiles.add(new UploadFile(filename));
        }

        // Board 객체에 저장한 파일명을 등록한다. 
        board.setFiles(uploadFiles);

        boardService.update(board);


        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {


        boardService.delete(no);

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
        return currMillis + "_" + count++ + extractFileExtName(filename); 
    }

    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        if (dotPosition == -1)
            return "";
        return filename.substring(dotPosition);
    }

    private String writeUploadFile(MultipartFile part, String path) throws IOException{

        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));

        return filename;
    }



}
