<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Page</title>
    <!-- MDB CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
    /* Tùy chỉnh thanh điều hướng */




/* Khi người dùng hover vào các mục */
.navbar-nav .nav-link:hover {
    background-color: #4CAF50; /* Màu nền khi hover */
    color: white; /* Màu chữ khi hover */
}

/* Định dạng cho phần thông báo lỗi, khi có nhập sai CAPTCHA */
.error {
    color: red;
    font-size: 14px;
    margin-top: 10px;
}

.navbar-nav .nav-item a:hover {
    color: white; /* Màu chữ khi hover */
}
    
    .pagination .page-item.active .page-link {
    background-color: #607D8B; /* Màu nền cho trang hiện tại */
    border-color: #607D8B;
    color: white;
}
.pagination .page-link {
    color: #607D8B; /* Màu liên kết */
}
.pagination .page-link:hover {
    background-color: #E0E0E0; /* Màu nền khi hover */
}
	.card-img-top {
		    width: 90%;
		    height: 270px; 
		    
	    transition: transform 0.3s ease-in-out;
	}

	.card-img-top:hover {
	    transform: scale(1.1); 
	}
    </style>


    
    
	
    
</head>
<body>

<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
    <div class="container">
        <!-- Toggle button -->
        <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        
        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarContent">
        <!-- Brand -->
        <a class="navbar-brand" href="#">
            <img src="https://png.pngtree.com/element_our/md/20180414/md_5ad1c8a6b10ca.jpg" height="50" width="70" alt="Logo" loading="lazy"/>
        </a>

        <!-- Links on the left (Home only)-->
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
             <li class="nav-item"><a class="nav-link" href="ControllerStore">Home</a></li>
        </ul>

      <!-- Links on the center (Cart and History)-->
       <ul class="navbar-nav  mb-2 mb-lg-0" >
            <li class="nav-item">
              <a class="nav-link" href="ControllerCart">
                <i class="fas fa-shopping-cart me-1"></i>
                 <span >Giỏ hàng</span>
                </a>
            </li>
            <li class="nav-item"><a class="nav-link" href="ControllerHistorykh">Lịch sử mua hàng</a></li>
        </ul>



    </div>

        <!-- Right elements -->
        <div class="d-flex align-items-center">
        <ul class="nav navbar-nav navbar-right">
		    <c:choose>
		        <c:when test="${empty sessionScope.dn}">
		            <!-- Nếu người dùng chưa đăng nhập -->
		            <li class="nav-item">
		                <a class="nav-link" href="ControllerLogin">
		                    <span class="glyphicon glyphicon-log-in"></span> Login
		                </a>
		            </li>
		        </c:when>
		        <c:otherwise>
		            <!-- Nếu người dùng đã đăng nhập -->
		            
		            <li class="nav-item">
		                <a class="nav-link" href="#">
		                    <span class="glyphicon glyphicon-user"></span>Người Dùng: ${sessionScope.dn.name}
		                </a>
		            </li>
		            <li class="nav-item">
		                <a class="nav-link" href="ControllerLogin">
		                    <span class="glyphicon glyphicon-off"></span> Logout
		                </a>
		            </li>
		        </c:otherwise>
		    </c:choose>
		</ul>


            
        </div>
    </div>
</nav>
<!-- Navbar -->

<!-- Carousel -->
<div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-mdb-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://gizchina.it/wp-content/uploads/2024/02/Xiaomi-14-ultra-photography-kit.jpg" class="d-block w-100" alt="Image 1"/>
            <div class="carousel-caption d-none d-md-block">
                <h5>Welcome to Our Store</h5>
                <p>Explore the best products and deals!</p>
            </div>
        </div>
        
        <div class="carousel-item">
            <img src="https://m-cdn.phonearena.com/images/reviews/248946-image/BK6A6454.jpg" class="d-block w-100" alt="Image 2"/>
        </div>
        <div class="carousel-item">
            <img src="https://hoanghamobile.com/tin-tuc/wp-content/uploads/2021/11/smartphone-2.jpg" class="d-block w-100" alt="Image 3"/>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    </button>
    <button class="carousel-control-next" type="button" data-mdb-target="#carouselExampleCaptions" data-mdb-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
    </button>
</div>
<!-- Carousel -->

<!-- Product Section -->
<main>
    <div class="container mt-5">
        <!-- Categories Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark shadow p-3" style="background-color: #607D8B;">
		    <div class="container-fluid">
		        <div class="collapse navbar-collapse" id="categoryNav">
		            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                <li class="nav-item"><a class="nav-link text-white" href="ControllerStore">Tất Cả</a></li>
		                <c:forEach var="category" items="${dsloai}">
		                    <li class="nav-item">
		                        <a class="nav-link text-white" href="ControllerStore?ml=${category.maLoaiDT}">${category.tenLoaiDT}</a>
		                    </li>
		                </c:forEach>
		            </ul>
		

		            <form class="d-flex" style="max-width: 18rem;" method="get" action="ControllerStore">
		                <input type="search" name="keyword" class="form-control me-2" placeholder="Search" aria-label="Search"/>
		                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
		            </form>
		        </div>
		    </div>
		</nav>

 
        <section class="mt-4">
            <div class="row">
                <c:forEach var="product" items="${dsdt}">
	                    <div class="col-lg-3 col-md-6 mb-4">
	                        <div class="card">
	                            <img src="${product.anh1}" class="card-img-top" alt="${product.tenDT}"/>
	                            <div class="card-body">
	                                <h5 class="card-title">${product.tenDT}</h5>
	                                <p class="card-text">${product.manHinh}</p>
	                                <p class="card-text">${product.heDieuHanh}</p>
	                                <h6 class="text-primary">
									    <fmt:formatNumber value="${product.gia}" type="number" pattern="#,###.##" /> VND
									</h6>

	                                <button class="btn btn-primary" onclick="window.location.href='ControllerProduct?mdt=${product.maDT}'">Xem Thông Tin Sản Phẩm</button>
	                                
	                            </div>
	                        </div>
	                    </div>
                </c:forEach>
            </div>
        </section>
        
    </div>
    <div class="row text-center mt-4">
	    <c:if test="${totalPages > 1}">
	        <ul class="pagination justify-content-center">
	            <c:forEach begin="1" end="${totalPages}" var="i">
	                <li class="page-item ${currentPage == i ? 'active' : ''}">
	                    <a class="page-link" href="ControllerStore?page=${i}&ml=${param.ml}&keyword=${param.keyword}">
	                        ${i}
	                    </a>
	                </li>
	            </c:forEach>
	        </ul>
	    </c:if>
	</div>

</main>
<footer class="text-center text-white mt-4" style="background-color: #607D8B">
  
  <hr class="text-dark">
  
  <div class="container">
    <!-- Section: Social media -->
    <section class="mb-3">
      
      <!-- Facebook -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-facebook-f"></i
      ></a>

      <!-- Twitter -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-twitter"></i
      ></a>

      <!-- Google -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-google"></i
      ></a>

      <!-- Instagram -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-instagram"></i
      ></a>

      <!-- YouTube -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-youtube"></i
      ></a>
      <!-- Github -->
      <a
        class="btn-link btn-floating btn-lg text-white"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
        ><i class="fab fa-github"></i
      ></a>
    </section>
    <!-- Section: Social media -->
  </div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #E0E0E0">

    <a class="text-white" href="https://www.facebook.com/Enkildy/">Nguyễn Quốc Duy</a>
  </div>
  <!-- Copyright -->
</footer>
<!-- MDB Scripts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>
