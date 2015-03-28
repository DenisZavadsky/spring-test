$(document).ready(function(){
    getStockUpdate();
    //setInterval(getStockUpdate,5000);
    getStockUpdateById();
});

function getStockUpdate(){
    var companies = $("tr").each(function (index,element){
        var company = element.id;
        $.ajax({
            url:"/getUpdates?company="+company,
            dataType: "json",
            success: function(data){
                updateCompanyRow(data);
            }
        });
    });

}

function getStockUpdateById(){


        $.ajax({
            url:"/getUpdate/"+123,
            dataType: "json",
            success: function(data){
                updateCompanyRow(data);
            },
            error: function (jqXHR, textStatus, errorThrown){
                alert(textStatus);
            }
        });

}

function updateCompanyRow(data){
    var company = data.company;
    $("#"+company+"_PRICE").html(data.price);
    $("#"+company+"_VOLUME").html(data.volume);
}