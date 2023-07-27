package Domain.Service;

import java.util.ArrayList;
import java.util.List;

import Domain.Dao.MovieDao;
import Domain.Dao.MovieDaoImpl;
import Domain.Dto.MovieDto;

public class MovieServiceImpl implements MovieService {
	private MovieDao dao;
	
	//싱글톤
	private static MovieService instance;
	public static MovieService getInstance() {
		if(instance == null)
			instance = new MovieServiceImpl();
		return instance;
	}
	
	private AuthService authService;
	public MovieServiceImpl() {
		dao = MovieDaoImpl.getInstance();
	}
	//영화 조회
	@Override
	public List<MovieDto> getAllMovie() throws Exception {  //테스트 구동 ok
		System.out.println("MovieService's getAllMovie()");
		return dao.select();
	}
	//영화 단건 조회
	@Override
	public MovieDto getMovie(String movieCd) throws Exception {  //테스트 구동 ok
		System.out.println("MovieService's getMovie()");
		return dao.select(movieCd);
	}
	//영화 등록하기(직원)
	@Override
	public boolean addMovie(MovieDto dto, String sid) throws Exception {  //테스트 구동 ok
		System.out.println("MovieService's addMovie()");
		String role = authService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.insert(dto);
			if(result > 0)
				return true;
		}
		return false;
	}
	//영화 수정하기(직원)
	@Override
	public boolean updateMovie(MovieDto dto, String sid) throws Exception {  //테스트 구동 ok
		System.out.println("MovieService's updateMovie()");
		String role = authService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.update(dto);
			if(result > 0)
				return true;
		}
		return false;
	}
	//영화 자동 등록하기(직원)
	@Override
	public boolean updateDayMovie(String sid) throws Exception {
		System.out.println("MovieService's updateDayMovie");
		String role = authService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.updateDay();
			if(result > 0)
				return true;
		}
		return false;
	}
	//영화 삭제하기(직원)
	@Override
	public boolean removeMovie(int movieCd, String sid) throws Exception {  //테스트 구동 ok
		System.out.println("MovieService's removeMovie()");
		String role = authService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.delete(movieCd);
			if(result > 0)
				return true;
		}
		return false;
	}
}
