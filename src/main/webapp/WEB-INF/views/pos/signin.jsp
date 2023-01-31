<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>login page</title>
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="include/header.jsp" %>
		</div>
	</header>

<div class="container">
    <h1>로그인</h1>
    <form role="form" method="post" autocomplete="off">
        <div class="form-group">
            <label th:for="userId">아이디</label>
            <input type="text" id="userId" name="userId" class="form-control" placeholder="아이디 입력해주세요">
        </div>
        <div class="form-group">
            <label th:for="userPass">비밀번호</label>
            <input type="userPass" class="form-control" name="userPw" id="userPw"  placeholder="비밀번호 입력해주세요">
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>

        	<c:if test="${msg == false}">
        			<p style="color:#f00;">로그인에 실패했습니다.</p>
        		</c:if>

    </form>
    <br/>

		</div>
	</section>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="include/footer.jsp" %>
		</div>
	</footer>
</div>
</body>
</html>