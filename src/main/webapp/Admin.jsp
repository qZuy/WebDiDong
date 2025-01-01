<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    
    
    <style>
    
        body {
            background-color: #f8f9fa;
        }
        .sidebar {
            height: 100vh;
            background-color: #343a40;
            color: #fff;
        }
        .sidebar a {
            color: #adb5bd;
            text-decoration: none;
            padding: 10px 15px;
            display: block;
        }
        .sidebar a:hover {
            background-color: #495057;
            color: #fff;
        }
        .navbar {
            background-color: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .card-header {
            background-color: #007bff;
            color: #fff;
        }
        .search-bar {
            width: 100%;
        }
        .search-bar input {
            width: calc(100% - 100px);
        }
        .product-card .card-body {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .product-card img {
            width: 120px;
            height: auto;
            object-fit: contain;
        }
        .product-info {
            flex: 1;
            margin-left: 15px;
        }
        .product-info h6 {
            font-size: 1rem;
            font-weight: bold;
        }
        .product-info p {
            font-size: 0.85rem;
            color: #6c757d;
        }
        
    .sidebar, .collapse {
        background-color: #343a40; /* Màu nền tối cho sidebar và menu */
        color: #fff;
    }

    /* Các liên kết trong sidebar và menu con */
    .nav-link {
        font-size: 1rem;
        padding: 10px 15px;
        
        transition: background-color 0.3s ease;
    }

    /* Hiệu ứng hover khi di chuột vào các liên kết */
    .nav-link:hover {
        background-color: #495057; /* Màu nền khi hover */
        color: #fff;
        border-radius: 4px;
    }

    /* Màu nền cho phần menu con (collapse) */
    .collapse .navbar-nav .nav-item .nav-link {
        font-size: 1rem;
        padding-left: 30px;
    }

    /* Đảm bảo rằng khi mở rộng, các phần vẫn đồng màu */
    .collapse {
        background-color: #495057;
    }

    /* Làm nổi bật mục đang chọn */
    .nav-link.active {
        background-color: #007bff;
        color: #fff;
    }

    /* Thêm màu nền cho menu mở rộng */
    .navbar-nav {
        width: 100%;
    }


        
    </style>
</head>
<body>

    <!-- Sidebar -->
    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-3 col-lg-2 sidebar d-flex flex-column p-3">
			    <h4 class="text-center my-3 text-white">Admin Panel</h4>
			    <a class="nav-link text-white" href="#" data-bs-toggle="collapse" data-bs-target="#adminMenu" aria-expanded="false" aria-controls="adminMenu">
			        <i class="fa-solid fa-box-open me-2"></i> Quản Lí
			    </a>
			
			    <div class="collapse" id="adminMenu">
				    <div class="container mt-3">
				        <div class="row">
				            <nav class="col-12 navbar navbar-dark p-3 flex-row justify-content-start" style="background-color: #343a40;">
				                <div class="container-fluid d-flex flex-row">
				                    <ul class="navbar-nav mb-3 d-flex w-100 justify-content-around">
				                        <li class="nav-item">
				                            <a class="nav-link text-white" href="ControllerAdmin">Tất Cả</a>
				                        </li>
				                        <c:forEach var="category" items="${dsloai}">
				                            <li class="nav-item">
				                                <a class="nav-link text-white" href="ControllerAdmin?ml=${category.maLoaiDT}">${category.tenLoaiDT}</a>
				                            </li>
				                        </c:forEach>
				                    </ul>
				                </div>
				            </nav>
				        </div>
				    </div>
				</div>

			
			    <a class="nav-link text-white" href="ControllerXacNhan">
			        <i class="fa-solid fa-shopping-cart me-2"></i> Xác nhận đơn hàng
			    </a>
			    <a class="nav-link text-white" href="ControllerAdminUser">
			        <i class="fa-solid fa-file-alt me-2"></i> Quản lý người dùng
			    </a>
			    <a class="nav-link text-white mt-auto" href="ControllerAdminLogin">
			        <i class="fa-solid fa-sign-out-alt me-2"></i> Logout
			    </a>
			</nav>


            <!-- Content -->
            <main class="col-md-9 col-lg-10">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-light px-4">
                    <div class="container-fluid">
                        <span class="navbar-brand fw-bold">Welcome, ${sessionScope.ad.hoTen}</span>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </div>
                </nav>

                <!-- Dashboard Content -->
                <div class="container py-4">
                    <div class="row align-items-center">
                        <!-- Cards and Search -->
                        <div class="col-md-4">
                            <div class="card shadow-sm">
                                <div class="card-header">
                                    <h5 class="card-title mb-0">Người Dùng</h5>
                                </div>
                                <div class="card-body">
                                    <h3 class="card-text text-primary">
                                        <c:out value="${userCount}" /> <!-- Hiển thị số lượng người dùng -->
                                    </h3>
                                    <p>Người Sử Dụng</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="card shadow-sm">
                                <div class="card-header">
                                    <h5 class="card-title mb-0">Đơn Đặt Hàng</h5>
                                </div>
                                <div class="card-body">
                                    <h3 class="card-text text-primary">
                                        <c:out value="${hoadonCount}" /> <!-- Hiển thị số lượng đơn hàng -->
                                    </h3>
                                    <p>Đơn Đặt Hàng</p>
                                </div>
                            </div>
                        </div>

                        <!-- Search Form -->
                        <div class="col-md-4">
                            <form class="d-flex" method="get" action="ControllerAdmin">
                                <input type="search" name="keyword" class="form-control me-2" placeholder="Search" aria-label="Search" />
                                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                            </form>
                        </div>
                    </div>
                </div>
				<br>
               <h5 class="card-title mb-0">Sản phẩm</h5>
               <a href="ControllerAddProduct" class="btn btn-primary" >Thêm Sản Phẩm</a>


                <div class="container mt-5">
                
				    <div class="row">
				        <!-- Lặp qua danh sách sản phẩm và mỗi sản phẩm nằm trong một hàng ngang -->
				        <c:forEach var="product" items="${dsdt}">
				            <div class="col-12 col-sm-6 col-md-3 mb-4">
				                <div class="card shadow-sm product-card">
				                    <div class="row g-0">
				                        <!-- Product Image -->
				                        <div class="col-4">
				                            <img src="${product.anh1}" alt="${product.tenDT}" class="img-fluid" style="height: 100%; object-fit: contain;">
				                        </div>
				                        <!-- Product Info -->
				                        <div class="col-8">
				                            <div class="card-body product-info d-flex flex-column justify-content-between">
				                                <h6 class="card-title mb-2">${product.tenDT}</h6>
				                                <p class="card-text mb-2 text-muted">${product.manHinh}</p>
				                                <p class="card-text mb-2 text-muted">${product.heDieuHanh}</p>
				                                <h6 class="text-primary mb-3">
				                                    <fmt:formatNumber value="${product.gia}" type="number" pattern="#,###.##" /> VND
				                                </h6>
				                                <div class="d-flex gap-2">
				                                	<button class="btn btn-primary" onclick="window.location.href='ControllerEditProduct?mdt=${product.maDT}'">Sửa</button>
				                                    
				                                    <button class="btn btn-sm btn-danger w-50" onclick="window.location.href='ControllerDeleteProduct?mdt=${product.maDT}'">Xóa</button>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
				            </div>
				        </c:forEach>
				    </div>
				</div>


                    
                </div>

                <!-- Pagination -->
                <div class="row text-center mt-4">
                    <c:if test="${totalPages > 1}">
                        <ul class="pagination justify-content-center">
                            <c:forEach begin="1" end="${totalPages}" var="i">
                                <li class="page-item ${currentPage == i ? 'active' : ''}">
                                    <a class="page-link" href="ControllerAdmin?page=${i}&ml=${param.ml}&keyword=${param.keyword}">
                                        ${i}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </div>
            </main>
        </div>
        
   
        
     
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
