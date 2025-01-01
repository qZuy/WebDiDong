<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    
    body {
    background: url('https://th.bing.com/th/id/R.0c48c5dad330d61a3470d52f0e35d886?rik=DKiEeXYGGfohLQ&pid=ImgRaw&r=0') no-repeat center center fixed;
    background-size: cover;
  }
    .card-img-left {
      width: 45%;
      background: scroll center url('https://img.freepik.com/free-vector/gradient-mobile-store-logo-template_23-2149704597.jpg?w=996&t=st=1664828082~exp=1664828682~hmac=a152f5d2f31640bc3b047d61f4fb365789c5c465780e47595da4b3dd28e4d358');
      background-size: cover;
    }
    .btn-login {
      font-size: 0.9rem;
      letter-spacing: 0.05rem;
      padding: 0.75rem 1rem;
    }
    .btn-google {
      background-color: #ea4335;
      color: white !important;
    }
    .btn-facebook {
      background-color: #3b5998;
      color: white !important;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
          <div class="card-img-left d-none d-md-flex"></div>
          <div class="card-body p-4 p-sm-5">
            <h5 class="card-title text-center mb-5 fw-light fs-5">Register</h5>
            <!-- Form gửi dữ liệu POST -->
            <form action="ControllerRegister" method="POST">
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="name" placeholder="Your Name" required autofocus>
                <label for="name">Name</label>
              </div>

              <div class="form-floating mb-3">
                <input type="email" class="form-control" name="email" placeholder="name@example.com" required>
                <label for="email">Email</label>
              </div>

              <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                <label for="password">Password</label>
              </div>

              <div class="form-floating mb-3">
                <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required>
                <label for="confirmPassword">Confirm Password</label>
              </div>

              <!-- Thông báo lỗi từ server -->
              <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger text-center">${errorMessage}</div>
              </c:if>

              <div class="d-grid mb-2">
                <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Register</button>
              </div>

              <a class="d-block text-center mt-2 small" href="ControllerLogin">Đã có tài khoản? Sign In</a>

              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
