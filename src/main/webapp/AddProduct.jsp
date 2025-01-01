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
    .error {
    color: red;
    font-weight: bold;
    margin-top: 10px;
}
    
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
        .form-container {
            margin-top: 20px;
        }
        .form-container h1 {
            margin-bottom: 30px;
        }
        .form-control {
            margin-bottom: 15px;
        }
        .sidebar, .collapse {
            background-color: #343a40;
            color: #fff;
        }
        .nav-link {
            font-size: 1rem;
            padding: 10px 15px;
            transition: background-color 0.3s ease;
        }
        .nav-link:hover {
            background-color: #495057;
            color: #fff;
            border-radius: 4px;
        }
        .nav-link.active {
            background-color: #007bff;
            color: #fff;
        }
        .collapse {
            background-color: #495057;
        }
        .product-form-section {
            display: flex;
            justify-content: space-between;
        }
        .product-form-section > .form-group {
            flex: 1;
            margin-right: 15px;
        }
        .product-form-section > .form-group:last-child {
            margin-right: 0;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 sidebar d-flex flex-column p-3">
            <h4 class="text-center my-3 text-white">Admin Panel</h4>
            <a class="nav-link text-white" href="ControllerAdmin">
                <i class="fa-solid fa-shopping-cart me-2"></i> Quản lí
            </a>
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


			<c:if test="${not empty errorMessage}">
			    <div class="error">${errorMessage}</div>
			</c:if>
            <div class="form-container">
                <h1>Thêm Sản Phẩm</h1>
                <form action="ControllerAddProduct" method="post" enctype="multipart/form-data">
                    <div class="product-form-section">
                        <!-- Tên sản phẩm -->
                        <div class="form-group">
                            <label for="tenDT">Tên Sản Phẩm:</label>
                            <input type="text" id="tenDT" name="tenDT" class="form-control" required>
                        </div>

                        <!-- Số lượng -->
                        <div class="form-group">
                        <label for="soLuong">Số Lượng:</label>
                        <input type="text" id="soLuong" name="soLuong" class="form-control" required min="1">
                        </div>
                        

                    </div>

                    <div class="product-form-section">
                        <!-- Giá -->
                        <div class="form-group">
                            <label for="gia">Giá:</label>
                            <input type="text" id="gia" name="gia" class="form-control" required>
                        </div>

                        <!-- Mã loại -->
                        <div class="form-group">
                            <label for="maLoaiDT">Mã Loại:</label>
                            <select id="maLoaiDT" name="maLoaiDT" class="form-select" required>
    <option value="">Chọn mã loại sản phẩm</option>
    <c:forEach var="loai" items="${danhSachLoai}">
        <option value="${loai.maLoaiDT}">${loai.tenLoaiDT}</option>
    </c:forEach>
</select>

                        </div>
                    </div>

                    <!-- Các ảnh -->
                    <div class="product-form-section">
                        <div class="form-group">
                            <label for="anh1">Ảnh 1:</label>
                            <input type="file" id="anh1" name="anh1" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="anh2">Ảnh 2:</label>
                            <input type="file" id="anh2" name="anh2" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="anh3">Ảnh 3:</label>
                            <input type="file" id="anh3" name="anh3" class="form-control">
                        </div>
                    </div>
					

                    <!-- Thông tin sản phẩm khác -->
                    <div class="product-form-section">
                        <div class="form-group">
                            <label for="manHinh">Màn Hình:</label>
                            <input type="text" id="manHinh" name="manHinh" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="cameraTruoc">Camera Trước:</label>
                            <input type="text" id="cameraTruoc" name="cameraTruoc" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="cameraSau">Camera Sau:</label>
                            <input type="text" id="cameraSau" name="cameraSau" class="form-control">
                        </div>
                        
                    </div>


                    <div class="product-form-section">
                    	<div class="form-group">
                            <label for="heDieuHanh">Hệ Điều Hành:</label>
                            <input type="text" id="heDieuHanh" name="heDieuHanh" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="cpu">CPU:</label>
                            <input type="text" id="cpu" name="cpu" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="gpu">GPU:</label>
                            <input type="text" id="gpu" name="gpu" class="form-control">
                        </div>
                    </div>

                    <div class="product-form-section">
                        <div class="form-group">
                            <label for="ram">RAM:</label>
                            <input type="text" id="ram" name="ram" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="rom">ROM:</label>
                            <input type="text" id="rom" name="rom" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="pin">Pin:</label>
                            <input type="text" id="pin" name="pin" class="form-control">
                        </div>
                    </div>

                    

                    <!-- Nút Submit -->
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </form>
            </div>
        </main>
    </div>
</div>


</body>
</html>
