package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberSearchController implements SubController{
	
	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute");
		
	}

}
