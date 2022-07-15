<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>OFODS | Dashboard</title>

   <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/plugins/summernote/summernote-bs4.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="${pageContext.request.contextPath }/assets/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
  <jsp:include page="navbar.jsp"></jsp:include>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
 <jsp:include page="sidebar.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Menu Item</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin</a></li>
              <li class="breadcrumb-item active">Item</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        
        <!-- page content here -->
        <div class="row">
        <div class="col-lg-9 col-md-12">
       <!--  form in a card -->
       
       <c:choose>
       <c:when test="${edit eq true }">
       
       <!-- add-form -->
        <div class="card">
        <div class="card-header"> 
         <h3 class="card-title">Update Item</h3>
        </div>
        <div class="card-body">
        <form class="form-primary" modelAttribute="item"
        	action="${pageContext.request.contextPath }/admin/category/update" method="post">
        	
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	
        	<div class="form-group">
        	<label>Item Id: </label>
        	<input class="form-control" type="text" name="itemId" value="${olditem.itemId }" readonly/>
        	</div>
        	
        	<div class="form-group">
        	<label>Title: </label>
        	<input class="form-control" type="text" name="name" value="${olditem.name }" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Description: </label>
        	<input class="form-control" type="text" name="description" value="${olditem.description }" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Price: </label>
        	<input class="form-control" type="text" name="price" value="${olditem.price }" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Item Code: </label>
        	<input class="form-control" type="text" name="itemCode" value="${olditem.itemCode }" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Available: </label>
        	<select class="form-control" name="available" >
        	<option value="YES"><c:if test="${olditem.available eq 'YES' }"> Available </c:if></option>
        	<option value="NO"><c:if test="${olditem.available eq 'NO' }"> Not Available </c:if></option>
        	</select>
        	</div>
        	
        	
        	<div class="form-group">
        	<label>Category: </label>
        	<select class="form-control" name="parentCat" >
        	
        	<c:forEach items="${categorylist }" var="cat">
        		<c:if test="${cat.parentCat ne 0 }">   <!-- show only sub categories -->
        		<option value="${cat.catId }"  <c:if test="${olditem.category.id eq cat.catId }">selected</c:if>> ${cat.name } </option>
        		</c:if>
        	</c:forEach>
        	<!-- options for subcategory dynamically generated using JSTL -->
        	</select>
        	</div>
        	
        	<div class="form-group">
        	<label>Item Images: </label>
        	<div class="class="form-control">
        	<label>Regular: Original(${olditem.images[1]})</label>
        	<input  type="file" name="images" placeholder="Update item images" required/>
        	</div>
        	<div class="class="form-control">
        	<label>Small:  Original(${olditem.images[0]})</label>
        	<input type="file" name="images" placeholder="Update item images" required/>
        	</div>
        	</div>
        	
        	
        	<div class="form-group">
        	<div  class="form-control">
        	<input type="submit" value="Update" class="btn btn-primary"/>
        	<input type="reset" value="Reset" class="btn btn-secondary"/>
        	</div>
        	</div>
        </form>
        </div>
        </div>
        
        </c:when>
        <c:otherwise>
        
        <!-- edit-form -->
        <div class="card">
        <div class="card-header"> 
         <h3 class="card-title">Add new Item</h3>
        </div>
        <div class="card-body">
        <form class="form-primary" modelAttribute="category"
        	action="${pageContext.request.contextPath }/admin/item/save" method="post"
        	enctype="multipart/form-data">
        	
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	
        	<div class="form-group">
        	<label>Name: </label>
        	<input class="form-control" type="text" name="name" placeholder="Enter item name" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Description: </label>
        	<input class="form-control" type="text" name="description" placeholder="Enter item description" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Price: </label>
        	<input class="form-control" type="text" name="price" placeholder="Enter item price" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Item Code: </label>
        	<input class="form-control" type="text" name="itemCode" placeholder="Enter item code" required/>
        	</div>
        	
        	<div class="form-group">
        	<label>Available: </label>
        	<select class="form-control" name="available" >
        	<option value="YES"> Available </option>
        	<option value="NO"> Not Available </option>
        	</select>
        	</div>
        	
        	<div class="form-group">
        	<label>Category: </label>
        	<select class="form-control" name="catId" >
        	<c:forEach items="${categorylist }" var="cat">
        		<c:if test="${cat.parentCat ne 0 }">
        		<option value="${cat.catId }"> ${cat.name } </option>
        		</c:if>
        	</c:forEach>
        	</select>
        	</div>
        	
        	<div class="form-group">
        	<label>Item Images: </label>
        	<div class="class="form-control">
        	<label>Regular: </label>
        	<input  type="file" name="images" placeholder="Update item images" required/>
        	</div>
        	<div class="class="form-control">
        	<label>Small: </label>
        	<input type="file" name="images" placeholder="Update item images" required/>
        	</div>
        	</div>
        	
        	
        	<div class="form-group">
        	<div  class="form-control">
        	<input type="submit" value="Save" class="btn btn-primary"/>
        	<input type="reset" value="Reset" class="btn btn-secondary"/>
        	</div>
        	</div>
        </form>
        </div>
        </div>
        </c:otherwise>
        </c:choose>
        
        </div>
        </div>
        <!-- form ends -->
        
        <!-- Display all categories in a table -->
        
        <div class="row" id="show-category">
        <div class="col-lg-9 col-md-12">
        
        <div class="card">
        <div class="card-header">
        <h1>Display All Items </h1>
        </div>
        <div class="card-body">
        <table class="table table-responsive">
        
        <thead>
        <tr>
        <th>Item Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Code</th>
        <th>Available</th>
        <th>Category</th>
        <th>Images</th>
        <th>Action</th>
        </tr>
        </thead>
        
        <tbody>
        
        <c:forEach items="${itemlist }" var="item">  
        
        <tr>
        <td>${item.itemId }</td>
        <td>${item.name }</td>
        <td>${item.description }</td>
        <td>${item.price }</td>
        <td>${item.itemCode }</td>
        <td>${item.available }</td>
        <td>${item.category.name }</td>
        <td><c:forEach items="${item.images}" var="image">${image } &nbsp;</c:forEach></td>
        <td>
        <a  href="<c:url value="/admin/item/edit/${item.itemId }" />" class="btn btn-warning">Edit</a>
        <a href="<c:url value="/admin/item/delete/${item.itemId }" />" class="btn btn-danger">Delete</a>
        </td>
        </tr>
        
        </c:forEach>
        
        </tbody>
        
        </table>
        </div>
        </div>
         
        </div>
        </div>
        
        
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  

  <!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>

  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath }/assets/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${pageContext.request.contextPath }/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="${pageContext.request.contextPath }/assets/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="${pageContext.request.contextPath }/assets/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="${pageContext.request.contextPath }/assets/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="${pageContext.request.contextPath }/assets/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${pageContext.request.contextPath }/assets/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="${pageContext.request.contextPath }/assets/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath }/assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/assets/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath }/assets/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${pageContext.request.contextPath }/assets/dist/js/pages/dashboard.js"></script>
</body>
</html>
