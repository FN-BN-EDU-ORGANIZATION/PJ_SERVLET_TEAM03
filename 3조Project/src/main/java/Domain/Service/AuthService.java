package Domain.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

	//외부로부터 Service 받기
	void setMemberService(MemberService memService);


	//로그아웃
	boolean logout(HttpServletRequest req) throws Exception;

	//역할반환함수
	String getRole(String sid);

	//로그인
	boolean login(HttpServletRequest req) throws Exception;

}