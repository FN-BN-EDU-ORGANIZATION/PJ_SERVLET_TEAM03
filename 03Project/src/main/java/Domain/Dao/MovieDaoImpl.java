package Domain.Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Domain.Dto.MovieDto;

public class MovieDaoImpl extends ConnectionPool implements MovieDao {
	// 싱글톤 패턴
	private static MovieDao instance;

	public static MovieDao getInstance() {
		if (instance == null)
			instance = new MovieDaoImpl();
		return instance;
	}

	public MovieDaoImpl() {

	}

	// CRUD 구성
	@Override
	public int insert(MovieDto dto) throws Exception { // 테스트 구동 ok
		pstmt = conn.prepareStatement("insert into tbl_movie values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, dto.getMovieCd());
		pstmt.setString(2, dto.getMovieNm());
		pstmt.setString(3, dto.getMovieOp());
		pstmt.setDouble(4, dto.getMovieTn());
		pstmt.setString(5, dto.getMovieGs());
		pstmt.setString(6, dto.getMovieOv());
		pstmt.setString(7, dto.getMoviePo());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public List<MovieDto> select() throws Exception { // 테스트 구동 ok
		List<MovieDto> list = new ArrayList();
		MovieDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_movie");
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				dto = new MovieDto();
				dto.setMovieCd(rs.getInt("movieCd"));
				dto.setMovieNm(rs.getString("movieNm"));
				dto.setMovieOp(rs.getString("movieOp"));
				dto.setMovieTn(rs.getDouble("movieTn"));
				dto.setMovieGs(rs.getString("movieGs"));
				dto.setMovieOv(rs.getString("movieOv"));
				dto.setMoviePo(rs.getString("moviePo"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}

	@Override
	public MovieDto select(String movieNm) throws Exception { // 테스트 구동 ok
		MovieDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_movie where movieNm like ?");
		pstmt.setString(1, "%" + movieNm + "%");
		rs = pstmt.executeQuery();
		if (rs != null && rs.isBeforeFirst()) {
			rs.next();
			dto = new MovieDto();
			dto.setMovieCd(rs.getInt("movieCd"));
			dto.setMovieNm(rs.getString("movieNm"));
			dto.setMovieOp(rs.getString("movieOp"));
			dto.setMovieTn(rs.getDouble("movieTn"));
			dto.setMovieGs(rs.getString("movieGs"));
			dto.setMovieOv(rs.getString("movieOv"));
			dto.setMoviePo(rs.getString("moviePo"));
			rs.close();
		}
		pstmt.close();
		return dto;
	}

	@Override
	public int update(MovieDto dto) throws Exception { // 테스트 구동 ok
		pstmt = conn.prepareStatement(
				"update tbl_movie set movieNm=?,movieOp=?,movieTn=?,movieGs=?,movieOv=?,moviePo=? where movieCd=?");
		pstmt.setString(1, dto.getMovieNm());
		pstmt.setString(2, dto.getMovieOp());
		pstmt.setDouble(3, dto.getMovieTn());
		pstmt.setString(4, dto.getMovieGs());
		pstmt.setString(5, dto.getMovieOv());
		pstmt.setString(6, dto.getMoviePo());
		pstmt.setInt(7, dto.getMovieCd());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int updateDay() throws Exception {	
		int result = 0;
		
		String apiKey = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		String today = sdf.format(cal.getTime());
		cal.add(Calendar.DATE, -2); //  2일 뺴기
		String yesterday = sdf.format(cal.getTime());
		System.out.println(yesterday);

		String apiUrl = "https://api.themoviedb.org/3/discover/movie" + "?api_key=" + apiKey
				+ "&language=ko&region=kr&include_adult=false" + "&primary_release_date.gte=" + yesterday + "&primary_release_date.lte="
				+ today;

		URL url = new URL(apiUrl);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
		bufferedReader.close();
		urlConnection.disconnect();

		JSONObject jsonObject = new JSONObject(stringBuilder.toString());
		JSONArray josnArray = jsonObject.getJSONArray("results");
		System.out.println(josnArray);
		
		for (int i = 0; i < josnArray.length(); i++) {
			JSONObject movie = josnArray.getJSONObject(i);
			int col1 = movie.getInt("id");
			String col2 = movie.getString("title");
			String col3 = movie.optString("release_date", null);
			double col4 = movie.getDouble("vote_average");
			String col6 = movie.optString("overview", null);
			String col7 = movie.optString("poster_path", null);
			
			String movieApiUrl = "https://api.themoviedb.org/3/movie/" + col1 +"?api_key=" + apiKey + "&language=ko&region=kr&include_adult=false";
            HttpURLConnection movieUrlConnection = (HttpURLConnection) new URL(movieApiUrl).openConnection();
            movieUrlConnection.setRequestMethod("GET");

            BufferedReader movieBufferedReader = new BufferedReader(new InputStreamReader(movieUrlConnection.getInputStream()));
            StringBuilder movieStringBuilder = new StringBuilder();
            String movieLine;
            while ((movieLine = movieBufferedReader.readLine()) != null) {
                movieStringBuilder.append(movieLine);
            }
            movieBufferedReader.close();
            movieUrlConnection.disconnect();
			JSONObject movieJsonObject = new JSONObject(movieStringBuilder.toString());
			JSONArray genresArray = movieJsonObject.getJSONArray("genres");
			System.out.println(genresArray);

			StringBuilder genres = new StringBuilder();
			for (int n = 0; n < genresArray.length(); n++) {
			    String genre = genresArray.getJSONObject(n).getString("name");
			    genres.append(genre).append(n != genresArray.length() - 1 ? "," : "");
			}
			
			String col5 = genres.toString(); // 생성한 장르 문자열로 값을 설정
			System.out.println(col5);
			
            PreparedStatement pstmt = conn.prepareStatement("insert IGNORE into tbl_movie values(?,?,?,?,?,?,?)");
            pstmt.setInt(1, col1);
            pstmt.setString(2, col2);
            pstmt.setString(3, col3);
            pstmt.setDouble(4, col4);
            pstmt.setString(5, col5);
            pstmt.setString(6, col6);
            pstmt.setString(7, col7);
            int rowsAd = pstmt.executeUpdate();
            System.out.println("Title: " + col2);
            System.out.println("Updated: " + (rowsAd == 1 ? "Yes" : "No"));
            System.out.println("---------------");
            result += rowsAd;
            pstmt.close();
		}
		return result;
	}

	@Override
	public int delete(int movieCd) throws Exception { // 테스트 구동 ok
		pstmt = conn.prepareStatement("delete from tbl_movie where movieCd=?");
		pstmt.setInt(1, movieCd);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
