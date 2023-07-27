package Domain.Service;

import java.util.List;

import Domain.Dto.MovieDto;

public interface MovieService {

	//영화 조회
	List<MovieDto> getAllMovie() throws Exception;

	//영화 단건 조회
	MovieDto getMovie(String movieCd) throws Exception;

	//영화 등록하기(직원)
	boolean addMovie(MovieDto dto, String sid) throws Exception;

	//영화 수정하기(직원)
	boolean updateMovie(MovieDto dto, String sid) throws Exception;

	//영화 삭제하기(직원)
	boolean removeMovie(int movieCd, String sid) throws Exception;
	
	//영화 자동 등록하기(직원)
	boolean updateDayMovie(String sid) throws Exception;

}