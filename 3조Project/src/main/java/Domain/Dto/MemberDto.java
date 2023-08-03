package Domain.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String username;
	private String birth;
	private String gender;
	private String addr;
	private String phone;
	private String role;
	
	public MemberDto() {
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", username=" + username + ", birth=" + birth + ", gender="
				+ gender + ", addr=" + addr + ", phone=" + phone + ", role=" + role + "]";
	}

	public MemberDto(String id, String pw, String username, String birth, String gender, String addr, String phone,
			String role) {
		super();
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.birth = birth;
		this.gender = gender;
		this.addr = addr;
		this.phone = phone;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
