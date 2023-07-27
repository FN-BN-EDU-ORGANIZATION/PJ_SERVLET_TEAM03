package Domain.Service;

import java.util.List;

import Domain.Dto.InterestDto;
import Domain.Dto.MemberDto;

public interface MemberService {

	//회원 가입하기
	boolean memberJoin(MemberDto dto) throws Exception;

	//회원 조회하기(전체) - 사서
	List<MemberDto> memberSearch(String sid) throws Exception;

	//회원 조회하기(한명) - 사서
	MemberDto memberSearchOne(String role, String id) throws Exception;

	//회원 조회하기(한 회원) - 로그인한 회원
	MemberDto memberSearch(String id, String sid) throws Exception;

	//회원 수정하기 - 본인확인
	boolean memberUpdate(MemberDto dto, String sid) throws Exception;

	//회원 삭제하기
	boolean memberDelete(String id, String sid) throws Exception;

	//관심 등록
	boolean ImoiveJoin(InterestDto dto, String sid) throws Exception;

	//관심 조회하기(전체)
	List<InterestDto> ImoiveSearch(String sid) throws Exception;//관심 조회하기(한명) - 직원

	InterestDto ImoiveSearchOne(String role, int interestCd, String id) throws Exception;

	//관심 조회하기(한 회원) - 로그인한 회원
	InterestDto ImoiveSearch(int interestCd, String id, String sid) throws Exception;//관심 수정하기 - 본인확인

	boolean ImoiveUpdate(InterestDto dto, String sid) throws Exception;

	//관심 삭제하기
	boolean ImoiveDelete(int interestCd, String id, String sid) throws Exception;

}