/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function confirmer(){
    var res = confirm('Etes-vous sûr de vouloir supprimer ce produit?');
    if(res == true) {
        window.location="admin.jsp";
    } else {
        event.preventDefault();
    }
}

