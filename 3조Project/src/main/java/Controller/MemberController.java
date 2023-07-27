package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Dto.MemberDto;
import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;
import Domain.Service.MemberService;
import Domain.Service.MemberServiceImpl;

public class MemberController implements SubController {
	
	private MemberService service;
	private AuthService aservice;
	
	public MemberController() {
		service = MemberServiceImpl.getInstance();
		aservice = AuthServiceImpl.getInstance();
	}

	
	
	
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		
		if (serviceNo == 1) {
			String sid = (String)param.get("sid");
			
			List<MemberDto> list = null;
			try {
				list = service.memberSearch(sid);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Member_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 2) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String username = (String) param.get("username");
			String addr = (String) param.get("addr");
			String phone = (String) param.get("phone");
			String role = (String) param.get("role");
			
			if(id == null || pw == null || username == null || addr == null || phone == null || role == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			MemberDto dto = new MemberDto(id,pw,username,addr,phone,role);
			System.out.println("Dto : "+ dto);
			
			Boolean rValue = false;
			try {
				rValue = service.memberJoin(dto);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Member_Insert Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		
		}else if (serviceNo == 4) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String username = (String) param.get("username");
			String addr = (String) param.get("addr");
			String phone = (String) param.get("phone");
			String role = (String) param.get("role");
			String sid = (String)param.get("sid");
			
			if(id == null || pw == null || username == null || addr == null || phone == null || role == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			MemberDto dto = new MemberDto(id,pw,username,addr,phone,role);
			System.out.println("Dto : "+ dto);
			
			Boolean rValue = false;
			try {
				rValue = service.memberUpdate(dto, sid);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Member_Update Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo == 4) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String sid = (String)param.get("sid");
			
			if(id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			Boolean rValue=false;
			try {
				rValue = service.memberDelete(id, sid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Member_Delete Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo == 5) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			
			if(id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			Map<String,Object> result = new HashMap();
			try {
				result = aservice.login(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		}
		return null;
	}

}
