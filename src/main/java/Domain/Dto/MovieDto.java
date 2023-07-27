package Domain.Dto;

public class MovieDto {
	private int movieCd;
	private String movieNm;
	private String movieOp;
	private double movieTn;
	private String movieGs;
	private String movieOv;
	private String moviePo;
	
	public MovieDto() {}
	
	@Override
	public String toString() {
		return "MovieDto [movieCd=" + movieCd + ", movieNm=" + movieNm + ", movieOp=" + movieOp + ", movieTn=" + movieTn
				+ ", movieGs=" + movieGs + ", movieOv=" + movieOv + ", moviePo=" + moviePo + "]";
	}
	
	public MovieDto(int movieCd, String movieNm, String movieOp, double movieTn, String movieGs, String movieOv,
			String moviePo) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.movieOp = movieOp;
		this.movieTn = movieTn;
		this.movieGs = movieGs;
		this.movieOv = movieOv;
		this.moviePo = moviePo;
	}
	
	public int getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(int movieCd) {
		this.movieCd = movieCd;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getMovieOp() {
		return movieOp;
	}
	public void setMovieOp(String movieOp) {
		this.movieOp = movieOp;
	}
	public double getMovieTn() {
		return movieTn;
	}
	public void setMovieTn(double movieTn) {
		this.movieTn = movieTn;
	}
	public String getMovieGs() {
		return movieGs;
	}
	public void setMovieGs(String movieGs) {
		this.movieGs = movieGs;
	}
	public String getMovieOv() {
		return movieOv;
	}
	public void setMovieOv(String movieOv) {
		this.movieOv = movieOv;
	}
	public String getMoviePo() {
		return moviePo;
	}
	public void setMoviePo(String moviePo) {
		this.moviePo = moviePo;
	}
	
}