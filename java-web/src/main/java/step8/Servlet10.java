package step8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@SuppressWarnings("serial")
@WebServlet("/step8/Servlet10")
public class Servlet10 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String name = null;
        String age = null;
        String photo1Filename = null;
        String photo2Filename = null;

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
        } catch (Exception e) {
            throw new ServletException(e);
        }
//        String savePath = req.getServletContext().getRealPath("/step8");
        
        name = itemMap.get("name").getString("UTF-8");
        age = itemMap.get("age").getString();
        photo1Filename = itemMap.get("photo1").getName();
        photo2Filename = itemMap.get("photo2").getName();
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("이름 = %s\n", name);
        out.printf("나이 = %s\n", age);
        out.printf("사진1 = %s\n", photo1Filename); 
        out.printf("사진2 = %s\n", photo2Filename);
        
        
    }
}









