package Domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.InterestDao;
import Domain.Dao.InterestDaoImpl;
import Domain.Dao.MemberDao;
import Domain.Dao.MemberDaoImpl;
import Domain.Dto.InterestDto;
import Domain.Dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	public Map<String, Session> sessionMap;
	private MemberDao dao;
	private InterestDao Idao;
	
	//싱글톤
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}
	
	private AuthService authService;
	private MovieService movieService;
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		Idao = InterestDaoImpl.getInstance();  //이건 어쩌지?
		sessionMap = new HashMap();
	}
	//회원 가입하기
		@Override
		public boolean memberJoin(MemberDto dto) throws Exception {  //테스트 통과 ok
			int result = dao.insert(dto);
			if(result > 0)
				return true;
			return false;
		}
		//회원 조회하기(전체) - 사서
		@Override
		public List<MemberDto> memberSearchList(String sid) throws Exception {  //테스트 통과 ok
			String role = authService.getRole(sid);
			if(role.equals("ROLE_MEMBER")) 
				return dao.select();
			return null;
		}
		//회원 조회하기(한명) - 사서
		@Override
		public MemberDto memberSearchOne(String sid, String id) throws Exception {
			String role = authService.getRole(sid);
			if(role.equals("ROLE_MEMBER")) 
				return dao.select(id);
			return null;
		}
		//회원 조회하기(한 회원) - 로그인한 회원
		@Override
		public MemberDto memberSearch(String id, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(id)) 
				return dao.select(id);
			return null;
		}
		//회원 수정하기 - 본인확인
		@Override
		public boolean memberUpdate(MemberDto dto, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(dto.getId())) {
				int result = dao.update(dto);
				if(result > 0)
					return true;
			}
			return false;
		}
		//회원 삭제하기
		@Override
		public boolean memberDelete(String id, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(id)) {
				int result = dao.delete(id);
				if(result > 0)
					return true;
			}
			return false;
		}
		
		//관심 등록
		@Override
		public boolean ImovieJoin(InterestDto dto, String sid) throws Exception {
			System.out.println("MemberService's addInterest()");
			String role = authService.getRole(sid);
			if(role.equals("ROLE_MEMBER") || role.equals("ROLE_USER")) {
				int result = Idao.insert(dto);
				if(result > 0)
					return true;
			}
			return false;
		}
		//관심 조회하기(전체)
		@Override
		public List<InterestDto> ImovieSearchList(String sid) throws Exception {
			String role = authService.getRole(sid);
			if(role.equals("ROLE_MEMBER")) 
				return Idao.select();
			return null;
		}//관심 조회하기(한명) - 직원
		@Override
		public InterestDto ImovieSearchOne(String sid, int interestCd, String id) throws Exception {
			String role = authService.getRole(sid);
			if(role.equals("ROLE_MEMBER")) 
				return Idao.select(interestCd, id);
			return null;
		}
		//관심 조회하기(한 회원) - 로그인한 회원
		@Override
		public InterestDto ImovieSearch(int interestCd, String id, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(id)) 
				return Idao.select(interestCd, id);
			return null;
		}//관심 수정하기 - 본인확인
		@Override
		public boolean ImovieUpdate(InterestDto dto, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(dto.getId())) {
				int result = Idao.update(dto);
				if(result > 0)
					return true;
			}
			return false;
		}
		//관심 삭제하기
		@Override
		public boolean ImovieDelete(int interestCd, String id, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if(session != null && session.getId().equals(id)) {
				int result = Idao.delete(interestCd, id);
				if(result > 0)
					return true;
			}
			return false;
		}
		
}
