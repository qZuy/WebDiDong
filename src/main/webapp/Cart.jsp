<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">

    <style>
        

        .container1 {
            width: 70%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2em;
            margin-bottom: 20px;
            text-align: center;
        }

        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            border-bottom: 1px solid #ddd;
            margin-bottom: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
        }



        .cart-item-info {
            flex: 1;
        }

        .cart-item-name {
            font-size: 1.2em;
            font-weight: bold;
        }

        .cart-item-description {
            font-size: 0.9em;
            color: #777;
        }

        .cart-item-quantity {
            width: 120px;
            text-align: center;
        }

        .cart-item-price {
            text-align: right;
            font-weight: bold;
            min-width: 120px;
        }

        .cart-item-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 10px;
        }

        .remove-btn {
            color: #ff4d4d;
            cursor: pointer;
            font-size: 1em;
        }

        .update-btn {
            background-color: #007bff;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            font-size: 1em;
        }

        .subtotal {
            font-size: 1.3em;
            font-weight: bold;
            margin-top: 30px;
            text-align: right;
        }

        .checkout-btn, .continue-shopping-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 1em;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
            width: 100%;
        }

        .continue-shopping-btn {
            background-color: #f8f9fa;
            color: #007bff;
            border: 1px solid #007bff;
            margin-top: 10px;
        }

        .cart-empty-message {
            text-align: center;
            font-size: 1.2em;
            color: #555;
            margin-top: 30px;
        }

        .cart-actions-container {
            text-align: center;
            
        }
        
    </style>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
    <div class="container" >
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
<div class="container1" >
    <h1>Your Cart</h1>
	
    <c:if test="${not empty cartList}">
    	<td style="padding: 10px; border-bottom: 1px solid #ddd; text-align: left;">
                        	<form action="ControllerCart" method="post" style="display: inline;">
							    <input type="hidden" name="action" value="removeall">
							    <button type="submit" class="remove-btn" style="color: #ff4d4d; margin-left: 5px;">Xóa Tất Cả</button>
							</form>
         </td>
        <table style="width: 100%; border-collapse: collapse;margin: 20px auto;">
        
            <thead>
                <tr style="background-color: #f4f4f4; text-align: left;">
                    <th style="padding: 10px; border-bottom: 1px solid #ddd;">Tên sản phẩm</th>
                    <th style="padding: 10px; border-bottom: 1px solid #ddd;">Giá</th>
                    <th style="padding: 10px; border-bottom: 1px solid #ddd;">Số lượng</th>
                    <th style="padding: 10px; border-bottom: 1px solid #ddd;">Thành tiền</th>
                    <th style="padding: 10px; border-bottom: 1px solid #ddd;">Thao tác</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="cart" items="${cartList}">
                    <tr>
                        <!-- Tên sản phẩm -->
                        <td style="padding: 10px; border-bottom: 1px solid #ddd;">
                            ${cart.name}
                        </td>

                        <!-- Giá -->
                        <td style="padding: 10px; border-bottom: 1px solid #ddd; text-align: left;">
                            <fmt:formatNumber value="${cart.gia}" type="number" pattern="#,###.##" /> VND
                        </td>

                        <!-- Số lượng -->
                        <td style="padding: 10px; border-bottom: 1px solid #ddd; text-align: left;">
                            <form action="ControllerCart" method="post" style="display: inline;">
							    <input type="hidden" name="action" value="update">
							    <input type="hidden" name="id" value="${cart.id}">
							    <input type="number" name="newsoluong" value="${cart.soluong}" min="1" style="width: 60px;" />
							    <button type="submit" class="update-btn" style="padding: 5px; margin-left: 5px;">Cập nhật</button>
							</form>
							
						</td>

                        <!-- Thành tiền -->
                        <td style="padding: 10px; border-bottom: 1px solid #ddd; text-align: left;">
                            <fmt:formatNumber value="${cart.thanhTien}" type="number" pattern="#,###.##" /> VND
                        </td>

                        <!-- Thao tác -->
                        <td style="padding: 10px; border-bottom: 1px solid #ddd; text-align: left;">
                        	<form action="ControllerCart" method="post" style="display: inline;">
							    <input type="hidden" name="action" value="remove">
							    <input type="hidden" name="id" value="${cart.id}">
							    
							    <button type="submit" class="remove-btn" style="color: #ff4d4d; margin-left: 5px;">Xóa</button>
							</form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="subtotal" style="margin-top: 20px; text-align: right;">
            <p>Tổng tiền: <fmt:formatNumber value="${tong}" type="number" pattern="#,###.##" /> VND</p>
        </div>

        <div class="cart-actions-container">
        
            <form action="ControllerCart" method="post">
                <button type="submit" class="checkout-btn" name="action" value="muahang">Xác nhận mua</button>
            </form>
            <button onclick="window.location.href='ControllerStore'" class="continue-shopping-btn">Tiếp tục mua</button>
        </div>
    </c:if>

    <c:if test="${empty cartList}">
        <p class="cart-empty-message">Giỏ hàng của bạn đang trống.</p>
    </c:if>
</div>

</body>
</html>
