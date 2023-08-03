package Controller.movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.MovieDto;
import Domain.Service.MovieService;
import Domain.Service.MovieServiceImpl;

public class MovieAddController implements SubController{
	private MovieService service = MovieServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MovieAddController execute");
		
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//01 파라미터
		String MovieCd = req.getParameter("MovieCd");
		String MovieNm = req.getParameter("MovieNm");
		String MovieOp = req.getParameter("MovieOp");
		String MovieTn = req.getParameter("MovieTn");
		String MovieGs = req.getParameter("MovieGs");
		String MovieOv = req.getParameter("MovieOv");
		String MoviePo = req.getParameter("MoviePo");
		
		//02 입력값 확인
		if (MovieCd.isEmpty()|| MovieNm.isEmpty() || MovieOp.isEmpty() || MovieTn.isEmpty()|| MovieGs.isEmpty()|| MovieOv.isEmpty()||MoviePo.isEmpty()) {
			System.out.println("[ERROR] Data Validation Check Error!");
			out.print("[ERROR] Data Validation Check Error!");
			return;
		}
		
		//03 서비스 실행
		MovieDto dto = new MovieDto(MovieCd, MovieNm, MovieOp, MovieTn, MovieGs, MovieOv, MoviePo);
		System.out.println("Dto : " + dto);
		
		Boolean rValue = false;
		try {
			rValue = service.addMovie(dto, req);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Movie_Insert Block");
		Map<String,Object> result = new HashMap();
		result.put("result", rValue);
		return;
	}

}
