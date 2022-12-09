
const contenitore = document.querySelector('#utenti')

async function prendiDati(){
    let risposta = await fetch('json/users.json')
    let utenti = await risposta.json()
    utenti.forEach(element => {
       creaCarta(element)
    });
}
prendiDati()
console.log(users);

function creaCarta(element){
        
        
        let carta = document.createElement('div')
        carta.className = 'd-flex flex-column justify-content-center text-center col-4 border p-4'
        
        let immagine = document.createElement('img')
        immagine.src = element.profileURL
        immagine.className = 'rounded-circle bg-secondary bg-opacity-25 mb-3 w-25 mx-auto'

        let nome = document.createElement('p')
        nome.innerText = `${element.firstName} ${element.lastName}`

        let mail = document.createElement('a')
        mail.href = `mailto:${element.email}`
        mail.innerText = element.email
        mail.className = 'text-decoration-none text-warning'

        contenitore.append(carta);
        carta.appendChild(immagine)
        carta.appendChild(nome)
        carta.appendChild(mail)
}
