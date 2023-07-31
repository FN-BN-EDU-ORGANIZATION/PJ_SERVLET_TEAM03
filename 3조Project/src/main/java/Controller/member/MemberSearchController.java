package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberSearchController implements SubController{
	
	private MemberService service = MemberServiceImpl.getInstance();
	private AuthService aservice  = AuthServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute");
		
		
		
	}

}