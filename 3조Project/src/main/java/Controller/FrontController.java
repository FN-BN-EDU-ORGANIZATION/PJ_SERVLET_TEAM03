package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.auth.AuthAddController;
import Controller.auth.AuthDeleteController;
import Controller.auth.AuthSearchController;
import Controller.auth.AuthUpdateController;
import Controller.member.MemberAddController;
import Controller.member.MemberDeleteController;
import Controller.member.MemberSearchController;
import Controller.member.MemberUpdateController;
import Controller.movie.MovieAddController;
import Controller.movie.MovieDeleteController;
import Controller.movie.MovieSearchController;
import Controller.movie.MovieUpdateController;

public class FrontController extends HttpServlet{
	
	private Map<String, SubController> map = new HashMap();
	//초기값
	//사용자요구사항 API Controller에 저장
	
	public void init(ServletConfig config) throws ServletException{
		
		String projectPath = config.getServletContext().getContextPath();
		
		//movie
		map.put(projectPath+"/movie/search.do", new MovieSearchController());
		map.put(projectPath+"/movie/add.do", new MovieAddController());
		map.put(projectPath+"/movie/update.do", new MovieUpdateController());
		map.put(projectPath+"/movie/delete.do", new MovieDeleteController());
		
		//member
		map.put(projectPath+"/member/search.do", new MemberSearchController());
		map.put(projectPath+"/member/add.do", new MemberAddController());
		map.put(projectPath+"/member/update.do", new MemberUpdateController());
		map.put(projectPath+"/member/delete.do", new MemberDeleteController());
		
		//auth
		map.put(projectPath+"/auth/search.do", new AuthSearchController());
		map.put(projectPath+"/auth/add.do", new AuthAddController());
		map.put(projectPath+"/auth/update.do", new AuthUpdateController());
		map.put(projectPath+"/auth/delete.do", new AuthDeleteController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FrontController's service Uri : "+ req.getRequestURI());
		SubController controller = map.get(req.getRequestURI());
		controller.execute(req,resp);
		
	}

   

	//request에 맞는 controller를 추출, 컨트롤러 실행
	//request, ServiceNo(1 select, 2 insert, 3 update, 4 delete), param
	public Map<String, Object> execute(String request, int ServiceNo, Map<String, Object> param){
		SubController controller = map.get(request);
		
		Map<String, Object> result = new HashMap();
		result = controller.execute(ServiceNo, param);
		return result;
	}

}
