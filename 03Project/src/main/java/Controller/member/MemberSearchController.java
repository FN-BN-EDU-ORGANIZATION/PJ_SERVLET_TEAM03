package Controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.MemberDto;
import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberSearchController implements SubController{
	
	private MemberService service = MemberServiceImpl.getInstance();
	private AuthService aservice  = AuthServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute");
		
			String id = req.getParameter("id");
			
			List<MemberDto> list = null;
			try {
				list = service.memberSearchList(req);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("memberSearchList_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return;
			
	}

}