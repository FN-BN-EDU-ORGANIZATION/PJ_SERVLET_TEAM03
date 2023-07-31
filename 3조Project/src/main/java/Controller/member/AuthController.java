package Controller.member;

import java.util.HashMap;
import java.util.Map;

import Controller.SubController;
import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;
import Domain.Service.Session;

public class AuthController implements SubController {
	
	private AuthService service = AuthServiceImpl.getInstance();
	

	// 1 login, 2 logout
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		if (serviceNo == 1) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			
			if(id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null; 
			}
			
			Map<String,Object> result = new HashMap();
			try {
				result = service.login(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}else if(serviceNo == 2) {
			String id = (String) param.get("id");
			String sid = (String)param.get("sid");
			
			if(id == null || sid == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			Boolean rValue = false;
			try {
				rValue = service.logout(id, sid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			System.out.println("Member_Logout Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}
		return null;
	}

}
