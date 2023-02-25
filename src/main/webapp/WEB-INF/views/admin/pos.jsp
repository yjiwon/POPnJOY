<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Admin OrderList page</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
	body { font-family:'맑은 고딕', verdana; padding:10; margin:0; }
	ul { padding:0; margin:0; list-style:none;  }

	div#root { width:90%; margin:0 auto; }

	header#header { font-size:45px; padding:20px 0; }
	header#header h1 a { color:#000; font-weight:bold; }

 		section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:0px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	aside { float:left; width:100px; }
	div#container_box { float:left; width:calc(50% - 110px - 20px); }

</style>


<style>
/*
#container_box table { width:900px; }
#container_box table th { font-size:20px; font-weight:bold;
							text-align:center; padding:10px; border-bottom:2px solid #666; }
#container_box table tr:hover { background:#eee; }
#container_box table td { padding:10px; text-align:center; }
#container_box table img { width:150px; height:auto; }
*/
	div#container_box ul li { border:0px solid #eee; padding:10px 25px; margin-bottom:30px; }
	div#container_box .orderList span { font-size:50px; font-weight:bold; display:inline-block; width:150px; margin-right:10px; }

	.button { text-align:right; }
    	.complete { font-size:16px; background:#fff; border:1px solid #999; margin-left:10px; }
</style>


</head>
<body>
<div id="root">

<header id="header">
		<div id="header_box">
			음식이 준비 완료 되었습니다. 주문 번호를 확인하세요!
		</div>
	</header>

	<section id="container">

		<div id="container_box">

		<ul class="orderList">
				<c:forEach items="${orderList}" var="orderList">
				<c:if test="${orderList.delivery == 1}">
				<li>
				<div>
				<span>${orderList.orderId}</span>

				</div

				</li>
				</c:if>
				</c:forEach>

			</ul>

		</div>
	</section>

</div>

</body>
</html>