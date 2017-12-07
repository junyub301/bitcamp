package step3;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter02 implements javax.servlet.Filter {
    
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02.init()");
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter02.destroy()");
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Filter02.doFilter() - before");
        
        chain.doFilter(request, response);
        
        System.out.println("Filter02.doFilter() - after");
    }

}
