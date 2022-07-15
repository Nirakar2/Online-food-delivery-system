<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>OFODS</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

 
</head>

<body>

  <!-- header here   -->
  <jsp:include page="header.jsp"></jsp:include>
  
  <!-- ======= Gap Section ======= -->
  <section id="hero" class="d-flex align-items-center">
    <div class="container position-relative text-center text-lg-left" data-aos="zoom-in" data-aos-delay="100">
      <div class="row">
        <div class="col-lg-8">
         User Registration
        </div>
     </div>
    </div>
  </section><!-- End Gap -->
  
  
  <main id="main">

 	<div class="row">
 	<div class="col-lg-9 col-md-12">
 	<div class="card">
 	<div class="card-header">Register new user</div>
 	<div class="card-body">
 	<form method="post" action="${pageContext.request.contextPath }/signup">
 	<div class="form-group">
 	<div class="form-control">

 	<input type="text" name="firstName" placeholder="Enter first name" required >
 	
 	<input type="text" name="firstName" placeholder="Enter first name" required >
 	</div>
 	</div>
 	
 	<div class="form-group">
 	<div class="form-control">

 	<input type="email" name="email" placeholder="Enter email address" required >
 	<label> Gender: </label>
 	<input type="radio" name="gender" value="Male" checked > &nbsp;Male&nbsp;
 	<input type="radio" name="gender" value="Female" > &nbsp;Female&nbsp;
 	<input type="radio" name="gender" value="Others" > &nbsp;Others&nbsp;
 	</div>
 	</div>
 	
 	<div class="form-group">
 	<div class="form-control">
 	<input type="text" name="username" placeholder="Enter username" required > 	
 	<input type="password" name="password" placeholder="Enter password" required >
 	<input type="password" name="confirmPassword" placeholder="Confirm password" required >
 	</div>
 	</div>
 	
 	<div class="form-group">
 	<div class="form-control">
 	<select name="authority" >
 	<option value="USER"> User </option>
 	<option value="ADMIN"> Administrator </option>
 	</select>
 	</div>
 	</div>
 	
 	<div class="form-group">
 	<div class="form-control">
 	<input type="submit" class="btn btn-primary" value="Submit" > 	
 	<input type="reset" class="btn btn-info" value="Reset" > 
 	</div>
 	</div>	
 	</form>
 	</div>
 	</div>
 	</div>
 	</div>
  
  
  </main>
  
  
  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="footer-info">
              <h3>Online Food OrderingAnd Delivery System</h3>
              <p>
                Pradarsani Marg <br>
                KTM 44600, Nepal<br><br>
                <strong>Phone:</strong> +977 014455667789<br>
                <strong>Email:</strong> info@ofods.com<br>
              </p>
              <div class="social-links mt-3">
                <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
              </div>
            </div>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Privacy policy</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Our Services</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Web Design</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Web Development</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Product Management</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Graphic Design</a></li>
            </ul>
          </div>

          <div class="col-lg-4 col-md-6 footer-newsletter">
            <h4>Our Newsletter</h4>
            <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>
            <form action="" method="post">
              <input type="email" name="email"><input type="submit" value="Subscribe">
            </form>

          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>OFODS</span></strong>. All Rights Reserved
      </div>
   </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top"><i class="bx bx-up-arrow-alt"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>

  
  