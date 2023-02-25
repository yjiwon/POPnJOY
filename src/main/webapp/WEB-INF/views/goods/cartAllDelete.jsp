<%@ page contentType="text/html; charset=utf-8"%>

 <c:forEach items= "${cartList}" var="cart">
<script>
const orderId = "${cart.orderId}";
	alert("고객님의 주문번호는"+ orderId + "번 입니다.");
	location.href="${pageContext.request.contextPath}/goods/index";
</script>
</c:forEach>