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
    	.product-name {
    width: 200px; /* Hoặc bất kỳ chiều rộng nào bạn muốn */
    white-space: nowrap; /* Ngăn không cho văn bản bị xuống dòng */
    overflow: hidden; /* Giới hạn hiển thị văn bản nếu quá dài */
    text-overflow: ellipsis; /* Thêm dấu ba chấm (...) nếu văn bản bị cắt */
}
    	
        /* Tùy chỉnh thanh điều hướng */
        .navbar-nav .nav-link:hover {
            background-color: #4CAF50;
            color: white;
        }

        .error {
            color: red;
            font-size: 14px;
            margin-top: 10px;
        }

        .navbar-nav .nav-item a:hover {
            color: white;
        }

        .pagination .page-item.active .page-link {
            background-color: #607D8B;
            border-color: #607D8B;
            color: white;
        }
        .pagination .page-link {
            color: #607D8B;
        }
        .pagination .page-link:hover {
            background-color: #E0E0E0;
        }

        .card-img-top {
            width: 90%;
            height: 270px; 
            transition: transform 0.3s ease-in-out;
        }

        .card-img-top:hover {
            transform: scale(1.1); 
        }

        /* Tạo kiểu cho các nút trạng thái */
        .status-button {
            padding: 8px 15px;
            border-radius: 5px;
            font-weight: bold;
            text-align: center;
        }

        .status-processing {
            background-color: #4CAF50;
            color: white;
        }

        .status-completed {
            background-color: #ffffff;
            color: #4CAF50;
            border: 1px solid #4CAF50;
        }

        /* Gộp mã hóa đơn thành một khối */
        .order-group {
            margin-bottom: 20px;
        }

        .order-header {
            font-weight: bold;
            background-color: #f1f1f1;
            padding: 10px;
            border-radius: 5px;
        }

        .order-body {
            padding-left: 20px;
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

<div class="container mt-5 pt-5">
    <h2 class="text-center mb-4">Lịch Sử Mua Hàng</h2>
    <c:choose>
        <c:when test="${not empty historyList}">
            <div class="order-group">
                <c:forEach var="order" items="${historyList}">
                    <!-- Nhóm mã hóa đơn -->
                    <c:if test="${order.mahd != prevOrderMaHD}">
                        <div class="order-header">
                            Mã Hóa Đơn: ${order.mahd} - Ngày Mua: ${order.ngaymua} 
                        </div>
                        <div class="order-body">
                    </c:if>
                    <table class="table table-bordered">
                        <tr>
                            <td class="product-name">${order.tendt}</td>
                            <td class="product-name"><fmt:formatNumber value="${order.gia}" type="currency" currencySymbol="₫"/></td>
                            <td class="product-name">${order.soluong}</td>
                            <td class="product-name"><fmt:formatNumber value="${order.tong}" type="currency" currencySymbol="₫"/></td>
                            <td class="product-name">
                                <button class="status-button ${order.trangthai ? 'status-processing' : 'status-completed'}">
                                    ${order.trangthai ? 'Đã Mua': 'Đang Xử Lý'}
                                </button>
                            </td>
                        </tr>
                    </table>
                    <c:if test="${order.mahd != prevOrderMaHD}">
                    	
                        </div> <!-- Đóng order-body -->
                    </c:if>
                    
                    <c:set var="prevOrderMaHD" value="${order.mahd}"/>
                </c:forEach>
                
            </div>
        </c:when>
        <c:otherwise>
            <p class="text-center">Không có lịch sử mua hàng nào!</p>
        </c:otherwise>
    </c:choose>
</div>

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
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #E0E0E0">
        <a class="text-white" href="https://www.facebook.com/Enkildy/">Nguyễn Quốc Duy</a>
    </div>
</footer>

<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>
