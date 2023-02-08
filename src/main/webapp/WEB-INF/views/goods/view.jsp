<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<head>

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
 <script
 	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
 <script
 	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
    <title>상품 상세보기</title>


    <!-- Global stylesheets -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/devicons/css/devicons.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">
  </head>


<!--====================================================
                  MODALS
======================================================-->


                               <div class="title-bar">
                                 <div class="col-md-12">
                              <form role="form" method="post">
                                <input type="hidden" name="gdsId" id="gdsId" value="${view.gdsId}" />

                                   <h2 class="text-center">${view.gdsName}</h2>
                                   <div class="heading-border"></div>
                                 </div>
                               </div>
                               <div class="row">
                                 <div class="col-md-6">
                                     <img class="img-fluid img-centered" src="displayFile?fileName=${view.gdsImage}"
                                      alt="">
                                 </div>
                                   <div class="col-md-6">
                                       <p>${view.gdsDes}</p>
                                       <ul class="view-inline item-details">
                                           <li class="gdsPrice" >가격:
                                               <strong value="${view.gdsPrice}">${view.gdsPrice} 원                                               </strong>
                                           </li>

                                           <c:if test="${view.gdsStock != 0}">

                                           <li class="cartStock" >구매 수량:
                                              <button type="button" class="plus">+</button>
                                              <input type="number" class="numBox" min="1" max="${view.gdsStock}" value="1" readonly="readonly"/>
                                              <button type="button" class="minus">-</button>
                                              <input type="hidden" value="${view.gdsStock}" class="gdsStock_hidden" /> </strong>

                                              <script src="/resources/bootstrap/stockBtn.js"></script>
                                           </li>
                                       </ul>


                                       <button class="btn btn-general btn-white" id="cartBtn" type="button">
                                            add cart!
                                       </button>


                                        <script>
                                        $("#cartBtn").on("click",function(){

                                          var gdsId = $("#gdsId").val();
                                          var CartStock = $(".numBox").val();

                                          var data = {
                                            gdsId : gdsId,
                                            CartStock : CartStock
                                            };

                                          $.ajax({
                                           url : "/goods/view/addCart",
                                           type : "post",
                                           data : data,
                                           success : function(data = 1){
                                            alert("카트 담기 성공");
                                            $(".numBox").val("1");
                                           },
                                           error : function(){
                                            alert("카트 담기 실패");
                                           }
                                          });
                                         });


                                        </script>

                                          </c:if>

						              <c:if test="${view.gdsStock == 0}">
						               	<p>상품 수량이 부족합니다.</p>
						              </c:if>
                                     </div>
                                </div>
                           </div>
                            </form>
                        </div>

