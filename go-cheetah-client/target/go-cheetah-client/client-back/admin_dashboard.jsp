<%--
  Created by IntelliJ IDEA.
  User: Pasindu Raveen
  Date: 20-Sep-22
  Time: 12:05 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Gocheetah AdminDash</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendors/feather/feather.css">
    <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="js/select.dataTables.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png"/>
</head>
<body onload="loadTable()">
<div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="partials/_navbar.html"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_settings-panel.html -->
        <jsp:include page="partials/_settings-panel.html"/>
        <!-- partial -->
        <!-- partial:partials/_sidebar.html -->
        <jsp:include page="partials/_sidebar.html"/>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-md-6 grid-margin transparent">
                        <div class="row">
                            <div class="col-md-6 mb-4 stretch-card transparent">
                                <div class="card card-tale">
                                    <div class="card-body">
                                        <p class="mb-4">Total Income</p>
                                        <p id="incomeTot" class="fs-30 mb-2">00.00</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mb-4 stretch-card transparent">
                                <div class="card card-dark-blue">
                                    <div class="card-body">
                                        <p class="mb-4">Total Bookings</p>
                                        <p id="bookingTot" class="fs-30 mb-2">61344</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Earning of all Branches</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>City Name</th>
                                            <th>Postal Code</th>
                                            <th>Earning</th>

                                        </tr>
                                        </thead>
                                        <tbody id="AllCity">
                                        <tr>
                                            <td>#1</td>
                                            <td>City1</td>
                                            <td>City2</td>
                                            <td>0.0</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Journey History</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Depart City</th>
                                            <th>Arriving City</th>
                                            <th>Cost</th>
                                            <th>Date</th>
                                            <th>Customer Name</th>
                                            <th>Customer Contact</th>
                                            <th>Vehicle Name</th>
                                            <th>Status</th>
                                        </tr>
                                        </thead>
                                        <tbody id="jHistory">
                                        <tr>
                                            <td>#1</td>
                                            <td>City1</td>
                                            <td>City2</td>
                                            <td>0.0</td>
                                            <td>14 May 2017</td>
                                            <td>John</td>
                                            <td>53275533</td>
                                            <td>Car</td>
                                            <td>...</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:partials/_footer.html -->
            <jsp:include page="partials/_footer.html"/>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->

<!-- plugins:js -->
<!-- container-scroller -->
<!-- plugins:js -->
<script src="vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="vendors/chart.js/Chart.min.js"></script>
<script src="vendors/datatables.net/jquery.dataTables.js"></script>
<script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<script src="js/dataTables.select.min.js"></script>

<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="js/off-canvas.js"></script>
<script src="js/hoverable-collapse.js"></script>
<script src="js/template.js"></script>
<script src="js/settings.js"></script>
<script src="js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="js/dashboard.js"></script>
<script src="js/Chart.roundedBarCharts.js"></script>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
        crossorigin="anonymous"></script>
<script>

    function loadTable() {
        $.ajax({
            url: "http://localhost:9191/gocheetah-core/city",
            dataType: 'json',
            success: function (data) {
                let val;
                let totIncome = 0.0;
                $.each(data, function (key, value) {
                    val += '<tr><td>' + value.id + '</td>' +
                        '<td>' + value.name + '</td>' +
                        '<td>' + value.postalCode + '</td>' +
                        '<td>' + value.earning + '</td></tr>';
                    totIncome += parseFloat(value.earning);
                });
                console.log(totIncome);
                $('#AllCity').html(val);
                $('#incomeTot').html(totIncome);
            }
        });
        $.ajax({
            url: "http://localhost:9191/gocheetah-core/journey",
            dataType: 'json',
            success: function (data) {
                let val;
                $.each(data, function (key, value) {
                    val += '<tr><td>' + value.id + '</td>' +
                        '<td>' + value.price.departingCity.name + '</td>' +
                        '<td>' + value.price.arrivingCity.name + '</td>' +
                        '<td>' + value.price.cost + '</td>' +
                        '<td>' + value.createdDate + '</td>' +
                        '<td>' + value.customer.username + '</td>' +
                        '<td>' + value.customer.contact + '</td>' +
                        '<td>' + value.driver.vehicle.brand + '' + value.driver.vehicle.name + '</td>' +
                        '<td ><button class="badge badge-info">' + value.status + '</button></td>';
                });
                $('#jHistory').html(val);
                $('#bookingTot').html(data.length);
            }
        });
    }
</script>
<!-- End custom js for this page-->


</html>
