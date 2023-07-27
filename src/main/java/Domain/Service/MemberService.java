package Domain.Service;

import java.util.List;

import Domain.Dto.InterestDto;
import Domain.Dto.MemberDto;

public interface MemberService {

	//회원 가입하기
	boolean memberJoin(MemberDto dto) throws Exception;

	//회원 조회하기(전체) - 사서
	List<MemberDto> memberSearchList(String sid) throws Exception;

	//회원 조회하기(한명) - 사서
	MemberDto memberSearchOne(String sid, String id) throws Exception;

	//회원 조회하기(한 회원) - 로그인한 회원
	MemberDto memberSearch(String id, String sid) throws Exception;

	//회원 수정하기 - 본인확인
	boolean memberUpdate(MemberDto dto, String sid) throws Exception;

	//회원 삭제하기
	boolean memberDelete(String id, String sid) throws Exception;

	//관심 등록
	boolean ImovieJoin(InterestDto dto, String sid) throws Exception;

	//관심 조회하기(전체 회원) - 직원
	List<InterestDto> ImovieSearchList(String sid) throws Exception;
	
	//관심 조회하기(한 회원) - 직원
	InterestDto ImovieSearchOne(String sid, int interestCd, String id) throws Exception;

	//관심 조회하기(한 회원) - 로그인한 회원
	InterestDto ImovieSearch(int interestCd, String id, String sid) throws Exception;
	
	//관심 수정하기 - 본인확인
	boolean ImovieUpdate(InterestDto dto, String sid) throws Exception;

	//관심 삭제하기
	boolean ImovieDelete(int interestCd, String id, String sid) throws Exception;

}