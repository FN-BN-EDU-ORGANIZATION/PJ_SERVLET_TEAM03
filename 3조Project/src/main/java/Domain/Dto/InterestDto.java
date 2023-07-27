package Domain.Dto;

import java.util.Date;

public class InterestDto {
	private int interestCd;
	private String id;
	private String movieCd;
	private Date iRegDate;
	
	public InterestDto() {}


	@Override
	public String toString() {
		return "InterestDto [interestCd=" + interestCd + ", id=" + id + ", movieCd=" + movieCd + ", iRegDate="
				+ iRegDate + "]";
	}

	public InterestDto(int interestCd, String id, String movieCd, Date iRegDate) {
		super();
		this.interestCd = interestCd;
		this.id = id;
		this.movieCd = movieCd;
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

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public Date getiRegDate() {
		return iRegDate;
	}

	public void setiRegDate(Date iRegDate) {
		this.iRegDate = iRegDate;
	}

}
