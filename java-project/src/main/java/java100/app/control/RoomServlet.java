package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

@WebServlet(urlPatterns="/room/*") 
public class RoomServlet implements Servlet {

    ServletConfig servletConfig;
    
    RoomDao roomDao;

    @Override
    public void destroy() {}

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);

    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "강의실관리 서블릿";
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setContentType("text/plain;charset=UTF-8");
        
        switch (httpRequest.getPathInfo()) {
        case "/add": this.doAdd(httpRequest, httpResponse); break;
        case "/list": this.doList(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }   
    }


    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");

            try {
                List<Room> list = roomDao.selectList();
                for (Room room : list) {
                    out.printf("%4d, %4s, %4s, %4s\n",  
                            room.getNo(),
                            room.getLocation(),
                            room.getName(),
                            room.getCapacity()
                            ); 
                }
            } catch (Exception e ) {
                e.printStackTrace();
                out.println(e.getMessage());
            }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        try {
            Room room = new Room();
            room.setName(request.getParameter("name"));
            room.setLocation(request.getParameter("loc"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            
            roomDao.insert(room);
            out.println("저장하였습니다.");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    }

    private void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            
            int no = Integer.parseInt(request.getParameter("no"));

            if (roomDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    



}
