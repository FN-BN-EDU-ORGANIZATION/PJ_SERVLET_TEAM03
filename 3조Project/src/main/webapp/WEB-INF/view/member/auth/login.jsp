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
<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
 	<!-- 제이쿼리 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- lodash cdn -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- Swiper -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/><script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
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
                    <li><a href="" style="width:35px"><img src="resources/image/유튜브.png" alt="유튜브로고"></a></li>
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

        <!-- 로그인 -->
        <div class="login-contents">
          <div class="login-main">
            <ul class="login-ul">
              <li class="active">
              <div class="button">
                <button type="button" class="tab-member-btn">
                  <span class>회원</span>
                </button>
                <button type="button" class="tab-nonmember-btn">
                  <span>비회원</span>
                </button>
                </div>
                <div class="tab_con">
                  <div class="login-member">
                    <div class="contents_inner">
                      <div class="login-box">
                        <p class="tip">
                          기능이 제한된 비회원으로도 로그인이 가능합니다.
                        </p>
                        <form action="" method="post">
                          <div class="login-area">
                            <input type="text" id="userid" maxlength="30" placeholder="아이디를 입력해 주세요."required/>
                            <br/>
                            <input type="password" id="userpw" maxlength="20" placeholder="비밀번호를 입력해 주세요." required/>
                            <button type="submit" class="login-btn">로그인</button>
                          </div>
                        </form>
                        <div class="login-bot">
                          <div class="login-check">
                            <input type="checkbox" name="logincheck" id="checksavedid"/>
                            <label for="checksavedid">아이디 저장</label>
                          </div>
                          <div class="login-menu">
                            <a href="#">회원가입</a>
                            <a href="#">아이디 찾기</a>
                            <a href="#">비밀번호 찾기</a>
                          </div>
                        </div>
                      </div>
                      <section class="f-section">
                        <div class="swiper">
                          <div class="swiper-wrapper">
                            <div class="swiper-slide">
                              <!-- 광고 이미지 -->
                              <a href="#none"><img src="resources/image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
                            </div>
                            <div class="swiper-slide">
                              <!-- 광고 이미지 -->
                              <a href="#none"><img src="resources/image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
                            </div>
                            <div class="swiper-slide">
                              <!-- 광고 이미지 -->
                              <a href="#none"><img src="resources/image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
                            </div>
                          </div>
                        </div>
                    </section>
                    </div>
                  </div>
                </div>
              </li>
              <!-- <li class="nonactive">
                <button type="button" class="tab-nonmember-btn">
                  <span>비회원</span>
                </button>
              </li>
              <li class="wrap-underline">
                <span class="nav-underline"></span>
              </li> -->
            </ul>
          </div>
        </div>
          <!-- 하단 광고 배너 -->
      <div class="banner_section">
        <div class="bot_banner">
          <!-- 광고 이미지 -->
          <a href=""><img src="" alt=""></a>
        </div>
      </div>
      <!-- 왼쪽 사이드 배너 -->
      <div class="left_section">
        <div class="left_banner">
          <!-- 광고 배너 이미지 -->
          <a href=""><img src="resources/image/RUBYGILLMAN_145145.png" alt=""></a>
        </div>
        <!-- 광고 닫는 버튼 -->
        <button class="banner_close"></button>
      </div>
      <!-- 오른쪽 사이드 배너 -->
      <div class="quick_section">
        <div class="quick_menu">
          <!-- 퀵메뉴 이미지 -->
          <a href="#none"><img src="resources/image/961c9cbf311b4f1299827c21a61fab76.png" alt=""></a>
          <a href="#none"><img src="resources/image/c1dbce4f91e948498c7c78239b7157ac.png" alt=""></a>
          <a href="#none"><img src="resources/image/c793af89f3b648aa99cc679186ccfa02.png" alt=""></a>
          <!-- 최상단 올라가기 버튼 -->
          <a href="#none" class="quick_top" id="to_top">TOP</a>
        </div>
      </div>
      <!-- 로그인 끝 -->

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
    <script>
    // TOP 누르면 최상단 이동
    const toTopBtn_el = document.getElementById('to_top');
        toTopBtn_el.addEventListener('click',function(){
            window.scrollTo({top:0,behavior:'smooth'})
        })
    // 스크롤시 메뉴 따라오기
    // 좌측 광고
    $(window).scroll(function(){
    var scrollTop = $(document).scrollTop();
    if (scrollTop < 300) {
      scrollTop = 300;
    }
      $(".left_section").stop();
      $(".left_section").animate( { "top" : scrollTop });
    });
    // 우측 퀵메뉴
    $(window).scroll(function(){
    var scrollTop = $(document).scrollTop();
    if (scrollTop < 200) {
      scrollTop = 200;
    }
      $(".quick_section").stop();
      $(".quick_section").animate( { "top" : scrollTop });
    });
    // x표시 광고 끄기
    // 버튼과 광고 요소 선택
    const bannerCloseButton = document.querySelector('.banner_close');
    const leftBanner = document.querySelector('.left_banner');

    // 버튼 클릭 시 광고 숨기기
    bannerCloseButton.addEventListener('click', function () {
      leftBanner.style.display = 'none';
      bannerCloseButton.style.display = 'none';
    });

    // 우측 광고 이미지 넘기기
    const swiper_vertical = new Swiper(".f-section .swiper", {
        // Optional parameters
        direction: "vertical",
        autoplay: {
          delay: 1000,
        },
        loop: true,
      });

      // 하단 광고 이미지 랜덤 표시
      let bottomBanner = Math.floor(Math.random() * 3);
      let imgName = ['RUBYGILLMAN_980180', 'Conan_980180', 'Metamorphosis_980180'];
      $('.bot_banner').children('a').children('img').attr('src', './image/' + imgName[bottomBanner] + '.jpg');
    </script>
    
</body>
</html>