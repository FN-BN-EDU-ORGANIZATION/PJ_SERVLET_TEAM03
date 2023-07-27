package Domain.Dao;

import java.util.List;

import Domain.Dto.InterestDto;

public interface InterestDao {

	//CRUD 구성
	int insert(InterestDto dto) throws Exception;

	List<InterestDto> select() throws Exception;

	InterestDto select(int interestCd, String id) throws Exception;

	int update(InterestDto dto) throws Exception;

	int delete(int interestCd, String id) throws Exception;

}