package Domain.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

	//외부로부터 Service 받기
	void setMemberService(MemberService memService);

	//로그인
	Map<String, Object> login(String id, String pw) throws Exception;

	//로그아웃
	boolean logout(String id, String sid);

	//역할반환함수
	String getRole(String sid);

	boolean login(HttpServletRequest req) throws Exception;

}