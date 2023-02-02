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

         <div class="row my-auto">
               <c:forEach items="${list}" var="list">
              <div class="col-md-4 portfolio-item">
                  <a class=" portfolio-link" href="#Modal" data-toggle="modal">
                      <div class="caption-port">
                          <div class="caption-port-content"> </div>
                      <img class="img-fluid" src="displayFile?fileName=${list.gdsImage}">
                          </div>
                      </div>
                  </a>
                  </c:forEach>
                   </div>

<!--====================================================
                  MODALS
======================================================-->

      </section>

