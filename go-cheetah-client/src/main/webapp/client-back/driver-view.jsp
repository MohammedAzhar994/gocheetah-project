<%--
  Created by IntelliJ IDEA.
  User: Mohammed Azhar
  Date: 18-Sep-22
  Time: 9:10 PM
--%>
<%--
  Created by IntelliJ IDEA.
  User: Mohammed Azhar
  Date: 18-Sep-22
  Time: 2:56 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
%>
<html>
<head>
    <title>Driver Account</title>
    <link rel="stylesheet" href="../client-back/vendors/feather/feather.css">
    <link rel="stylesheet" href="../client-back/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="../client-back/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../client-back/css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../client-back/images/favicon.png"/>
</head>
<body onload="loadTable()">
<div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="../client-back/partials/_navbar.html"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_settings-panel.html -->
        <jsp:include page="../client-back/partials/_settings-panel.html"/>
        <!-- partial -->
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="driver-view.jsp">
                        <i class="icon-grid menu-icon"></i>
                        <span class="menu-title">Account</span>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Ride History</h4>
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
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody id="RideHistory">
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
                                    <td>
                                        <button class="badge badge-success">Fixed</button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../client-back/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="../client-back/js/off-canvas.js"></script>
<script src="../client-back/js/hoverable-collapse.js"></script>
<script src="../client-back/js/template.js"></script>
<script src="../client-back/js/settings.js"></script>
<script src="../client-back/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<!-- End custom js for this page-->
<script>
    function loadTable() {
        $.ajax({
            url: "http://localhost:9191/gocheetah-core/journey/driver?id=<%=id%>",
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
                    if (value.status !== "Driver Accepted") {
                        val += '<td><button onclick="updateDriverStatus(' + value.id + ')" class="badge badge-success">Accept the Ride</button></td></tr>';
                    } else {
                        val += '<td><button disabled class="badge badge-success">Accept the Ride</button></td></tr>';
                    }
                });
                $('#RideHistory').html(val);
            }
        });
    }

    function updateDriverStatus(id) {
        var formData = {
            id: id
        }
        $.ajax({
            url: "http://localhost:9191/gocheetah-core/journey/driver/accept",
            type: 'POST',
            data: formData,
            dataType: 'json',
            success: function (data) {
                alert("Success");
                loadTable();
            }, error: function (data) {
                alert("Error");
            }
        });
    }

</script>
</body>
</html>

