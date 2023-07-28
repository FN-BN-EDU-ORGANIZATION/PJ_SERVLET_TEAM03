package Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Dto.InterestDto;
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
	//1,2,3 memberSearch 4 join 5 update 6 delete 7,8,9 InterestSearch 10 insert 11 update 12 delete
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		
		if (serviceNo == 1) {
			String sid = (String)param.get("sid");
			
			List<MemberDto> list = null;
			try {
				list = service.memberSearchList(sid);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("memberSearchList_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 2) {
			String sid = (String)param.get("sid");
			String id = (String)param.get("id");
			
			MemberDto list = null;
			try {
				list = service.memberSearchOne(sid, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("memberSearchOne Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 3) {
			String sid = (String)param.get("sid");
			String id = (String)param.get("id");
			
			MemberDto list = null;
			try {
				list = service.memberSearch(sid, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("memberSearch Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 4) {
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
		
		}else if (serviceNo == 5) {
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
			
		}else if(serviceNo == 6) {
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
			
		}else if(serviceNo == 7) {
			String sid = (String)param.get("sid");
			
			List<InterestDto> list = null;
			try {
				list = service.ImovieSearchList(sid);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("ImovieSearchList_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
	
		}else if(serviceNo == 8) {
			String sid = (String)param.get("sid");
			String id = (String)param.get("id");
			Integer interestCd = (Integer)param.get("interestCd");
			
			InterestDto list = null;
			try {
				list = service.ImovieSearchOne(sid, interestCd, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ImovieSearchOne Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 9) {
			String sid = (String)param.get("sid");
			String id = (String)param.get("id");
			Integer interestCd = (Integer)param.get("interestCd");
			
			InterestDto list = null;
			try {
				list = service.ImovieSearch(interestCd, id, sid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ImovieSearch Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo == 10) {
			Integer interestCd = (Integer) param.get("interestCd");
			String id = (String) param.get("id");
			Integer ImovieCd = (Integer) param.get("ImovieCd");
			String ImovieNm = (String) param.get("ImovieNm");
			Double ImovieTn = (Double) param.get("ImovieTn");
			Date iRegDate = (Date) param.get("iRegDate");
			
			if(id == null || ImovieCd == null || ImovieNm == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			InterestDto dto = new InterestDto(interestCd,id,ImovieCd,ImovieNm,ImovieTn,iRegDate);
			System.out.println("Dto : "+ dto);
			
			Boolean rValue=false;
			try {
				rValue = service.ImovieJoin(dto, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Imovie_Join Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;	
		}else if(serviceNo == 11) {
			Integer interestCd = (Integer) param.get("interestCd");
			String id = (String) param.get("id");
			Integer ImovieCd = (Integer) param.get("ImovieCd");
			String ImovieNm = (String) param.get("ImovieNm");
			Double ImovieTn = (Double) param.get("ImovieTn");
			Date iRegDate = (Date) param.get("iRegDate");
			String sid = (String)param.get("sid");
			
			if(id == null || ImovieCd == null || ImovieNm == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			InterestDto dto = new InterestDto(interestCd,id,ImovieCd,ImovieNm,ImovieTn,iRegDate);
			System.out.println("Dto : "+ dto);
			
			Boolean rValue = false;
			try {
				rValue = service.ImovieUpdate(dto, sid);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Imovie_Update Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo == 12) {
			Integer interestCd = (Integer) param.get("interestCd");
			String id = (String) param.get("id");
			String sid = (String)param.get("sid");
			
			if(interestCd == null || id == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			
			Boolean rValue = false;
			try {
				rValue = service.ImovieDelete(interestCd, id, sid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Imovie_Delete Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}
		return null;
	}

}
