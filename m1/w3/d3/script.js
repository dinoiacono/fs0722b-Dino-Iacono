document.querySelector('#salva')
.addEventListener('click', function(){

    let testo = document.querySelector('#testo');
    
    let div = document.createElement('div');
    //div.classList.add('todo')
    
    let span = document.createElement('span');
    span.textContent = testo.value;

    let completato = document.createElement('button');
    completato.textContent = 'Fatto!';

    completato.addEventListener('click', ()=> {
        //div.classList.add('completato');//assegno una classe aggiuntiva
        document.querySelector('#fatti')
        .append(div);//sposto il div nella lista 
    })

    div.append(span, completato);//metto il testo ed il bottone nel div
    document.querySelector('#da-fare').append(div);//metto il div nella lista da fare


    testo.value = '';            
});

