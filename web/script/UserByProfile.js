$(document).ready(function () {
    $.ajax({
        url: "FindByRole",
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("erreur");
        }
    });

    $("#profils").change(function () {
        $.ajax({
            url: "FindByRole",
            data: {role: $(this).val()},
            success: function (data, textStatus, jqXHR) {
                remplirUser(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("erreur");
            }
        });
    });

    function remplirUser(data){
        var ligne  = "";
        var content = $("#content");
        data.forEach(function(e){
            ligne+="<tr><td>"+e.id+"</td><td>"+e.nom+"</td><td>"+e.prenom+"</td></tr>";
        });
        content.html(ligne);
    }
    function remplir(data) {
        var liste = $("#profils");
        var option = "";
        for (i = 0; i < data.length; i++) {
            option += "<option value = " + data[i] + ">" + data[i] + "</option>";
        }
        liste.html(option);
    }
});


