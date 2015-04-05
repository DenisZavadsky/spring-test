$(document).ready(function(){
    $(".edit-transaction").click(function (event) {
        event.preventDefault();
        var currentButton = $(this);
        var transId = currentButton.data("id");
        var transAccount = currentButton.data("account-number");

        $.ajax({
            url:"/trans/edit/"+transId,
            dataType: "html",
            success: function(data){
                $("#popup-wrapper").html(data);
                //$('#popup-wrapper').easyModal({
                //    top: 200,
                //    overlay: 0.2,
                //    transitionIn: 'animated bounceInLeft',
                //    transitionOut: 'animated bounceOutRight',
                //    closeButtonClass: '.animated-close'
                //});
                $("#popup-wrapper").modal();
                $("#edit-submit").click(function(){
                    event.preventDefault();
                    submitEditForm();
                });
            }
        });
    });
});

function submitEditForm(){
    var data = {
        id: $("input[name='id']").val(),
        accountNumber: $("input[name='accountNumber']").val(),
        amount: $("input[name='amount']").val()
       // date: $("input[name='date']").val()
    };
    $.ajax({
            url:"/trans/edit",
            type:"POST",
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            data: data,
            dataType: "text",
            success: function(data){
                window.location="/trans/index";
            }
        }
    );
}