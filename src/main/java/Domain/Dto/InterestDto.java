package Domain.Dto;

import java.util.Date;

public class InterestDto {
	private int interestCd;
	private String id;
	private int ImovieCd;
	private String ImovieNm;
	private double ImovieTn;
	private Date iRegDate;
	
	public InterestDto() {}

	@Override
	public String toString() {
		return "InterestDto [interestCd=" + interestCd + ", id=" + id + ", ImovieCd=" + ImovieCd + ", ImovieNm="
				+ ImovieNm + ", ImovieTn=" + ImovieTn + ", iRegDate=" + iRegDate + "]";
	}

	public InterestDto(int interestCd, String id, int imovieCd, String imovieNm, double imovieTn, Date iRegDate) {
		super();
		this.interestCd = interestCd;
		this.id = id;
		this.ImovieCd = imovieCd;
		this.ImovieNm = imovieNm;
		this.ImovieTn = imovieTn;
		this.iRegDate = iRegDate;
	}

	public int getInterestCd() {
		return interestCd;
	}

	public void setInterestCd(int interestCd) {
		this.interestCd = interestCd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getImovieCd() {
		return ImovieCd;
	}

	public void setImovieCd(int imovieCd) {
		ImovieCd = imovieCd;
	}

	public String getImovieNm() {
		return ImovieNm;
	}

	public void setImovieNm(String imovieNm) {
		ImovieNm = imovieNm;
	}

	public double getImovieTn() {
		return ImovieTn;
	}

	public void setImovieTn(double imovieTn) {
		ImovieTn = imovieTn;
	}

	public Date getiRegDate() {
		return iRegDate;
	}

	public void setiRegDate(Date iRegDate) {
		this.iRegDate = iRegDate;
	}
	
}