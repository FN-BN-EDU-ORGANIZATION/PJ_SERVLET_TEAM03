package Domain.Dao;

import java.util.List;

import Domain.Dto.MemberDto;

public interface MemberDao {

	//CRUD 구성
	int insert(MemberDto dto) throws Exception;

	List<MemberDto> select() throws Exception;

	MemberDto select(String id) throws Exception;

	int update(MemberDto dto) throws Exception;

	int delete(String id) throws Exception;

}