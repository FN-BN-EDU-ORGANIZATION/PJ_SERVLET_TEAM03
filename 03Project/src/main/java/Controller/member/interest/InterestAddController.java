package Controller.member.interest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;

public class InterestAddController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAddController execute");
		
	}

}
