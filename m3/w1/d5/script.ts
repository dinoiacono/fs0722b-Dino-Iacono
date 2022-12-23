interface Smartphone {
    carica: number;
    numeroChiamate: number;
    ricarica(unaRicarica: number): void;
    chiamata(minutiDurata: number): void;
    numero404(): void;
    getNumeroChiamate(): void;
    azzeraChiamate(): void;
}

class User implements Smartphone {
    nome: string;
    carica: number;
    numeroChiamate: number;
    constructor(nome: string, carica: number, numeroChiamate: number) {
        this.nome = nome;
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
    }
    public ricarica(unaRicarica: number): void {                                    //ricarica il telefono, l'importo della ricarica è passato tramite parametro
        this.carica = this.carica + unaRicarica;
    }
    public chiamata(minutiDurata: number): void {
        let costoMinuto: number = 0.2;                                              //effettua la chiamata e la durata è passata tramite parametro
        let costoChiamata: number = parseFloat((minutiDurata * costoMinuto).toFixed(2));
        this.numeroChiamate = this.numeroChiamate + 1;
        this.carica = parseFloat((this.carica - costoChiamata).toFixed(2));
    }
    public numero404() {                                                            //restituisce valore carica disponibile
        console.log(`Il credito disponibile è di ${this.carica} €`);
    }
    public getNumeroChiamate() {                                                    //restituisce il valore della variabile d'istanza "numeroChiamate"
        console.log(`Il numero di chiamate effettuate da ${this.nome} è ${this.numeroChiamate}`);
    }
    public azzeraChiamate() {                                                       //azzera il valore della variabile d'istanza "numeroChiamate"
        this.numeroChiamate = 0;
    }
}

class FirstUser extends User {
    constructor(nome: string, carica: number, numeroChiamate: number) {
        super(nome, carica, numeroChiamate);
    }
}
class SecondUser extends User {
    constructor(nome: string, carica: number, numeroChiamate: number) {
        super(nome, carica, numeroChiamate);
    }
}
class ThirdUser extends User {
    constructor(nome: string, carica: number, numeroChiamate: number) {
        super(nome, carica, numeroChiamate);
    }
}

let daniel = new FirstUser('Daniel', 0, 0);
daniel.ricarica(5);
daniel.chiamata(6);
daniel.getNumeroChiamate();
daniel.numero404();
daniel.azzeraChiamate();
console.log(daniel);

let dino = new SecondUser('Dino', 0, 0);
dino.ricarica(20);
dino.chiamata(24);
dino.chiamata(4);
dino.getNumeroChiamate();
console.log(dino);

let giuseppe = new ThirdUser('Giuseppe', 0, 0);
giuseppe.ricarica(7);
giuseppe.chiamata(4);
giuseppe.getNumeroChiamate();
console.log(giuseppe);

//COMPILAZIONE HTML

let arrayUtenti: any[] = [daniel, dino, giuseppe];
for (let i = 0; i < arrayUtenti.length; i++) {
    let contenuto: HTMLDivElement = <HTMLDivElement>document.querySelector('.row');
    contenuto.innerHTML += `
            <div class="col-4">
                <h2 class="text-center">${arrayUtenti[i].nome}</h2>
                <figure class="iphone mb-5">

                    <div class="side-buttons">
                        <div></div>
                    </div>

                    <div class="phone">
                    <div class="top">
                    <div>
                        <span class="camera"></span>
                        <span class="speaker"></span>
                    </div>
                    </div>   
                    <div class="screen">
                        <p id="${arrayUtenti[i].nome}-carica-soldi">Il saldo di ${arrayUtenti[i].nome} è di ${arrayUtenti[i].carica} €</p>
                        <p id="${arrayUtenti[i].nome}-chiamate-fatte">Il numero di chiamate effettuate da ${arrayUtenti[i].nome} è di ${arrayUtenti[i].numeroChiamate}</p>
                    </div>
                    <div class="bottom">
                        <div></div>
                    </div>
                    </div>
                </figure>
                <div class="d-flex flex-column align-items-center ">
                    <div class="mb-3 w-100 row justify-content-center">
                        <input type="text" placeholder="Quanto ricarichi?" class="col-7 ricarica-valore" id="${arrayUtenti[i].nome}-ricarica-valore">
                        <button class="col-5 ricarica-bottone" id="${arrayUtenti[i].nome}-ricarica">Effettua Ricarica</button>
                    </div>
                    <div class="row w-100">
                        <input type="text" placeholder="Quanto dura la chiamata?"class="col-9 chiamata-durata" id="${arrayUtenti[i].nome}-durata-chiamata">
                        <button class="col-3 chiamata-bottone" id="${arrayUtenti[i].nome}-chiama">Chiama</button>
                    </div>
                </div>
            </div>`
}

////// FUNZIONI ///////

let danielCaricaSoldi = <HTMLParagraphElement>document.querySelector('#Daniel-carica-soldi');
let valoreRicaricaDaniel = <HTMLInputElement>document.querySelector('#Daniel-ricarica-valore');
let bottoneRicaricaDaniel = <HTMLButtonElement>document.querySelector('#Daniel-ricarica');

let dinoCaricaSoldi = <HTMLParagraphElement>document.querySelector('#Dino-carica-soldi');
let valoreRicaricaDino = <HTMLInputElement>document.querySelector('#Dino-ricarica-valore');
let bottoneRicaricaDino = <HTMLButtonElement>document.querySelector('#Dino-ricarica');

let giuseppeCaricaSoldi = <HTMLParagraphElement>document.querySelector('#Giuseppe-carica-soldi');
let valoreRicaricaGiuseppe = <HTMLInputElement>document.querySelector('#Giuseppe-ricarica-valore');
let bottoneRicaricaGiuseppe = <HTMLButtonElement>document.querySelector('#Giuseppe-ricarica');

bottoneRicaricaDaniel.addEventListener('click', () => {
    danielCaricaSoldi.textContent = `Il saldo di Daniel è di ${(daniel.carica + eval(valoreRicaricaDaniel.value))} €`;
    valoreRicaricaDaniel.value = '';
});
bottoneRicaricaDino.addEventListener('click', () => {
    dinoCaricaSoldi.textContent = `Il saldo di Dino è di ${dino.carica + eval(valoreRicaricaDino.value)} €`;
    valoreRicaricaDino.value = '';
});
bottoneRicaricaGiuseppe.addEventListener('click', () => {
    giuseppeCaricaSoldi.textContent = `Il saldo di Giuseppe è di ${giuseppe.carica + eval(valoreRicaricaGiuseppe.value)} €`;
    valoreRicaricaGiuseppe.value = '';
});