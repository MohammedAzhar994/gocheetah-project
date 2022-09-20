$("#loginForm").submit(function (event) {
    var formData = {
        email: $("#loginEmail").val(),
        password: $("#loginPass").val(),
    };
    $.ajax({
        url: "http://localhost:9191/gocheetah-core/login",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            alert("Success");
            if (data.role === "Customer") {
                window.location.replace("/go-cheetah-client/client-front?id="+data.id)
            } else if (data.role === "Admin") {
                window.location.replace("admin_home.jsp?id="+data.id)
            } else if (data.role === "Driver") {
                window.location.replace("driver-view.jsp?id="+data.id)
            }
        }, error: function (jqXHR, textStatus, errorThrown) {
            alert("Error");
        }
    });
    event.preventDefault();
});
$("#regiForm").submit(function (event) {
    var formData = JSON.stringify({
        "email": $("#regEmail").val(),
        "password": $("#regPass").val(),
        "contact": $("#regCon").val(),
        "address": $("#regAdres").val(),
        "username": $("#regName").val()
    });
    console.log(formData);
    $.ajax({
        url: "http://localhost:9191/gocheetah-core/customer",
        dataType: 'json',
        contentType: "application/json",
        data: formData,
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            alert("Success");
            window.location.replace("http://localhost:8080/go-cheetah-client/client-back/index.jsp")
        }, error: function (jqXHR, textStatus, errorThrown) {
            alert("Error");
        }
    });
    event.preventDefault();
});