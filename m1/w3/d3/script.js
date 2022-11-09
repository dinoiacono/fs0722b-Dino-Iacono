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
        .append(div);//sposto il div nella lista completati
    })

    div.append(span, completato);
    document.querySelector('#da-fare').append(div);


    testo.value = '';            
});

