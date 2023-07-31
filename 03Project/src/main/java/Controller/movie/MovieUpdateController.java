package Controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.MovieService;
import Domain.Service.MovieServiceImpl;

public class MovieUpdateController implements SubController{
	
	private MovieService service = MovieServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MovieUpdateController execute");
		
	}

}
