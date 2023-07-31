package Controller.member.interest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.MovieService;
import Domain.Service.MovieServiceImpl;

public class InterestUpdateController implements SubController {
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberUpdateController execute");
		
	}

}
