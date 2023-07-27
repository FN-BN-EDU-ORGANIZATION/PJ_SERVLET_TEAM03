<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/view/CSS/login.css" />
</head>
<body>

<h1>LOGIN PAGE</h1>
        <!-- 로그인 -->
        <div class="login-contents">
          <div class="login-main">
            <ul class="login-ul">
              <li class="active">
                <button type="button" class="tab-member-btn">
                  <span>회원</span>
                </button>
                <button type="button" class="tab-nonmember-btn">
                  <span>비회원</span>
                </button>
                <div class="tab_con">
                  <div class="login-member">
                    <div class="contents_inner">
                      <div class="login-box">
                        <p class="tip">
                          기능이 제한된 비회원으로도 로그인이 가능합니다.
                        </p>
                        <form action="#" method="post">
                          <div class="login-area">
                            <input type="text" id="userid" maxlength="30" placeholder="아이디를 입력해 주세요."required/>
                            <br/>
                            <input type="password" id="userpw" maxlength="20" placeholder="비밀번호를 입력해 주세요." required/>
                            <button type="button" class="login-btn">로그인</button>
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
                              <a href="#none"><img src="./image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
                            </div>
                            <div class="swiper-slide">
                              <!-- 광고 이미지 -->
                              <a href="#none"><img src="./image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
                            </div>
                            <div class="swiper-slide">
                              <!-- 광고 이미지 -->
                              <a href="#none"><img src="./image/q858v6_s5qv-ya5to3_logo.png" alt=""></a>
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



</body>
</html>