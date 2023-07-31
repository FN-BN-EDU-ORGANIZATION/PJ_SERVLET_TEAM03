package Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Dto.MemberDto;

public class MemberDaoImpl extends DBConnectionPool implements MemberDao {
	//싱글톤 패턴
	private static MemberDao instance; 
	public static MemberDao getInstance() {
		if(instance==null)
			instance=new MemberDaoImpl();
		return instance;
		}
	
	private MemberDaoImpl() {
		
	}
	
	//CRUD 구성
	@Override
	public int insert(MemberDto dto) throws Exception{  //테스트 구동 ok
//		MemberDto dto = (MemberDto)Tmpdto;
		pstmt=conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getUsername());
		pstmt.setString(4, dto.getAddr());
		pstmt.setString(5, dto.getPhone());
		pstmt.setString(6, dto.getRole());
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	@Override
	public List<MemberDto> select() throws Exception{  //테스트 구동 ok
		List<MemberDto> list = new ArrayList();
		MemberDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_member");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()) {
				dto=new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setUsername(rs.getString("username"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhone(rs.getString("phone"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}
	@Override
	public MemberDto select(String id) throws Exception {  //테스트 구동 ok
		MemberDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_member where id=?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs != null && rs.isBeforeFirst()) {
			rs.next();
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setUsername(rs.getString("username"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhone(rs.getString("phone"));
				dto.setRole(rs.getString("role"));
				rs.close();
			}
		pstmt.close();
		return dto;
	}
	@Override
	public int update(MemberDto dto) throws Exception{  //테스트 구동 ok
//		MemberDto dto = (MemberDto)Tdto;
		pstmt=conn.prepareStatement("update tbl_member set pw=?,username=?,addr=?,phone=?,role=? where id=?");
		pstmt.setString(1,dto.getPw() );
		pstmt.setString(2,dto.getUsername() );
		pstmt.setString(3,dto.getAddr());
		pstmt.setString(4,dto.getPhone() );
		pstmt.setString(5,dto.getRole() );
		pstmt.setString(6,dto.getId() );
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int delete(String id)  throws Exception{  //테스트 구동 ok
		pstmt=conn.prepareStatement("delete from tbl_member where id=?");
		pstmt.setString(1, id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
}
