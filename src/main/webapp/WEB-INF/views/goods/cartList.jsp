<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/aside.jsp"%>

<style>
.listResult { padding:20px; background:#eee; }
.listResult .sum { float:left; width:45%; font-size:22px; }
.listResult { font-family:'맑은 고딕', verdana; padding:20; margin:0; }

.listResult .orderOpne { float:right; width:45%; text-align:right; }
.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
.listResult::after { content:""; display:block; clear:both; }
</style>


  <section class="resume-section p-3 p-lg-5 ">
            <div class="row my-auto">
                <div class="col-12">
                  <h2 class="  text-center">My Cart</h2>
                  <div class="mb-5 heading-border"></div>
                </div>

                <c:forEach items="${cart}" var="cart">
                <div class="resume-item col-md-6 col-sm-12 ">
                  <div class="card mx-0 p-4 mb-5" style="border-color: #17a2b8; box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.21);">
                    <div class=" resume-content mr-auto">
                        <h4 class="mb-3"> ${cart.gdsName} </h4>
                        <p>
                        <span> stock : </span> ${cart.cartStock} 개 <br/>
                        <span> price :  </span> <fmt:formatNumber pattern="###,###,###" value="${cart.gdsPrice * cart.cartStock}" />
                         ${cart.gdsPrice * cart.cartStock} 원
                        </p>
                    </div>
                    <div class="resume-date text-md-right">
                        <button type="button"  class="delete_btn"> 삭제 </button>
                        <button type="button"  class="delete_btn"> 삭제 </button>
                     <script>
                     	$("#delete_Btn").click(function(){

                     						var con = confirm("정말로 삭제하시겠습니까?");

                     						if(con) {
                     							formObj.attr("action", "/shop/deleteCart");
                     							formObj.submit();
                     						}
                     					});
                     				</script>
                    </div>
                     </div>
                    </div>
                    </div>
                  </div>
                </div>
              </div>
              <c:set var="sum" value="${sum + (cart.gdsPrice * cart.cartStock)}" />
                </c:forEach>

                <div class="listResult">
                 <div class="sum">
                  총 합계 : <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
                 </div>
                 <div class="orderOpne">
                  <button type="button" class="orderOpne_bnt">주문 정보 입력</button>
                 </div>
                </div>
        </section>