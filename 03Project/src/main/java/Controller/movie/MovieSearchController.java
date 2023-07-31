package Controller.movie;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		
		List<MovieDto> list = null;
		try {
			list = service.getAllMovie(req);
			
			//java -> json 변환
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonConverted = objectMapper.writeValueAsString(list);
			
			//view로 전달
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonConverted);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}