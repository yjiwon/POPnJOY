<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%@ include file="include/aside.jsp"%>


  <!--====================================================
                        리스트
    ======================================================-->

      <section class="resume-section p-3 p-lg-5 d-flex flex-column">
          <div class="row my-auto">
              <div class="col-12">
                <h2 class="text-center">MENU</h2>
                <div class="mb-5 heading-border"></div>
              </div>
                <div class="col-md-12">
                              <div class="port-head-cont">
                              </div>
                            </div>
                        </div>
         <div class=" row my-auto">
          <c:forEach items="${list}" var="list">
              <div class="col-md-4  portfolio-item">
                  <a class="col-md-4 portfolio-link" href="#Modal" data-toggle="modal">
                      <div class="caption-port">
                          <div class="caption-port-content"> </div>

                          </div>
                      </div>
                      <img class="img-fluid" src="displayFile?fileName=${list.gdsImage}">
                  </a>
                   </div>

<!--====================================================
                  MODALS
======================================================-->

        <!-- 팝콘 -->
    <div class="portfolio-modal modal fade" id="Modal" tabindex="-1" role="dialog" aria-hidden="true" >
      <div class="modal-dialog" role="document">
          <div class="modal-content">
              <div class="close-modal" data-dismiss="modal">
                  <div class="lr">
                      <div class="rl"></div>
                  </div>
              </div>
              <div class="container">
                  <div class="row">
                          <div class="modal-body">
                              <div class="title-bar">
                                <div class="col-md-12">
                                  <h2 class="text-center">${list.gdsName}</h2>
                                  <div class="heading-border"></div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-md-6">
                                    <img class="img-fluid img-centered" value="${list.gdsImage}" alt="">
                                </div>
                                  <div class="col-md-6">
                                      <p>${list.gdsDes}</p>
                                      <ul class="list-inline item-details">
                                          <li>가격:
                                              <strong value="${list.gdsPrice}"> 원

                                              </strong>
                                          </li>
                                      </ul>
                                      <button class="btn btn-general btn-white" type="button" data-dismiss="modal">
                                          <i class="fa fa-times"></i> 카트담기
                                      </button>
                              </div>
                            </div>
                          </div>
                  </div>
              </div>
          </div>
      </div>
    </div>
 </c:forEach>

         <!-- Global javascript -->

       <script>
           $(document).ready(function(){

           $(".filter-b").click(function(){
               var value = $(this).attr('data-filter');
               if(value == "all")
               {
                   $('.filter').show('1000');
               }
               else
               {
                   $(".filter").not('.'+value).hide('3000');
                   $('.filter').filter('.'+value).show('3000');
               }
           });

           if ($(".filter-b").removeClass("active")) {
             $(this).removeClass("active");
           }
           $(this).addClass("active");
           });

               <!-- 카트담기 -->

    $(".btn btn-general btn-white").click(function(){
     var gdsNum = $("#gdsId").val();
     var cartStock = $(".numBox").val();

     var data = {
       gdsNum : gdsNum,
       cartStock : cartStock
       };

     $.ajax({
      url : "/shop/list/addCart",
      type : "post",
      data : data,
      success : function(result){

       if(result == 1) {
        alert("카트 담기 성공");
        $(".numBox").val("1");
       } else {
        alert("카트에 담긴 상품이 없습니다.")
        $(".numBox").val("1");
       }
      },
      error : function(){
       alert("카트 담기 실패");
      }
     });
    });

    </script>


              </div>
              </div>
      </section>

