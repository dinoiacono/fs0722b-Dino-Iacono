let tempo= sessionStorage.getItem('tempo')
let p = document.getElementById('timer')

function contaSecondi(){
    setInterval(() => {
        tempo++
        sessionStorage.setItem('tempo', tempo)
        p.innerHTML = tempo
    }, 1000);
}

contaSecondi()
