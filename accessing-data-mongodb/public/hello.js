$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/customer/A"
    }).then(function(data, status, jqxhr) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.firstName);
        console.log(jqxhr);
    });
});