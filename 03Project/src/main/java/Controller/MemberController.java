package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			HttpSession session = req.getSession();
			String role = (String)session.getAttribute("ROLE");
			if(role.equals("ROLE_MEMEBER")){
				req.getRequestDispatcher("/WEB-INF/view/member.jsp").forward(req, resp);
			}else if(role.equals("ROLE_USER")) {
				req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
			}else if(role.equals("ROLE_ADMIN")) {	
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
