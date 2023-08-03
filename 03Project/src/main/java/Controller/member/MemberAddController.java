package Controller.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.MemberDto;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberAddController implements SubController{
	
	private MemberService service = MemberServiceImpl.getInstance();


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAddController execute");
		
		try {
			if(req.getMethod().equals("GET")) {
				req.setAttribute("msg", "");
				req.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(req, resp);
				return ;
			}
			
			
			//POST
			//01 파라미터
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			
			//02 유효성
			if(!isValid(req.getParameterMap())) {
				req.setAttribute("msg", "유효성체크 오류");
				req.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(req, resp);
				return ;
			}
			//03 서비스
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			
			boolean isjoin = service.memberJoin(dto);
			
			//04 뷰로 이동
			if(isjoin) {
				System.out.println("isJoin True!!" + req.getContextPath());
				resp.sendRedirect(req.getContextPath()+ "/login.do");
				return ;
			}else {
				req.setAttribute("msg", "회원가입 실패..");
				req.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(req, resp);
			}

		}catch(Exception e) {
			
			e.printStackTrace(); 
		}
		
	}

	private boolean isValid(Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		return true;
	}

	
}


