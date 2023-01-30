<!--로그인 페이지-->
<!-- login.html-->
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<th:block layout:fragment="content">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="container">
    <h1>로그인</h1>
    <form th:action="@{/signin}" method="post">
        <div class="form-group">
            <label th:for="userId">아이디</label>
            <input type="text" name="userId" class="form-control" placeholder="아이디 입력해주세요">
        </div>
        <div class="form-group">
            <label th:for="userPass">비밀번호</label>
            <input type="userPass" class="form-control" name="userPass" placeholder="비밀번호 입력해주세요">
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
    <br/>
</div>
</body>
    </th:block>
</html>