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

import java100.app.AppInitServlet;
import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@WebServlet(urlPatterns="/score/*")
public class ScoreServlet implements Servlet {

    ServletConfig servletConfig;

    ScoreDao scoreDao;

    @Override
    public void destroy() {}

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        scoreDao = AppInitServlet.iocContainer.getBean(ScoreDao.class);
    }
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "성적관리 서블릿";
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
        case "/view": this.doView(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        case "/update": this.doUpdate(httpRequest, httpResponse); break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }

        System.out.println();
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        out.println("[성적 변경]");

        try {
            Score score = new Score();
            score.setNo(Integer.parseInt(request.getParameter("no")));
            score.setName(request.getParameter("name"));
            score.setKor(Integer.parseInt(request.getParameter("kor")));
            score.setEng(Integer.parseInt(request.getParameter("eng")));
            score.setMath(Integer.parseInt(request.getParameter("math")));

            if (scoreDao.update(score) > 0 ) { 
                out.println("변경하였습니다..");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n",score.getNo());
            }

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    private void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("[성적 삭제]");

        try {
            int no = Integer.parseInt(request.getParameter("no"));

            if (scoreDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }


    }

    private void doView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[성적 상세 정보]");

        try {


            int no = Integer.parseInt(request.getParameter("no"));

            Score score = scoreDao.selectOne(no); 
            if (score != null) {
                out.printf("번호: %d\n", score.getNo());
                out.printf("이름: %s\n", score.getName());
                out.printf("국어: %d\n", score.getKor());
                out.printf("영어: %d\n", score.getEng());
                out.printf("수학: %d\n", score.getMath());
                out.printf("합계: %d\n", score.getSum());
                out.printf("평균: %.1f\n", score.getAver());
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("[성적 목록]");

        try {
            List<Score> list = scoreDao.selectList();

            for (Score score : list) {
                out.printf("%4d, %-4s, %4d, %6.1f\n",  
                        score.getNo(),
                        score.getName(),
                        score.getSum(),
                        score.getAver()); 
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
            Score score = new Score();
            score.setName(request.getParameter("name"));
            score.setKor(Integer.parseInt(request.getParameter("kor")));
            score.setEng(Integer.parseInt(request.getParameter("eng")));
            score.setMath(Integer.parseInt(request.getParameter("math")));

            scoreDao.insert(score);
            out.println("저장하였습니다.");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }


}
