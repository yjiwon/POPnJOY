<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="include/aside.jsp"%>

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
 <script
 	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
 <script
 	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>


.listResult { padding:20px; background:#eee; }
.listResult .sum { float:left; width:45%; font-size:22px; }
.listResult { font-family:'맑은 고딕', verdana; padding:20; margin:0; }

.listResult .orderOpne { float:right; width:45%; text-align:right; }
.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
.listResult::after { content:""; display:block; clear:both; }

.modal{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);

.modal-backdrop {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 1040;
    background-color: #a9a8a887;

</style>


  <section class="resume-section p-3 p-lg-5 ">
            <div class="row my-auto">
                <div class="col-12">
                  <h2 class="  text-center">My cart</h2>
                  <div class="mb-5 heading-border"></div>
                </div>

               <c:forEach items= "${cartList}" var="cart">
                <div class="resume-item col-md-6 col-sm-12 ">
                  <div class="card mx-0 p-4 mb-5" style="border-color: #17a2b8; box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.21);">
                    <div class=" resume-content mr-auto">
                        <h4 class="mb-3"> ${cart.gdsName} </h4>
                        <p>
                        <span> stock : </span> ${cart.cartStock} 개 <br/>
                        <span> price :  </span> <fmt:formatNumber pattern="###,###,###" value="${cart.gdsPrice * cart.cartStock}" /> 원
                        </p>
                    </div>
                    <div class="resume-date text-md-right">
                      <a onclick ="deleteCart(${cart.cartNum})"> <i class="btn btn-general btn-white"> DELETE </i></a>
                    <script>
                                         $(document).ready(function(){


                                        var cartNum = $("#cartNum").val();

                                         });
                                          function deleteCart(cartNum){
                                           if (confirm("정말 삭제하시겠습니까?")) {

                                         	$.ajax({
                                         		type : "POST",
                                         		url : "/goods/deleteCart",
                                         		dataType : "json",
                                         		data : {"cartNum" : cartNum},
                                         		error : function(request, status, error){
                                                 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                                         		},
                                         		success : function(data){
                                         			if(data = 1){
                                         				alert("삭제완료");
                                         				location.reload();
                                         				}
                                         			}


                                         	});
                                          }
                                          }
                     			</script>

                            </div>
                           </div>
                         </div>
                       <c:set var="sum" value="${sum + (cart.gdsPrice * cart.cartStock)}" />
                      </c:forEach>
                    </div>
                  </div>
                </div>
              </div>


                <div class="listResult">
                 <div class="sum">
                  Total : <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
                 </div>
                 <div class="orderOpne">
                  <button type="button" id="modal_show" data-toggle="modal" data-target="#orderModal"
                 class="orderOpen_bnt">주문 정보 입력</button>

                    <script>
                     $("#orderOpen_bnt").on("click",function(){
                                $("#orderModal").modal("show");
                            });
                    </script>

                 </div>
                </div>

                 <!-- 폰번호 입력 Modal -->
                   <form role="form" method="post" autocomplete="off">
                   <input type="hidden" name="amount" value="${sum}" />

                    <div class="modal" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"> 주문하기 </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">


					      <div class="inputArea">
                        <label for="orderPhone">연락처를 입력하세요 : </label>
                         <input type="text" name="orderPhone" id="orderPhone" required="required" />
                    	 </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">주문하기</button>

                                </div>
                            </div>
                        </div>
                    </div>


                        <script>
                        $(document).ready(function() {
                             $("#close_modal").click(function() {
                                $("#orderModal").modal("hide");
                            });
                        });
                      </script>


         </form>



        </section>