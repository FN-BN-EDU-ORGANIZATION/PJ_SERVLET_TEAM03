package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.auth.LoginController;
import Controller.auth.LogoutController;
import Controller.member.MemberAddController;
import Controller.member.MemberDeleteController;
import Controller.member.MemberSearchController;
import Controller.member.MemberUpdateController;
import Controller.member.interest.InterestAddController;
import Controller.member.interest.InterestDeleteController;
import Controller.member.interest.InterestSearchController;
import Controller.member.interest.InterestUpdateController;
import Controller.movie.MovieAddController;
import Controller.movie.MovieDeleteController;
import Controller.movie.MovieSearchController;
import Controller.movie.MovieUpdateController;

public class FrontController extends HttpServlet {
	
	private Map<String, SubController> map = new HashMap();
	//초기값
	//사용자요구사항 API Controller에 저장
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		String projectPath = config.getServletContext().getContextPath();
		
		//movie
		map.put(projectPath+"/movie/search.do", new MovieSearchController());
		map.put(projectPath+"/movie/add.do", new MovieAddController());
		map.put(projectPath+"/movie/update.do", new MovieUpdateController());
		map.put(projectPath+"/movie/delete.do", new MovieDeleteController());
		
		//member
		map.put(projectPath+"/member/search.do", new MemberSearchController());
		map.put(projectPath+"/join.do", new MemberAddController()); 		//Join
		map.put(projectPath+"/member/update.do", new MemberUpdateController());
		map.put(projectPath+"/member/delete.do", new MemberDeleteController());
		
		//member.interest
		map.put(projectPath+"/interest/search.do", new InterestSearchController());
		map.put(projectPath+"/interest/add.do", new InterestAddController());
		map.put(projectPath+"/interest/update.do", new InterestUpdateController());
		map.put(projectPath+"/interest/delete.do", new InterestDeleteController());
		
		//auth
		map.put(projectPath+"/login.do", new LoginController());
		map.put(projectPath+"/logout.do", new LogoutController());
		
		//main
		map.put(projectPath+"/main.do", new MainController());
		
		//user
		map.put(projectPath+"/user.do", new UserController()); 
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FrontController's service Uri : "+ req.getRequestURI());
		SubController controller = map.get(req.getRequestURI());
		controller.execute(req,resp);
		 
	}
	
}
