<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<th:block th:replace="pos/fragments/header :: headerFragment"></th:block>
<body>
<th:block layout:fragment="content"></th:block>
</body>
<th:block th:replace="pos/fragments/footer :: footerFragment"></th:block>
</html>