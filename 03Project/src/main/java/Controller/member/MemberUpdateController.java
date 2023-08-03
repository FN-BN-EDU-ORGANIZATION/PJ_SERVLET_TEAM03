package Controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.MemberDto;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberUpdateController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberUpdateController execute");
		
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String username = (String)req.getParameter("username");
		String addr = (String)req.getParameter("addr");
		String phone = (String)req.getParameter("phone");
		String role = (String)req.getParameter("role");
		
		if(id == null || pw == null || username == null || addr == null || phone == null || role == null) {
			System.out.println("[ERROR] Data Validation Check Error!");
			return;
		}
		MemberDto dto = new MemberDto(id,pw,username,addr,phone,role);
		System.out.println("Dto : "+ dto);
		
		Boolean rValue = false;
		try {
			rValue = service.memberUpdate(dto, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Member_Update Block!");
		Map<String,Object> result = new HashMap();
		result.put("result", rValue);
		return; 
		
	}

}
