<%--
  Created by IntelliJ IDEA.
  User: Pasindu Raveen
  Date: 17-Sep-22
  Time: 6:24 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Skydash Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendors/feather/feather.css">
    <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png"/>
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth px-0">
            <div class="row w-100 mx-0">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                        <div class="brand-logo">
                            <img src="images/logo@2x-blck.png" alt="logo">
                        </div>
                        <h4>New here?</h4>
                        <h6 class="font-weight-light">Signing up is easy. It only takes a few steps</h6>
                        <form id="regiForm" onsubmit="return false" class="pt-3">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg" id="regName"
                                       placeholder="Username">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg" id="regCon"
                                       placeholder="Contact">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg" id="regAdres"
                                       placeholder="Address">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-lg" id="regEmail"
                                       placeholder="Email">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-lg" id="regPass"
                                       placeholder="Password">
                            </div>
                            <div class="mb-4">
                                <div class="form-check">
                                    <label class="form-check-label text-muted">
                                        <input type="checkbox" class="form-check-input">
                                        I agree to all Terms & Conditions
                                    </label>
                                </div>
                            </div>
                            <div class="mt-3">
                                <button class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn"
                                        type="submit">SIGN UP
                                </button>
                            </div>
                            <div class="text-center mt-4 font-weight-light">
                                Already have an account? <a href="index.jsp" class="text-primary">Login</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
        crossorigin="anonymous"></script>
<script src="js/off-canvas.js"></script>
<script src="js/hoverable-collapse.js"></script>
<script src="js/template.js"></script>
<script src="js/settings.js"></script>
<script src="js/todolist.js"></script>
<script src="js/login.js"></script>
<!-- endinject -->
</body>

</html>
