package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	private Map<String, SubController> map = new HashMap();
	//초기값
	//사용자요구사항 API Controller에 저장
	
	public void init(ServletConfig config) throws ServletException{
		
		String projectPath = config.getServletContext().getContextPath();
		
		//movie
		map.put("/movie", new MovieController());	
		//member
		map.put("/member", new MemberController());
		//auth
		map.put("/auth", new AuthController());
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
