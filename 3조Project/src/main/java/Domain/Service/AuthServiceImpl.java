package Domain.Service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Domain.Dao.MemberDao;
import Domain.Dao.MemberDaoImpl;
import Domain.Dto.MemberDto;

public class AuthServiceImpl implements AuthService {
	public Map<String, Session> sessionMap;
	private MemberDao dao;
	private MemberService memService;
	
	//싱글톤
	private static AuthService instance;
	public static AuthService getInstance() {
		if(instance == null)
			instance = new AuthServiceImpl();
		return instance;
	}
	
	public AuthServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		memService = MemberServiceImpl.getInstance();
		sessionMap = new HashMap();
	}
	
	//외부로부터 Service 받기
	@Override
	public void setMemberService(MemberService memService) {
		this.memService = memService;
	}
	
	//로그인
		@Override
		public boolean login(HttpServletRequest req) throws Exception {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			//1 ID/PW 체크 -> Dao 전달받은 id와 일치하는 정보를 가져와서 pw일치 확인
			MemberDto dbDto = dao.select(id);
			if(dbDto == null) {
				System.out.println("[ERROR] Login Fail..아이디가 일치하지 않습니다");
				return false;
			}
			if(!pw.equals(dbDto.getPw())) {
				System.out.println("[ERROR] Login Fail..패스워드가 일치하지 않습니다");
				return false;
			}
			
			//2 사용자에 대한 정보를(Session)을 MemberService에 저장
			System.out.println("login func's dbDto" + dbDto);
			HttpSession session = req.getSession(true);
			System.out.println("login func's session : " + session);
			session.setAttribute("ID", id);
			session.setAttribute("ROLE", dbDto.getRole());
			session.setMaxInactiveInterval(60*30);
			return true;
		}
		//로그아웃
		@Override
		public boolean logout(HttpServletRequest req) throws Exception{
			HttpSession session = req.getSession(true);
			if(!session.getId().equals(id)) {
				System.out.println("[ERROR] ID가 일치하지 않습니다.");
				return false;
			}
			sessionMap.remove(sid);
			return true;
		}
		
		
		
		
		//역할반환함수
		@Override
		public String getRole(String sid) {
			Session session = sessionMap.get(sid);
			if(session != null)
				return session.getRole();
			return null;
		}


}
