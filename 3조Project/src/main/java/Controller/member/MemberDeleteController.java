package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberDeleteController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberDeleteController execute");
		
	
		
	
		Boolean rValue=false;
		try {
			rValue = service.memberDelete(req); 
			if(rValue) {
				resp.sendRedirect(req.getContextPath()+"/main.do");
			}else {
				req.getRequestDispatcher("/WEB-INF/view/member/user.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
	}

}
