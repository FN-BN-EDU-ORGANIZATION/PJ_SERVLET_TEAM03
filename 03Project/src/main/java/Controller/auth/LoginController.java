package Controller.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;

public class LoginController implements SubController {
	
	private AuthService service = AuthServiceImpl.getInstance();

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
		
		
		//POST 처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println("LoginController parameters : " + id+ " " + pw);
		
		try {
			if (id.isEmpty() || pw.isEmpty()) {
				System.out.println("[ERROR] Data Validation Check Error!");
				req.setAttribute("msg", "[ERROR] ID나 PW가 공백입니다.");
				req.getRequestDispatcher("/WEB-INF/view/member/auth/login.jsp").forward(req, resp);
				return ;
			}
			boolean isLogin=false;
			isLogin=service.login(req);
			if(isLogin)
			{
				//user.do 이동 - Redirect
				resp.sendRedirect(req.getContextPath()+"/user.do");
			}
			else
			{
				//login.do 이동 - Forward
				req.getRequestDispatcher("/WEB-INF/view/member/auth/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

}
