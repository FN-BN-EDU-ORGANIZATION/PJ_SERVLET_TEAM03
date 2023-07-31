package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberUpdateController implements SubController{
	
	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberUpdateController execute");
		
	}

}
