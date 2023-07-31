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
<link rel="stylesheet" type="text/css" href="resources/css/user.css" />
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
 <!-- Swiper -->
 <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
</head>
<body>
<h1>USER PAGE</h1>
   <!-- 헤더 -->
    <header>
        <div id="header_section" class="header">
            <h1 class="logo">
                <a href="index.html"></a>
            </h1>
            <div class="gnb">
                <ul class="menu1">
                    <li><a href=""><img src="resources/image/페이스북.png" alt="페이스북로고"></a></li>
                    <li><a href="" style="width:35px"><img src="resources/image/유튜브.png" alt="유튜브로고"></a></li>
                    <li><a href=""><img src="resources/image/인스타그램.png" alt="인스타그램로고"></a></li>
                </ul>
                <ul class="menu2">
                    <li><a href="">멤버십</a></li>
                    <li><a href="">고객센터</a></li>
                    <li><a href="">단체관람/대관문의</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></li>
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
    </header>
  <!-- 메인 -->
<h1>USER PAGE</h1>
<!-- 마이페이지 버튼 -->
<div class="mypage-warp">
    <div class="mypage">
        <ul class="mypage-menu">
            <li>
                <button class="tab-update">
                    <span class="img"><img src="resources/image/ic_my_menu_1.png" alt=""></span>
                    <span class="myChange">회원 정보 변경</span>
                </button>
            </li>
            <li>
                <button class="tab-delete">
                    <span class="img"><img src="resources/image/ic_my_menu_5.png" alt=""></span>
                    <span class="myChange2">회원 탈퇴</span>
                </button>
            </li>
        </ul>
    </div>
<!-- 회원 정보 수정 -->
    <div class="userChange">
        <p class="tip">
          회원 정보입력
        </p>
          <div class="user-update">
            <label for="" id="id" style="padding-left: 65px;">ID</label> <input type="text" placeholder="ID를 입력해주세요.">
            <hr/>
            <label for="" id="pw" style="padding-left: 55px;">PW</label> <input type="text" placeholder="PW를 입력해주세요.">
            <hr/>
            <label for="" id="username" style="padding-left: 47px;">이름</label> <input type="text" placeholder="이름을 입력해주세요.">
            <hr/>
            <label for="" id="phone">휴대폰번호</label> <input type="text" placeholder="휴대폰번호를 입력해주세요."> <button>인증</button>
            <hr/>
            <label for="" id="birth" style="padding-left: 15px;">생년월일</label>
            <select id="year-select"></select>
            <select id="month-select"></select>
            <select id="day-select"></select>
            <hr/>
            <label for="" id="address" style="padding-left: 45px;">주소</label>
            <input type="text" name= "zipcode" id="postcode" placeholder="우편번호를 입력하세요">
            <button class="btn-secondary" onclick="searchZip()">우편번호검색</button>
            <input type="text" name="addr1" id="defaultAddress" placeholder="기본주소 입력"  class="form-control" style=width:300px;/>
            <input type="text" name="addr2"  placeholder="상세주소 입력" class="form-control"  style=width:200px;/>
            <hr/>
          </div>
          <ul class="non-list">
            <li>필수 정보에 대해 정확히 확인해 주시기 바랍니다.</li>
          </ul>
    </div>
    <div class="userWithdraw">
        <div class="user-delete">
            <h3 class="sub-underline">아이디 선택</h3>
            <div class="id-check">
                <input type="checkbox" name="" id="">
                <label for="">여기에 아이디 들어와야 하는데(체크박스 작동안함;)</label>
            </div>
        </div>
        <div class="delete-precaution">
            <h3 class="sub-underline2">유의사항</h3>
            <div class="row">
                <div class="warning">
                    <p>- 어쩌구 저쩌구</p>
                    <p>- 어쩌구 저쩌구</p>
                    <p>- 어쩌구 저쩌구</p>
                    <p>- 어쩌구 저쩌구</p>
                </div>
            </div>
        </div>
        <div class="delete-btn-center">
            <button class="cancle-btn">취소</button>
            <button class="delete-btn">탈퇴</button>
        </div>
    </div>
</div>
<!-- 회원 탈퇴 -->
  
    
    <!-- 푸터 -->
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

<!-- 자바 스크립트 -->
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- lodash cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- Swiper -->
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<!-- 우편 검색 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
     //회원 비회원 전환 버튼
    const updateBtn = document.querySelector(".tab-update");
    const deleteBtn = document.querySelector(".tab-delete");
    const selectBtn = document.querySelector(".tab-select");
    const ChangeBox = document.querySelector(".userChange");
    const WirhdrawBox = document.querySelector(".userWithdraw");
    const SearchBox = document.querySelector(".userSearch");

    updateBtn.addEventListener("click", function() {
      ChangeBox.style.display = "block";
      SearchBox.style.display = "none";
      WirhdrawBox.style.display = "none";
    });

    deleteBtn.addEventListener("click", function() {
      ChangeBox.style.display = "none";
      SearchBox.style.display = "none";
      WirhdrawBox.style.display = "block";
    });

    selectBtn.addEventListener("click", function() {
      SearchBox.style.display = "block";
      ChangeBox.style.display = "none";
      WirhdrawBox.style.display = "none";
    });

    // 생년월일 선택자
    const yearSelect = document.getElementById('year-select');
    const monthSelect = document.getElementById('month-select');
    const daySelect = document.getElementById('day-select');

        // 연도 범위 설정 (예: 1900-2023)
      const startYear = 1900;
      const endYear = 2023;

        // 연도 <select> 채우기
      for (let year = startYear; year <= endYear; year++) {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        yearSelect.appendChild(option);
      }

        // 월 <select> 채우기
      for (let month = 1; month <= 12; month++) {
        const option = document.createElement('option');
        option.value = month;
        option.textContent = month;
        monthSelect.appendChild(option);
      }

        // 일 <select> 채우기
      function fillDaySelect(days) {
        daySelect.innerHTML = '';
        for (let day = 1; day <= days; day++) {
          const option = document.createElement('option');
          option.value = day;
          option.textContent = day;
          daySelect.appendChild(option);
        }
      }

        // 기본값으로 31일로 설정
      fillDaySelect(31);

        // 월을 선택하면 대응하는 일 수로 변경
      monthSelect.addEventListener('change', function () {
        const selectedMonth = this.value;
        let days;
        if (selectedMonth === '2') {
          days = 28; // 윤년 계산은 생략
        } else if (['4', '6', '9', '11'].includes(selectedMonth)) {
          days = 30;
        } else {
          days = 31;
        }
        fillDaySelect(days);
      });

      // 우편 검색
      const searchZip=function()
      {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
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
                document.getElementById('postcode').value=data.zonecode;
                document.getElementById('defaultAddress').value=addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addr2").focus();
            }
        }).open();
      }

    // // TOP 누르면 최상단 이동
    // const toTopBtn_el = document.getElementById('to_top');
    //     toTopBtn_el.addEventListener('click',function(){
    //         window.scrollTo({top:0,behavior:'smooth'})
    //     })

    // // 스크롤시 메뉴 따라오기
    // // 좌측 광고
    // $(window).scroll(function(){
    // var scrollTop = $(document).scrollTop();
    // if (scrollTop < 300) {
    //   scrollTop = 300;
    // }
    //   $(".left_section").stop();
    //   $(".left_section").animate( { "top" : scrollTop });
    // });

    // // 우측 퀵메뉴
    // $(window).scroll(function(){
    // var scrollTop = $(document).scrollTop();
    // if (scrollTop < 200) {
    //   scrollTop = 200;
    // }
    //   $(".quick_section").stop();
    //   $(".quick_section").animate( { "top" : scrollTop });
    // });
    // // x표시 광고 끄기
    // // 버튼과 광고 요소 선택
    // const bannerCloseButton = document.querySelector('.banner_close');
    // const leftBanner = document.querySelector('.left_banner');

    // // 버튼 클릭 시 광고 숨기기
    // bannerCloseButton.addEventListener('click', function () {
    //   leftBanner.style.display = 'none';
    //   bannerCloseButton.style.display = 'none';
    // });

</script>

</body>
</html>