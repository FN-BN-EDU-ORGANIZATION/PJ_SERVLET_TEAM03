package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Service.AuthService;
import Domain.Service.AuthServiceImpl;

public class AuthController implements SubController {
	
	private AuthService service;
	
	public AuthController() {
		service = AuthServiceImpl.getInstance();
	}

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
		}
		return null;
	}

}
