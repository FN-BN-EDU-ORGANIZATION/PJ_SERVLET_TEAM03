package Controller.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.MovieDto;
import Domain.Service.MovieService;
import Domain.Service.MovieServiceImpl;

public class MovieController implements SubController {
	
	private MovieService service = MovieServiceImpl.getInstance();
	
	//1 Select , 2 Insert , 3 Update , 4 Delete, 5 DayUpdate
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		
		if(serviceNo == 1) {
			List<MovieDto> list = null;
			try {
				list = service.getAllMovie();
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Movie_Select Block");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
		
			
		} else if(serviceNo == 2) {
			Integer MovieCd = (Integer) param.get("MovieCd");
			String MovieNm = (String) param.get("MovieNm");
			String MovieOp = (String) param.get("MovieOp");
			Double MovieTn = (Double) param.get("MovieTn");
			String MovieGs = (String) param.get("MovieGs");
			String MovieOv = (String) param.get("MovieOv");
			String MoviePo = (String) param.get("MoviePo");
			String sid = (String) param.get("sid");
			
			if (MovieCd == null || MovieNm == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			MovieDto dto = new MovieDto(MovieCd, MovieNm, MovieOp, MovieTn, MovieGs, MovieOv, MoviePo);
			System.out.println("Dto : " + dto);
			
			Boolean rValue = false;
			try {
				rValue = service.addMovie(dto, sid);
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Movie_Insert Block");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo == 3 ) {
			Integer MovieCd = (Integer) param.get("MovieCd");
			String MovieNm = (String) param.get("MovieNm");
			String MovieOp = (String) param.get("MovieOp");
			Double MovieTn = (Double) param.get("MovieTn");
			String MovieGs = (String) param.get("MovieGs");
			String MovieOv = (String) param.get("MovieOv");
			String MoviePo = (String) param.get("MoviePo");
			String sid = (String) param.get("sid");
			
			if (MovieCd == null || MovieNm == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			MovieDto dto = new MovieDto(MovieCd, MovieNm, MovieOp, MovieTn, MovieGs, MovieOv, MoviePo);
			System.out.println("Dto : " + dto);
			
			Boolean rValue = false;
			try {
				rValue = service.updateMovie(dto, sid);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Movie_Update Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo == 4) {
			Integer MovieCd = (Integer) param.get("MovieCd");
			String sid = (String) param.get("sid");
			
			if(MovieCd == null) {
				System.out.println("[Error] Data Validation check error!");
				return null;
			}
			
			Boolean rValue = false;
			try {
				rValue = service.removeMovie(MovieCd, sid);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Movie_Delete Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}else if(serviceNo == 5) {
			String sid = (String) param.get("sid");
			
			Boolean rValue = false;
			try {
				rValue = service.updateDayMovie(sid);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Movie_Update Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}
		return null;

			
	}

}
