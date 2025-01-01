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
        .content {
            padding: 20px;
        }
        .order-header {
            font-weight: bold;
            color: #007bff;
        }
        .status-button {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            color: #fff;
        }
        .status-processing {
            background-color: #ffc107;
        }
        .status-completed {
            background-color: #28a745;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-2 sidebar d-flex flex-column p-3">
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

        <!-- Main Content -->
        <main class="col-md-10 content">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light px-4">
                <div class="container-fluid">
                    <span class="navbar-brand fw-bold">Welcome, ${sessionScope.ad.hoTen}</span>
                </div>
            </nav>

            <div class="container mt-4">
                <c:choose>
                    <c:when test="${not empty historyList}">
                        <div class="order-group">
                            <c:forEach var="order" items="${historyList}">
                                <c:if test="${order.mahd != prevOrderMaHD}">
                                    <div class="order-header">
                                        Mã Hóa Đơn: ${order.mahd} - Ngày Mua: ${order.ngaymua}
                                    </div>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Tên Sản Phẩm</th>
                                                <th>Giá</th>
                                                <th>Số Lượng</th>
                                                <th>Tổng</th>
                                                <th>Trạng Thái</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>${order.tendt}</td>
                                                <td><fmt:formatNumber value="${order.gia}" type="currency" currencySymbol="₫"/></td>
                                                <td>${order.soluong}</td>
                                                <td><fmt:formatNumber value="${order.tong}" type="currency" currencySymbol="₫"/></td>
                                                <td>
                                                    <form action="ControllerXacNhan" method="post" style="display:inline;">
													    <button type="submit" class="btn btn-success" name="xacNhan" value="${order.mahd}">Xác nhận đơn hàng</button>
													</form>

                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
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
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
