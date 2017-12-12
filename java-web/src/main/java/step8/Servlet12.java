package step8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@SuppressWarnings("serial")
@WebServlet("/step8/Servlet12")
@MultipartConfig(
        // location="/tmp", <= 업로드 파일이 임시 보관될 폴더
        // fileSizeThreshold=1024 * 1024, // 파일을 업로드 할 때 버퍼 크기
        maxFileSize=1024 * 1024 * 10, // 업로드 파일 한 개의 최대 크기
        maxRequestSize=1024 * 1024 * 100 // 한번 요청으로 보내는 데이터의 최대 크기
        )
public class Servlet12 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = null;
        String age = null;
        String photo1OriginalFilename = null;
        String photo1NewFilename = null;
        String photo2OriginalFilename = null;
        String photo2NewFilename = null;
        
        try {
            
            ServletContext context = this.getServletContext();
            String path = context.getRealPath("/step8");

            name = req.getParameter("name");    
            age = req.getParameter("age");
            
            Part photo1Part = req.getPart("photo1");
            photo1OriginalFilename = photo1Part.getSubmittedFileName();
            
            // 파일이 저장되는 위치는 MultipartConfig의 loacation 속성에
            // 설정된 위치를 기준으로 저장된다.
            // - 만약 웹브라우저에서 바로 접근할 수 있는 폴더에 저장하고 싶다면
            //   별도의 출력스트림으로 처리하라!
            // - 만약 lacation 속서의 값을 지정하지 않으면,
            //   톰캣 테스트용 임시 서버에서는 그 위치가 ../server.core/tmp0/work/Catalina/localhost/..에 보관
            
            //photo1NewFilename = getNewFilename(photo1OriginalFilename);
            // photo1Part.write(photo1NewFilename);

            // 배치 폴더에 집적 저장
            
            photo1NewFilename = writeUploadFile(photo1Part, path);
            
            Part photo2Part = req.getPart("photo2");
            photo2OriginalFilename = photo2Part.getSubmittedFileName();
            //photo2NewFilename = getNewFilename(photo2OriginalFilename);
            //photo2Part.write(photo2NewFilename);
            
            photo2NewFilename = writeUploadFile(photo2Part, path);

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
    
    private String writeUploadFile(Part part, String path) throws IOException{
        
        BufferedInputStream in = new BufferedInputStream(part.getInputStream());
        
        String filename = getNewFilename(part.getSubmittedFileName());
        File photo1File = new File(path + "/" + filename);
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(path + "/" + filename));
        
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
        
        return filename;
    }
}









