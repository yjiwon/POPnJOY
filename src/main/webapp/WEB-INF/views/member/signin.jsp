<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Admin Page</title>

	<link rel="stylesheet" href="/resources/css/signin.css">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="main">
<p class="sign" align="center">Admin Page Login</p>
    	<form role="form" method="post" autocomplete="off" class="form1">
    			<input type="text" class="un" align="center" id="userId" name="userId" placeholder="아이디" />
    			<input type="password" class="pass" align="center" id="userPass" name="userPass" placeholder="비밀번호" />
    		<button type="submit" class="submit" align="center" >로그인</button>

    		<c:if test="${msg == false}">
    			<p style="color:#f00;" align="center" >아이디 또는 패스워드를 확인하세요.</p>
    		</c:if>
    	</form>

		</div>

</body>
</html>