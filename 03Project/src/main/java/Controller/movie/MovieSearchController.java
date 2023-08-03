package Controller.movie;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain.Dto.MovieDto;
import Domain.Service.MovieService;
import Domain.Service.MovieServiceImpl;

public class MovieSearchController implements SubController{
	
	private MovieService service = MovieServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MovieSearchController execute");
		
		//01 파라미터 추출(keyfield,keyword,criteria)
		Map<String,String[]> params =  req.getParameterMap();
		
		//02 입력값 검증(생략)
		if(!isValid(params)) {
			
		}
		
		//03 서비스 실행
		List<MovieDto> list = null;
		try {

			
			
			// JAVA -> JSON 변환(List<BookDto)
			ObjectMapper objectMapper = new ObjectMapper();
	        String jsonConverted = objectMapper.writeValueAsString(list);
			
	        // JAVA -> JSON 변환(pageDto)
	        HttpSession session = req.getSession();
			ObjectMapper objectMapper2 = new ObjectMapper();
			
	        // 4 View로 전달			
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			//List<MovieDto>
			out.print(jsonConverted);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private boolean isValid(Map<String, String[]> params) {
		// TODO Auto-generated method stub
		return true;
	}

}
