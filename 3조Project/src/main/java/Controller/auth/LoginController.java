package Controller.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;

public class LoginController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LoginController execute");
		
		//GET 처리
		if(req.getMethod().equals("GET"))
		{
			try {
				req.getRequestDispatcher("/WEB-INF/view/member/auth/login.jsp").forward(req,resp);
				return;
			} catch(ServletException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return ;
		}
		
		
	}

}
