<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--====================================================
                  MODALS
======================================================-->

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

                   <!--     <c:forEach items="${view}" var="view"> -->
                              <div class="title-bar">
                                <div class="col-md-12">
                                  <h2 class="text-center">${view.gdsName}</h2>
                                  <div class="heading-border"></div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-md-6">
                                    <img class="img-fluid img-centered" value="displayFile?fileName=${view.gdsImage}"
                                     alt="">
                                </div>
                                  <div class="col-md-6">
                                      <p>${view.gdsDes}</p>
                                      <ul class="view-inline item-details">
                                          <li>가격:
                                              <strong value="${view.gdsPrice}"> 원                                               </strong>
                                          </li>
                                      </ul>
                                      <button class="btn btn-general btn-white" type="button" data-dismiss="modal">
                                          <i class="fa fa-times"></i> 카트담기
                                      </button>
                              </div>
                            </div>
                 <!--        </c:forEach> -->
                          </div>
                  </div>
              </div>
          </div>
      </div>
    </div>
</c:forEach>

<!-- Global javascript -->
       <script ="resources/js/jquery/jquery.min.js"></script>
       <script ="resources/js/bootstrap/bootstrap.bundle.min.js"></script>
       <script ="resources/js/jquery-easing/jquery.easing.min.js"></script>
       <script ="resources/js/counter/jquery.waypoints.min.js"></script>
       <script ="resources/js/counter/jquery.counterup.min.js"></script>
       <script ="resources/js/custom.js"></script>
       <script>
           $(document).ready(function(){

           $(". portfolio-link").click(function(){
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
      url : "/shop/view/addCart",
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

