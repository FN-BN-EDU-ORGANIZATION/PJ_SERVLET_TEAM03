package Domain.Dao;

import java.util.List;

import Domain.Dto.MovieDto;

public interface MovieDao {

	//CRUD 구성
	int insert(MovieDto dto) throws Exception;

	List<MovieDto> select() throws Exception;

	MovieDto select(String movieNm) throws Exception;
	
	int update(MovieDto dto) throws Exception;

	int updateDay() throws Exception;

	int delete(int movieCd) throws Exception;

}