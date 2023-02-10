<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
    </style>

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
    <title>매점 주문하기</title>

    <!-- Global stylesheets -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/devicons/css/devicons.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">
  </head>

  <body id="page-top">

  <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
    <a class="navbar-brand js-scroll-trigger" href="/goods/cartList">
      <span class="d-block d-lg-none  mx-0 px-0"><img src="img/logo-white.png" alt="" class="img-fluid"></span>
      <span class="d-none d-lg-block">
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" th:src="img/order.png"
            href="/goods/orderList" alt="">
        </span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" name="gdsCat" id="gdsCat">
      <ul class="navbar-nav">

        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/goods/list?c=popcorn">POPCORN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/goods/list?c=drink">DRINK</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/goods/list?c=hotdog">HOT DOG</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/goods/list?c=snack">SNACK</a>
        </li>
        &nbsp;
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger"  href="/goods/index">EXIT</a>
        </li>
      </ul>
    </div>
  </nav>
