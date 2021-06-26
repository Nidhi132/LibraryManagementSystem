<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>BookWorld</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons 
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">-->

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  
  

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Sailor - v2.3.1
  * Template URL: https://bootstrapmade.com/sailor-free-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center">

      <h1 class="logo1"  style="color:#E30B5C"><a href="${pageContext.request.contextPath}/site?page=home">BookWorld</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav class="nav-menu d-none d-lg-block">

        <ul>
          <li><a href="${pageContext.request.contextPath}/site?page=home">HOME</a></li>

          <li class="drop-down"><a href="#">Admin</a>
            <ul>
              
              <!--  <li><a href="${pageContext.request.contextPath}/site?page=home">HOME</a></li>-->
          <li><a href="${pageContext.request.contextPath}/admin?page=signup">Sign Up</a></li>
          <li><a href="${pageContext.request.contextPath}/admin?page=login">Login</a></li>

          
        </ul>
        <li class="drop-down"><a href="#">User</a>
            <ul>
              
              <!--  <li><a href="${pageContext.request.contextPath}/site?page=home">HOME</a></li>-->
          <li><a href="${pageContext.request.contextPath}/usercon?page=signup">Sign Up</a></li>
          <li><a href="${pageContext.request.contextPath}/usercon?page=login">Login</a></li>

          
        </ul>
        
        <li class="drop-down"><a href="#">Book List</a>
            <ul>
           <li><a href="${pageContext.request.contextPath}/book?page=1">Programming languages</a></li>
            <li><a href="${pageContext.request.contextPath}/book?page=2">Web related</a></li>
             <li><a href="${pageContext.request.contextPath}/book?page=3">Data structures</a></li>
            <li><a href="${pageContext.request.contextPath}/book?page=4">General</a></li>
          </ul>
          
         <li><a href="${pageContext.request.contextPath}/site?page=home">LogOut</a></li> 
        
        </ul>

      </nav><!-- .nav-menu -->

    

    </div>
  </header><!-- End Header -->