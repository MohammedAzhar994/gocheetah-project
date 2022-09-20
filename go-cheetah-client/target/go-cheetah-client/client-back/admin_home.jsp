<%-- 
    Document   : index.jsp
    Created on : Sep 14, 2022, 9:12:45 PM
    Author     : grays
--%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>GoCheetah Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/feather/feather.css">
  <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="vendors/select2/select2.min.css">
  <link rel="stylesheet" href="vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
</head>
<body onload="loadData()">
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
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Branch Register</h4>
                  <form id="BranchRegister" onsubmit="return false" class="forms-sample">
                    <div class="form-group">
                      <label for="BranchName">Branch Name</label>
                      <input type="text" class="form-control" id="BranchName" placeholder="Branch Name">
                    </div>
                    <div class="form-group">
                      <label for="BranchPostalCode">Branch Postal Code</label>
                      <input type="text" class="form-control" id="BranchPostalCode" placeholder="Branch Postal Code">
                    </div>
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Inter Branch Cost Manager</h4>
                  <form id="PriceRegister" onsubmit="return false" class="forms-sample">
                    <div class="form-group">
                      <label for="PackageName">Package Name</label>
                      <input type="text" class="form-control" id="PackageName" placeholder="Package Name">
                    </div>
                    <div class="form-group">
                      <label for="Branchlist1">Branch From</label>
                      <select id="Branchlist1" class="js-example-basic-single w-100">

                      </select>
                    </div>
                    <div class="form-group">
                      <label for="Branchlist1">Branch To</label>
                      <select id="Branchlist2" class="js-example-basic-single w-100">

                      </select>
                    </div>
                    <div class="form-group">
                      <label for="cost">Package Cost</label>
                      <input type="number" class="form-control" id="cost" placeholder="400">
                    </div>
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Driver Register</h4>
                  <form id="DriverRegister" onsubmit="return false" class="forms-sample">
                    <div class="form-group">
                      <label for="DriverName">Driver Name</label>
                      <input type="text" class="form-control" id="DriverName" placeholder="Driver Name">
                    </div>
                    <div class="form-group">
                      <label for="DriverEmail">Driver Email</label>
                      <input type="text" class="form-control" id="DriverEmail" placeholder="Driver Email">
                    </div>
                    <div class="form-group">
                      <label for="DriverCon">Driver Contact</label>
                      <input type="text" class="form-control" id="DriverCon" placeholder="Driver Contact">
                    </div>
                    <div class="form-group">
                      <label for="DriverPassword">Driver Password</label>
                      <input type="password" class="form-control" id="DriverPassword" placeholder="Driver Password">
                    </div>
                    <div class="form-group">
                      <label for="DriverBranch">Driver Branch</label>
                      <select id="DriverBranch" class="js-example-basic-single w-100">

                      </select>
                    </div>
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Vehicle Register</h4>
                  <form id="VehicleRegister" onsubmit="return false" class="forms-sample">
                    <div class="form-group">
                      <label for="VehicleName">Vehicle Name</label>
                      <input type="text" class="form-control" id="VehicleName" placeholder="Vehicle Name">
                    </div>
                    <div class="form-group">
                      <label for="VehicleBrand">Vehicle Brand</label>
                      <input type="text" class="form-control" id="VehicleBrand" placeholder="Vehicle Brand">
                    </div>
                    <div class="form-group">
                      <label for="VehicleBrand">Vehicle Seat Count</label>
                      <input type="number" class="form-control" id="VehicleSeat" placeholder="4">
                    </div>
                    <div class="form-group">
                      <label for="VehicleType">Vehicle Type</label>
                        <select id="VehicleType" class="js-example-basic-single w-100">
                          <option value="Three Wheel">Three Wheel</option>
                          <option value="Sedan">Sedan</option>
                          <option value="SUV">SUV</option>
                          <option value="Van">Van</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                  </form>
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
  <script src="vendors/typeahead.js/typeahead.bundle.min.js"></script>
  <script src="vendors/select2/select2.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="js/file-upload.js"></script>
  <script src="js/typeahead.js"></script>
  <script src="js/select2.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
  <script>

    function loadData() {
      $.ajax({
        url: "http://localhost:9191/gocheetah-core/city",
        dataType: 'json',
        success: function (data) {
          let val;
          $.each(data, function (key, value) {
            val += '<option value="'+ value.id+'">'+ value.name+'</option>';
          });
          $('#DriverBranch').html(val);
          $('#Branchlist1').html(val);
          $('#Branchlist2').html(val);
        }
      });
    }
    $("#BranchRegister").submit(function (event) {
      var formData = JSON.stringify({
        "name":$("#BranchName").val(),
        "postalCode": $("#BranchPostalCode").val()
      });
      console.log(formData);
      $.ajax({
        url: "http://localhost:9191/gocheetah-core/city",
        dataType: 'json',
        contentType: "application/json",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
          alert("Success");
          loadData();
        }, error: function (jqXHR, textStatus, errorThrown) {
          alert("Error");
        }
      });
      event.preventDefault();
    });
    $("#PriceRegister").submit(function (event) {
      var formData = {
        name:$("#PackageName").val(),
        city1:$("#Branchlist1").val(),
        city2:$("#Branchlist2").val(),
        cost: $("#cost").val()
      };
      console.log(formData);
      $.ajax({
        url: "http://localhost:9191/gocheetah-core/price",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
          alert("Success");
        }, error: function (jqXHR, textStatus, errorThrown) {
          alert("Error");
        }
      });
      event.preventDefault();
    });
    $("#DriverRegister").submit(function (event) {
      var formData = JSON.stringify({
        "email":$("#DriverEmail").val(),
        "password": $("#DriverPassword").val(),
        "contact": $("#DriverCon").val(),
        "cityId": $("#DriverBranch").val(),
        "username": $("#DriverName").val()
      });
      console.log(formData);
      $.ajax({
        url: "http://localhost:9191/gocheetah-core/driver",
        dataType: 'json',
        contentType: "application/json",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
          alert("Success");
        }, error: function (jqXHR, textStatus, errorThrown) {
          alert("Error");
        }
      });
      event.preventDefault();
    });
    $("#VehicleRegister").submit(function (event) {
      var formData = JSON.stringify({
        "brand":$("#VehicleBrand").val(),
        "name": $("#VehicleName").val(),
        "type": $("#VehicleType").val(),
        "seatCount": $("#VehicleSeat").val(),
      });
      console.log(formData);
      $.ajax({
        url: "http://localhost:9191/gocheetah-core/vehicle",
        dataType: 'json',
        contentType: "application/json",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
          alert("Success");
        }, error: function (jqXHR, textStatus, errorThrown) {
          alert("Error");
        }
      });
      event.preventDefault();
    });
  </script>
  <!-- End custom js for this page-->
</body>

</html>

