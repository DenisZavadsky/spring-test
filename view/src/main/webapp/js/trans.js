$(document).ready(function(){
    $(".edit-transaction").click(function (event) {
        event.preventDefault();
        var currentButton = $(this);
        var transId = currentButton.data("id");
        var transAccount = currentButton.data("account-number");
        alert("Id="+transId+" account number = " +transAccount);
    });
});