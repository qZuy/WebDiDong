<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- MDB CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
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

    <!-- Main layout -->
    <main class="mt-5 pt-4">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 mb-4">
                    <!-- Carousel for Product Images -->
                    <c:if test="${not empty Product}">
						<div id="productCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
						    <div class="carousel-inner">
						        <div class="carousel-item active">
						            <img src="${Product.anh1}" class="d-block w-100" alt="Ảnh 1">
						        </div>
						        <c:if test="${not empty Product.anh2}">
						            <div class="carousel-item">
						                <img src="${Product.anh2}" class="d-block w-100" alt="Ảnh 2">
						            </div>
						        </c:if>
						        <c:if test="${not empty Product.anh3}">
						            <div class="carousel-item">
						                <img src="${Product.anh3}" class="d-block w-100" alt="Ảnh 3">
						            </div>
						        </c:if>
						    </div>
						    <!-- Nút điều khiển carousel -->
						    <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
						        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						        <span class="visually-hidden">Previous</span>
						    </button>
						    <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
						        <span class="carousel-control-next-icon" aria-hidden="true"></span>
						        <span class="visually-hidden">Next</span>
						    </button>
						</div>


                    </c:if>
                </div>

                <div class="col-md-6 mb-4">
    <div class="card shadow-sm border-0 rounded">
        <div class="card-body p-4">
            <c:if test="${not empty Product}">
                <h2 class="card-title text-primary fw-bold">${Product.tenDT}</h2>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Màn hình:</strong> ${Product.manHinh}</li>
                    <li class="list-group-item"><strong>Hệ điều hành:</strong> ${Product.heDieuHanh}</li>
                    <li class="list-group-item"><strong>Camera trước:</strong> ${Product.cameraTruoc}</li>
                    <li class="list-group-item"><strong>Camera sau:</strong> ${Product.cameraSau}</li>
                    <li class="list-group-item"><strong>CPU:</strong> ${Product.cpu}</li>
                    <li class="list-group-item"><strong>GPU:</strong> ${Product.gpu}</li>
                    <li class="list-group-item"><strong>RAM:</strong> ${Product.ram}</li>
                    <li class="list-group-item"><strong>ROM:</strong> ${Product.rom}</li>
                    <li class="list-group-item"><strong>Pin:</strong> ${Product.pin}</li>
                    <li class="list-group-item text-danger fw-bold">
                        <strong>Giá:</strong> 
                        <fmt:formatNumber value="${Product.gia}" type="number" pattern="#,###.##" /> VND
                    </li>
                </ul>
            </c:if>
            <form class="mt-4 d-flex align-items-center" action="ControllerCart" method="post">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="id" value="${Product.maDT}">
                <input type="hidden" name="name" value="${Product.tenDT}">
                <input type="hidden" name="gia" value="${Product.gia}">
                <div class="d-flex align-items-center me-2">
                    <label for="soluong" class="me-2 mb-0"><strong>Số lượng:</strong></label>
                    <input type="number" id="soluong" name="soluong" value="1" class="form-control" min="1" style="width: 100px;">
                </div>
                <button type="submit" class="btn btn-success">
                    <i class="fas fa-cart-plus me-1"></i> Thêm vào giỏ hàng
                </button>
            </form>
        </div>
    </div>
</div>

            </div>

            <hr />

            <!-- Product Reviews Section -->
			<h3 class="mt-4 text-center">Đánh giá sản phẩm</h3>
			<c:if test="${not empty reviews}">
			    <div class="list-group">
			        <c:forEach var="review" items="${reviews}">
			            <div class="list-group-item d-flex justify-content-between align-items-start shadow-sm mb-3 p-3 rounded">
			                <div class="d-flex flex-column">
			                    <span class="fw-bold text-dark">${review.userId}</span><br>
			                    <div class="d-flex align-items-center">
			                        <c:forEach begin="1" end="${review.rating}" var="i">
			                            <i class="fas fa-star text-warning fs-5"></i>
			                        </c:forEach>
			                        <c:forEach begin="${review.rating + 1}" end="5" var="i">
			                            <i class="fas fa-star text-muted fs-5"></i>
			                        </c:forEach>
			                    </div><br>
			                    <p class="mb-2 text-dark">${review.comment}</p><br>
			                    <small class="text-muted">Được đăng vào: ${review.createdAt}</small>
			                </div>
			            </div>
			        </c:forEach>
			    </div>
			</c:if>
			
			<!-- Add Review Form -->
			<h4 class="mt-5 text-center">Thêm đánh giá của bạn</h4>
			<form action="ControllerAddReview" method="post" class="p-4 shadow-sm rounded border">
				<input type="hidden" name="maDT" value="${Product.maDT}">
			    <div class="mb-3">
			        <label for="rating" class="form-label">Đánh giá</label>
			        <select class="form-select" name="rating" required>
			            <option value="1">1 sao</option>
			            <option value="2">2 sao</option>
			            <option value="3">3 sao</option>
			            <option value="4">4 sao</option>
			            <option value="5">5 sao</option>
			        </select>
			    </div>
			    <div class="mb-3">
			        <label for="comment" class="form-label">Nhận xét</label>
			        <textarea class="form-control" name="comment" rows="4" required placeholder="Chia sẻ trải nghiệm của bạn..."></textarea>
			    </div>
			    <button type="submit" class="btn btn-success w-100">Gửi đánh giá</button>
			</form>

        </div>
    </main>

    <!-- Footer -->
    <footer class="text-center text-white mt-4" style="background-color: #607D8B">
        <hr class="text-dark">
        <div class="container">
            <section class="mb-3">
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-facebook-f"></i></a>
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-twitter"></i></a>
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-google"></i></a>
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-instagram"></i></a>
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-youtube"></i></a>
                <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-github"></i></a>
            </section>
        </div>
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            <a class="text-white" href="https://www.facebook.com/Enkildy/">Nguyễn Quốc Duy</a>
        </div>
    </footer>

    <!-- Bootstrap JS (để carousel hoạt động) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
