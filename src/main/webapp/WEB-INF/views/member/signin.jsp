<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Admin Page</title>


</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../admin/include/header.jsp" %>
		</div>
	</header>

	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../admin/include/nav.jsp" %>
		</div>
	</nav>
	<section id="container">
	<section id="content">
    	<form role="form" method="post" autocomplete="off">
    		<div class="input_area">
    			<label for="userId">아이디</label>
    			<input type="text" id="userId" name="userId" />
    		</div>

    		<div class="input_area">
    			<label for="userPass">패스워드</label>
    			<input type="password" id="userPass" name="userPass" />
    		</div>

    		<button type="submit" id="signin_btn" name="signin_btn">로그인</button>

    		<c:if test="${msg == false}">
    			<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 확인하세요.</p>
    		</c:if>
    	</form>

    </section>
		</div>
	</section>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../admin/include/footer.jsp" %>
		</div>
	</footer>

</div>
</body>
</html>