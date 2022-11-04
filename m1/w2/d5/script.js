function aggiungiCifra(bottone){

    document.getElementById("numeri").value += bottone.getAttribute('data-simbolo');

}

function tot(){
    let numeri = document.getElementById("numeri");
    numeri.value = eval(numeri.value);
}

function del(){
    document.getElementById("numeri").value = "";
}


