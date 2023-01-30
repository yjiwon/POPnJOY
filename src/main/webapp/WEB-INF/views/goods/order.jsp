<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/aside.jsp"%>


  <section class="resume-section p-3 p-lg-5 d-flex flex-column">
            <div class="row my-auto">

             <form role="form" method="post" autocomplete="off">
               <input type="hidden" name="amount" value="${sum}" />
               <input type="hidden" name="orderId" value="orderId" />


              <div class="col-md-8">
                <div class="contact-cont">
                  <h3>주문자 연락처 입력</h3>
                  <div class="heading-border-light"></div>
                  <p>
                  </p>
                </div>
                <div class="row con-form">
                  <div class="col-md-12">
                    <input type="text" name="orderPhone" id="orderPhone" placeholder="연락처 입력"  required="required class="form-control">
                  </div>
                  <div class="col-md-12 sub-but">
                  <button type="submit" class="btn btn-general btn-white">주문하기</button></div>
                </div>
              </div>

              <div class="col-md-4 col-sm-12 mt-5">
                <div class="contact-cont2">
                  <div class="contact-add contact-box-desc">
                    <h3><i class="fa fa-map-marker cl-atlantis fa-2x"></i> 음식 받기 </h3>
                    <p> 문자가 도착하면 매점으로 와 주세요 </p>
                  </div>
                  </div>
                </div>
              </div>
            </div>
        </section>