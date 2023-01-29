<!--로그인 페이지-->
<!-- login.html-->
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<head>
    <meta charset="UTF-8">
</head>
    <div th:if="${member == null}">
    <li>
    <a href = "/pos/signin"> 로그인 </a>
    </li>
    </div>
    <il>
    <div th:if="${member != null}">

        <div th:if="${member.verify == 1}">
         <li>
             <a href="/admin/index">관리자 페이지</a>
         </li>
        </div>
            <li>
        ${member.userName}님 환영합니다.
    </div>
    </il>
    <li>
        <a href="/pos/signout"> 로그아웃 </a>
    </li>
</th:block>
</html>