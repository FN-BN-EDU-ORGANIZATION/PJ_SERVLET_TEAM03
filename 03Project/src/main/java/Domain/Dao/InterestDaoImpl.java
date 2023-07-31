package Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Dto.InterestDto;

public class InterestDaoImpl extends ConnectionPool implements InterestDao {
	//싱글톤 패턴
	private static InterestDao instance; 
	public static InterestDao getInstance() {
		if(instance==null)
			instance=new InterestDaoImpl();
		return instance;
		}
	
	private InterestDaoImpl() {
		
	}
	
	//CRUD 구성
	@Override
	public int insert(InterestDto dto) throws Exception{  //테스트 구동 ok
//		InterestDto dto = (InterestDto)Tmpdto;
		pstmt=conn.prepareStatement("insert into tbl_interest values(null,?,?,?,?,curdate()) WHERE NOT EXISTS");
		pstmt.setString(1, dto.getId());
		pstmt.setInt(2, dto.getImovieCd());
		pstmt.setString(3, dto.getImovieNm());
		pstmt.setDouble(4, dto.getImovieTn());
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	@Override
	public List<InterestDto> select() throws Exception{  //테스트 구동 ok
		List<InterestDto> list = new ArrayList();
		InterestDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_interest");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()) {
				dto=new InterestDto();
				dto.setInterestCd(rs.getInt("interestCd"));
				dto.setId(rs.getString("id"));
				dto.setImovieCd(rs.getInt("ImovieCd"));
				dto.setImovieNm(rs.getString("ImovieNm"));
				dto.setImovieTn(rs.getDouble("ImovieTn"));
				dto.setiRegDate(rs.getDate("iRegDate"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}
	@Override
	public InterestDto select(int interestCd, String id) throws Exception {  //테스트 구동 ok
		InterestDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_interest where interestCd=? and id=?");
		pstmt.setInt(1, interestCd);
		pstmt.setString(2, id);
		rs = pstmt.executeQuery();
		if(rs != null && rs.isBeforeFirst()) {
			rs.next();
				dto = new InterestDto();
				dto.setInterestCd(rs.getInt("interestCd"));
				dto.setId(rs.getString("id"));
				dto.setImovieCd(rs.getInt("ImovieCd"));
				dto.setImovieNm(rs.getString("ImovieNm"));
				dto.setImovieTn(rs.getDouble("ImovieTn"));
				dto.setiRegDate(rs.getDate("iRegDate"));
				rs.close();
			}
		pstmt.close();
		return dto;
		}
	@Override
	public int update(InterestDto dto) throws Exception{  //테스트 구동 ok
//		InterestDto dto = (InterestDto)Tdto;
		pstmt=conn.prepareStatement("update tbl_interest set id=?,ImovieCd=?,ImovieNm=?,ImovieTn=?,iRegDate=curdate() where interestCd=?");
		pstmt.setString(1,dto.getId() );
		pstmt.setInt(2,dto.getImovieCd() );
		pstmt.setString(3, dto.getImovieNm());
		pstmt.setDouble(4, dto.getImovieTn());
		pstmt.setInt(5,dto.getInterestCd() );
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int delete(int interestCd, String id)  throws Exception{  //테스트 구동 ok
		pstmt=conn.prepareStatement("delete from tbl_interest where interestCd=? and id=?");
		pstmt.setInt(1, interestCd);
		pstmt.setString(2, id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
}
