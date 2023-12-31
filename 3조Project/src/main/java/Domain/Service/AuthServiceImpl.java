package Domain.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
		public Map<String, Object> login(String id, String pw) throws Exception {
			//1 ID/PW 체크 -> Dao 전달받은 id와 일치하는 정보를 가져와서 pw일치 확인
			MemberDto dbDto = dao.select(id);
			if(dbDto == null) {
				System.out.println("[ERROR] Login Fail..아이디가 일치하지 않습니다");
				return null;
			}
			if(!pw.equals(dbDto.getPw())) {
				System.out.println("[ERROR] Login Fail..패스워드가 일치하지 않습니다");
				return null;
			}
			//2 사용자에 대한 정보를(Session)을 MemberService에 저장
			String sid = UUID.randomUUID().toString();
			Session session = new Session(sid, dbDto.getId(), dbDto.getRole());
			sessionMap.put(sid, session);
			//3 세션에 대한 정보를 클라이언트가 접근할 수 있도록 하는 세션구별Id(Session Cookie) 전달
			Map<String, Object> result = new HashMap();
			result.put("sid", sid);
			result.put("role", dbDto.getRole());
			return result;
		}
		//로그아웃
		@Override
		public boolean logout(String id, String sid) {
			Session session = sessionMap.get(sid);
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
