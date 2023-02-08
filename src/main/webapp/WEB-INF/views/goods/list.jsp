<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="include/aside.jsp"%>

<script type= "text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>

   <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />


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

         <div class="row my-auto">
               <c:forEach items="${list}" var="list">
              <div class="col-md-4 portfolio-item">
                  <a class="portfolio-link" href="/goods/view?n=${list.gdsId}" data-toggle="modal">

                      <div class="caption-port">
                          <div class="caption-port-content"> </div>
                        <!--  <i class="fa fa-search-plus fa-3x"></i> -->
                      <img class="img-fluid" src="displayFile?fileName=${list.gdsImage}">
                          </div>
                      </div>
                  </a>
                  </c:forEach>
                   </div>
                        </section>


<!--====================================================
                  MODALS
======================================================-->

    <div class="portfolio-modal modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true" >
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
                      <!--jsp 들어올 곳-->

              </div>
          </div>
      </div>
    </div>



<script>
 $(".portfolio-link").click(function(){

  var formObj = $(".modal-body form[role='form']");
  var gdsId = $("#gdsId").val();

  var data = {
    gdsId : gdsId,

    };

  $.ajax({
   url : "/goods/view",
   type : "post",
   data : data,
   success : function()
   modal();
  });
 });
</script>