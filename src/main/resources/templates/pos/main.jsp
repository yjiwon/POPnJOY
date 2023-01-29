<!--로그인 페이지-->
<!-- login.html-->
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<html xmlns:th="http://www.thymeleaf.org" lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
layout:decoration = "pos/layout/pos_layout">
<th:block layout:fragment="content">
<head>
    <meta charset="UTF-8">
</head>
    <div th:if="${member == null}">
    <li>
    <a href = "/pos/signin"> 로그인 </a>
    </li>
    </div>

    <div th:if="${member != null}">

        <div th:if="${member.verify == 1}">
         <li>
             <a href="/admin/index">관리자 페이지</a>
         </li>
        </div>

            <li>
        ${member.userName}님 환영합니다.
                </li>

                <li>
                    <a href="/pos/cartList">카트 리스트</a>
            </li>
        <li>
            <a href="/pos/orderList">주문 리스트</a>
        </li>

    <li>
        <a href="/pos/signout"> 로그아웃 </a>
    </li>
    </div>
</th:block>
</html>