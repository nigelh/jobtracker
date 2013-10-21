package nigelhole.workspace.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nigelhole.workspace.dto.User;



@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class SecurityFilter implements Filter {
 
    @Override    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        String contextRoot = ((HttpServletRequest)request).getContextPath()+"/";

        if( uri.startsWith(contextRoot+"secure/") && uri.endsWith(".html"))
        {
        	 HttpSession session = ((HttpServletRequest)request).getSession(false);
        	 if( session != null ) {
        		 User user = (User)session.getAttribute("USER");
        		 if( user == null ) {
        			 ((HttpServletResponse)response).sendRedirect(contextRoot + "login.html?redirect=" + uri);
        			 return;
        		 }
        	 } else {
        		 ((HttpServletResponse)response).sendRedirect(contextRoot + "login.html?redirect=" + uri);
        		 return;
        	 }
        }
        
        filterChain.doFilter(request, response);
       
    }

    /**
     * Blank method body.
     */      
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    /**
     * Blank method body.
     */      
    @Override
    public void destroy() {
        
    }
    
   
   
    
}