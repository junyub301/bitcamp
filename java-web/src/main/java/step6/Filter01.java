package step6;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/step5/Servlet05")
public class Filter01 implements Filter {
    
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        String charset = config.getInitParameter("charset");

        request.setCharacterEncoding(charset);
        System.out.println("stpe6.Filter01=>" + charset);
        
        response.setContentType("text/plain;charset=UTF-8");
        
        chain.doFilter(request, response);
        
       
    }
}
