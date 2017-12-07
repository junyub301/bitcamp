package step3;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/step3/Servlet01")
public class Filter01 implements javax.servlet.Filter {
    
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter01.init()");
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter01.destroy()");
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Filter01.doFilter() - before");
        
        chain.doFilter(request, response);
        
        System.out.println("Filter01.doFilter() - after");
    }

}
