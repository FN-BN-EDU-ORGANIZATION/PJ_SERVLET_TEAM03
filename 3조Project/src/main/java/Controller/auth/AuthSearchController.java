package Controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;

public class AuthSearchController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AuthSearchController execute");
		
	}

}
