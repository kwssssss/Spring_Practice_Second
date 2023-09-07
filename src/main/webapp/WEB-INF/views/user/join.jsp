<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입!!!!!</h1>
	<form method="POST"> <!-- action 생략시 현재 url로 서브밋, PostMapping과 GetMapping url이 같음 --> 
		회원 ID: <input type="text" name="userid" value="입력해주세요"><br> <!-- DTO의 멤버네임과 input의 네임 일치해야함 -->
		회원 비밀번호: <input type="password" name="password" value="입력해주세요"><br> <!--value: 기본값 설정  -->
		회원 비밀번호: <input type="password" name="password2" value="입력해주세요"><br>
		회원 email: <input type="email" name="email" value="입력해주세요"><br>
		취미:
			<input type="checkbox" name="hobbies" value="축구" checked> 축구
			<input type="checkbox" name="hobbies" value="농구"> 농구
			<input type="checkbox" name="hobbies" value="테니스"> 테니스
			<input type="checkbox" name="hobbies" value="헬스"> 헬스
			<input type="checkbox" name="hobbies" value="여행"> 여행
			<input type="checkbox" name="hobbies" value="독서"> 독서
			<br>
		생일: <input type="text" name="birthDate" placeholder="yyyy-MM-dd" value="2000-04-04"><br>
			
		<input type="submit">
	</form>
</body>
</html>