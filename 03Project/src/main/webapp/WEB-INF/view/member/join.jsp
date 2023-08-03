<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css" />
<link rel="stylesheet" type="text/css" href="resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
<style>
.first {
	margin-top: 50px;
	margin-bottom: 10px;
}

.con {
	display: inline-block;
	width: 100px;
}
.id{
	maggin: auto;
	
}

</style>
</head>
<body>
    <header>
        <div id="header_section" class="header">
            <h1 class="logo">
                <a href="${pageContext.request.contextPath}/main.do"></a>
            </h1>
            <div class="gnb">
                <ul class="menu1">
                    <li><a href=""><img src="resources/image/페이스북.png" alt="페이스북로고"></a></li>
                    <li><a href="" style="width:35px"><img src="resources/image/유튜브-removebg-preview.png" alt="유튜브로고"></a></li>
                    <li><a href=""><img src="resources/image/인스타그램.png" alt="인스타그램로고"></a></li>
                </ul>
                <ul class="menu2">
                    <li><a href="">멤버십</a></li>
                    <li><a href="">고객센터</a></li>
                    <li><a href="">단체관람/대관문의</a></li>
                    <li><a href="${pageContext.request.contextPath}/login.do">로그인</a></li>
                </ul>
                <ul class="menu3">
                    <li><a href="${pageContext.request.contextPath}/join.do">회원가입</a></li>
                    <li><a href="">바로예매</a></li>
                    <li><a href=""><img src="resources/image/햄버거버튼.png"></a></li>
                </ul>
                <div class="nav">
                    <ul class="submenu">
                        <li>
                            <a href="">예매</a>
                            <ul class="submenu1">
                                <li><a href="">예매하기</a></li>
                                <li><a href="">상영시간표</a></li>
                                <li><a href="">할인안내</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">영화</a>
                            <ul class="submenu2">
                                <li><a href="">홈</a></li>
                                <li><a href="">현재상영작</a></li>
                                <li><a href="">상영예정작</a></li>
                                <li><a href="">아르떼</a></li>
                                <li><a href="">국립극장</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">영화관</a>
                            <ul class=submenu3>
                                <li><a href="">스페셜관</a></li>
                                <li><a href="">서울</a></li>
                                <li><a href="">경기/인천</a></li>
                                <li><a href="">충청/대전</a></li>
                                <li><a href="">전라/광주</a></li>
                                <li><a href="">경상/대구</a></li>
                                <li><a href="">경상/부산/울산</a></li>
                                <li><a href="">강원</a></li>
                                <li><a href="">제주</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">이벤트</a>
                            <ul class="submenu4">
                                <li><a href="">홈</a></li>
                                <li><a href="">영화</a></li>
                                <li><a href="">시사회/무대인사</a></li>
                                <li><a href="">HOT</a></li>
                                <li><a href="">제휴할인</a></li>
                                <li><a href="">우리동네영화관</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">스토어</a>
                            <ul class="submenu5">
                                <li><a href="">베스트</a></li>
                                <li><a href="">관람권</a></li>
                                <li><a href="">스낵음료</a></li>
                                <li><a href="">포토카드</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href=""></a>
                            <ul></ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
	<form id="joinfrm" name="joinfrm" action="${pageContext.request.contextPath}/join.do" method="post">
		<div style="width: 900px; margin-left: 550px; margin-top: -40px;">
			<h2 style="margin-top: 50px;">회원가입</h2>
			<br>
			<h1>
				회원가입을 위해 <br>휴대폰 본인 인증해주세요.
			</h1>
	
			<div class="first">
				<strong>인증정보입력</strong>
			</div>
			<hr>
			<div>
				<label for="name"><span class="con">이름 : </span></label><input
					type="text" placeholder="한글 또는 영문">
				<hr>
			</div>
			<div>
				<label for="birth"><span class="con">생년월일 : </span></label><input
					type="text" placeholder="생년월일 입력">
				<hr>
			</div>
			<div>
				<label for=""><span class="con">성별 : </span></label><input
					type="radio" name="gender" value="man"> 남 <input
					type="radio" name="gender" value="woman"> 여
				<hr>
			</div>
			<div>
				<label for="phone"></span>휴대폰번호 : </label>
				<div>
					<select name="통신사">
						<option value="SKT">SKT</option>
						<option value="KT" selected>KT</option>
						<option value="LG">LG</option>
					</select> <select name="ph--ln">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="018">018</option>
					</select> <span> - </span> <input type="tel" pattern="[0-9]{3,4}" required />
					<span> - </span> <input type="tel" pattern="[0-9]{4}" required /> <input
						type="button" value="인증">
	
				</div>
				<hr>
			</div>
	
				<div class="col" >
					<span class="con">주소 : </span><input type="text" name= "zipcode" placeholder="우편번호를 입력하세요">
					<button class="btn btn-secondary w-100" onclick="searchZip()">우편번호검색</button>	
				</div>
			
				<input type="text" name="addr1"  placeholder="기본주소 입력"  class="form-control" style=width:300px;/>
				<input type="text" name="addr2"  placeholder="상세주소 입력" class="form-control"  style=width:200px;/>
	
			<hr>
			<div>
			<div class="id">
				<label for="id"><span class="con">ID : </span></label><input
					type="text" name="id">
			</div>
			<br>
			<div>
				<label for="pw"><span class="con">PASSWORD : </span></label><input
					type="password" placeholder="********"  name="pw">
			</div>
			</div>
			<div style="display: flex; justify-content: center; margin-top: 40px;">
				<input type="button" style="background-color: red;" value="취소">
				<input type="submit" value="회원가입"  style="margin-left: 5px;">
			</div>
		</div>
	</form>
	 <footer>
        <div class="footer">
            <div class="inner">
                <span class="footerlogo">
                    <img src="resources/image/logo3.png" alt="">
                </span>
                <ul class="footermenu">
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">이메일무단수집거부</a></li>
                    <li><a href="#">영상정보처리기기 운영 및 관리방침</a></li>
                    <li><a href="#">L.POINT회원안내</a></li>
                    <li><a href="#">배정기준</a></li>
                    <li><a href="#">채용안내</a></li>
                    <li><a href="#">광고/임대문의</a></li>
                    <li><a href="#">기업정보</a></li>
                    <li><a href="#">사회적책임</a></li>
                </ul>
                <div class="address">
                    <address>서울특별시 송파구 올림픽로 300 롯데월드타워 27층</address>
                    <span class="bar">고객센터 1544-8855 (유료)</span><br>
                    <span class="bar">대표이사 4조</span>
                    <span class="bar">사업자등록번호 111-11-11111</span>
                    <span class="bar">통신판매업신고번호 제1111호</span>
                    <span class="bar">개인정보보호책임자 4조</span>
                </div>
                <p class="copyright" style="font-size: 12px;">COPYRIGHT LOTTE CINEMA ALL RIGHT RESERVED.</p>
            </div>
        </div>
    </footer>
    
    <script defer>
	/* 자바스크립트 수준의 유효성 체크  */
	/* const isValid=function(){
		const joinfrm = document.joinfrm;
		//alert("[JS] func isValid");
		//email 공백여부 등 Validation Check

		joinfrm.submit();
	} */
	</script>
    
    <script defer src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script defer>
	
	
	const searchZip=function()
	{
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            let form = document.joinfrm;
	            var addr='';

	            //사용자가 도로명 주소 선택
	            if(data.userSelectedType==='R')
	            {
	            	addr=data.roadAddress;
	            }
	            else //사용자가 지번 주소 선택 'J'
	            {
	            	addr=data.jibunAddress;
	            }  
	            form.zipcode.value=data.zonecode;
	            form.addr1.value=addr;
	            
	        }
	    }).open();
	}
</script>
</body>
</html>