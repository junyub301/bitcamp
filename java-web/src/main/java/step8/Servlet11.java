package step8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@SuppressWarnings("serial")
@WebServlet("/step8/Servlet11")
public class Servlet11 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = null;
        String age = null;
        String photo1OriginalFilename = null;
        String photo1NewFilename = null;
        String photo2OriginalFilename = null;
        String photo2NewFilename = null;
        
        

        // 멀티파트 데이터를 받아서 각 파트 데이터를 FileItem 객체로 만들고,
        // 파일은 외부 저장장치(HDD)에 저장하는 역할을 수행한다. 
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 멀티파트로 전송된 요청 정보를 다루는 역할을 수행한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        Map<String, FileItem> itemMap = new HashMap<>();

        try {
            
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                itemMap.put(item.getFieldName(), item);
            }

            name = itemMap.get("name").getString("UTF-8");
            age = itemMap.get("age").getString();
            photo1OriginalFilename = itemMap.get("photo1").getName();
            photo2OriginalFilename = itemMap.get("photo2").getName();

            ServletContext context = this.getServletContext();
            String path = context.getRealPath("/step8");

            FileItem fileItem = itemMap.get("photo1");
            photo1NewFilename = getNewFilename(fileItem.getName());
            File file = new File(path + "/" + photo1NewFilename);
            fileItem.write(file);

            fileItem = itemMap.get("photo2");
            photo2NewFilename = getNewFilename(fileItem.getName());
            file = new File(path + "/" + photo2NewFilename);
            fileItem.write(file);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>파일 업로드 결과</title>");
        out.println("<body>");
        out.println("<h1>파일 업로드 결과</h1>");
        out.printf("이름 = %s<br>\n", name);
        out.printf("나이 = %s<br>\n", age);
        out.printf("사진1 = %s<br>\n", photo1OriginalFilename); 
        
        out.printf("<img src='%s' width='200'><br>\n", photo1NewFilename);
        out.printf("사진2 = %s<br>\n", photo2OriginalFilename);
        
        out.printf("<img src='%s' width='200'><br>\n", photo2NewFilename);
        out.println("</body>");
        out.println("</html>");
        

    }
    long prevMillis = 0;
    int count = 0;
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
}









