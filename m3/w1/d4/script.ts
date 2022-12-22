var contenitore :HTMLElement= document.getElementById('contenitore');

class Vestito {
    id: number
    codprod: number
    collezione: string
    capo: string
    modello: number
    quantita: number
    colore: string
    prezzoivaesclusa: number
    prezzoivainclusa: number
    disponibile: string
    saldo: number
    getSaldoCapo(): number {
        return parseFloat((this.prezzoivainclusa / 100 * this.saldo).toFixed(2))};
    getAcquistoCapo(): number {
        return parseFloat((this.prezzoivainclusa - this.getSaldoCapo()).toFixed(2))}
    constructor(element) {
        this.id = element.id
        this.codprod = element.codprod
        this.collezione = element.collezione
        this.capo = element.capo
        this.modello = element.modello
        this.quantita = element.quantita
        this.colore = element.colore
        this.prezzoivaesclusa = element.prezzoivaesclusa
        this.prezzoivainclusa = element.prezzoivainclusa
        this.disponibile = element.disponibile
        this.saldo = element.saldo 
        
    }
}

let vestiti = [];

fetch("https://mocki.io/v1/765b2daf-41d5-4e94-a0d5-abd918f57b8f")
    .then(response => response.json())
    .then(result => {
        result.forEach(element => {
            
            vestiti.push(new Vestito(element))
          
        })
            //console.log(vestiti[0].getSaldoCapo())
        vestiti.forEach(element => {
    console.log(element);
    contenitore.innerHTML +=`<div class="col-2 border rounded-3 justify-content-center text-center px-0">
    <img src="download.jpeg" alt="" class="w-100 rounded-top mb-2">
    <h2>${element.capo}</h2>
    <p class="mb-0">${element.collezione}</p>
    <span class="fs-4 text-decoration-line-through">${element.prezzoivainclusa}</span>
    <p class="fs-3 text-danger">${element.getAcquistoCapo()}</p>
</div>`
});
  });
  
  
  



