<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="width: 900px; margin-left: 300px; margin-top:-40px;">
        <h2 style=margin-top:50px;>회원가입</h2>
        <br>
        <h1>회원가입을 위해 <br>휴대폰 본인 인증해주세요.</h1>

        <div class="first"><strong>인증정보입력</strong></div><hr>
        <div>
            <label for="name"><span class="con">이름 : </span></label><input type="text" placeholder="한글 또는 영문"><hr>
        </div>    
        <div>
        <label for="birth"><span class="con">생년월일 : </span></label><input type="text" placeholder="생년월일 입력"><hr>
        </div>
        <div>
            <label for=""><span class="con">성별 : </span></label><input type="radio" name="gender" value="man"> 남 <input type="radio"
                    name="gender" value="woman"> 여<hr>
        </div>
        <div>
            <label for="phone"></span>휴대폰번호 : </label>
            <div>
                <select name="통신사">
                    <option value="SKT">SKT</option>
                    <option value="KT" selected>KT</option>
                    <option value="LG" >LG</option>
                </select>
                <select name="ph--ln">
                    <option value="010" selected>010</option>
                    <option value="011">011</option>
                    <option value="018">018</option>
                </select>
                <span> - </span>
                <input type="tel" pattern="[0-9]{3,4}"  required />
                <span> - </span>
                <input type="tel" pattern="[0-9]{4}" required />

                <input type="button" value="인증">

            </div>
            <hr>
        </div>
        <div>
            <label for="addr"><span class="con">주소 : </span></label><input type="text" placeholder="주소 입력">
        </div>
        <hr>
        <div>
            <label for="id"><span class="con">ID : </span></label><input type="text">
        </div>
        <br>
        <div>
            <label for="pw"><span class="con">PASSWORD : </span></label><input type="password" placeholder="********">
        </div>
        <div style= "display: flex; justify-content: center; margin-top: 40px;">
        <input type="button" style="background-color: red;" value="취소">
        <input type="button" value="회원가입" style="margin-left: 5px;">
        </div>
    </div>	
</body>
</html>