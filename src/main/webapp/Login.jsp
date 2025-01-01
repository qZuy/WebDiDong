<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            position: relative;
        }
        .bg-image {
            background-image: url('https://th.bing.com/th/id/OIP.cyf4_-TZB5DxlcvFH1TjKwHaEV?w=2560&h=1500&rs=1&pid=ImgDetMain');
            background-size: cover;
            background-position: center;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            opacity: 0.5;
            z-index: -1;
        }
        .login-box {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 500px;
        }
        .login-heading {
            font-weight: 300;
            text-align: center;
            margin-bottom: 30px;
        }
        .btn-login {
            font-size: 0.9rem;
            letter-spacing: 0.05rem;
            padding: 0.75rem 1rem;
        }
        .form-floating {
            margin-bottom: 15px;
        }
        .form-control {
            width: 100%;
        }
        .captcha {
            display: none;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h3 class="login-heading">Welcome back!</h3>
            <form action="ControllerLogin" method="POST">
                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@gmail.com" name="email" required>
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
                    <label for="floatingPassword">Password</label>
                </div>
                
               
				<p class="error">
                <%= request.getAttribute("mess") != null ? request.getAttribute("mess") : "" %>
	            </p>
	            <%
	                if(session.getAttribute("dem") != null && (int) session.getAttribute("dem") >= 3) {
	            %>
	                <img src="simpleCaptcha.jpg" />
	                <input type="text" name="answer" placeholder="Nhập mã CAPTCHA" required><br>
	            <% 
	                }
	            %>
                <div class="d-grid">
                    <button class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2" type="submit">Sign in</button>
                </div>
                <a class="d-block text-center mt-2 small" href="ControllerRegister">Đã chưa có tài khoản? Register</a>
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger mt-3">${errorMessage}</div>
                </c:if>
            </form>
        </div>
        <div class="bg-image"></div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
