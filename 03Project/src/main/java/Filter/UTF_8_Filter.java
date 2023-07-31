package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UTF_8_Filter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("UTF_8 Filter Start!");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String requestURI = ((HttpServletRequest) req).getRequestURI();
        if (requestURI.endsWith(".css")) {
            resp.setContentType("text/css; charset=UTF-8");
        } else {
            resp.setContentType("text/html; charset=UTF-8");
        }

		
		chain.doFilter(req, resp);
		
	}

}
