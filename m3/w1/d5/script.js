var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var User = /** @class */ (function () {
    function User(nome, carica, numeroChiamate) {
        this.nome = nome;
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
    }
    User.prototype.ricarica = function (unaRicarica) {
        this.carica = this.carica + unaRicarica;
    };
    User.prototype.chiamata = function (minutiDurata) {
        var costoMinuto = 0.2; //effettua la chiamata e la durata è passata tramite parametro
        var costoChiamata = parseFloat((minutiDurata * costoMinuto).toFixed(2));
        this.numeroChiamate = this.numeroChiamate + 1;
        this.carica = parseFloat((this.carica - costoChiamata).toFixed(2));
    };
    User.prototype.numero404 = function () {
        console.log("Il credito disponibile \u00E8 di ".concat(this.carica, " \u20AC"));
    };
    User.prototype.getNumeroChiamate = function () {
        console.log("Il numero di chiamate effettuate da ".concat(this.nome, " \u00E8 ").concat(this.numeroChiamate));
    };
    User.prototype.azzeraChiamate = function () {
        this.numeroChiamate = 0;
    };
    return User;
}());
var FirstUser = /** @class */ (function (_super) {
    __extends(FirstUser, _super);
    function FirstUser(nome, carica, numeroChiamate) {
        return _super.call(this, nome, carica, numeroChiamate) || this;
    }
    return FirstUser;
}(User));
var SecondUser = /** @class */ (function (_super) {
    __extends(SecondUser, _super);
    function SecondUser(nome, carica, numeroChiamate) {
        return _super.call(this, nome, carica, numeroChiamate) || this;
    }
    return SecondUser;
}(User));
var ThirdUser = /** @class */ (function (_super) {
    __extends(ThirdUser, _super);
    function ThirdUser(nome, carica, numeroChiamate) {
        return _super.call(this, nome, carica, numeroChiamate) || this;
    }
    return ThirdUser;
}(User));
var daniel = new FirstUser('Daniel', 0, 0);
daniel.ricarica(5);
daniel.chiamata(6);
daniel.getNumeroChiamate();
daniel.numero404();
daniel.azzeraChiamate();
console.log(daniel);
var dino = new SecondUser('Dino', 0, 0);
dino.ricarica(20);
dino.chiamata(24);
dino.chiamata(4);
dino.getNumeroChiamate();
console.log(dino);
var giuseppe = new ThirdUser('Giuseppe', 0, 0);
giuseppe.ricarica(7);
giuseppe.chiamata(4);
giuseppe.getNumeroChiamate();
console.log(giuseppe);
//COMPILAZIONE HTML
var arrayUtenti = [daniel, dino, giuseppe];
for (var i = 0; i < arrayUtenti.length; i++) {
    var contenuto = document.querySelector('.row');
    contenuto.innerHTML += "\n            <div class=\"col-4\">\n                <h2 class=\"text-center\">".concat(arrayUtenti[i].nome, "</h2>\n                <figure class=\"iphone mb-5\">\n\n                    <div class=\"side-buttons\">\n                        <div></div>\n                    </div>\n\n                    <div class=\"phone\">\n                    <div class=\"top\">\n                    <div>\n                        <span class=\"camera\"></span>\n                        <span class=\"speaker\"></span>\n                    </div>\n                    </div>   \n                    <div class=\"screen\">\n                        <p id=\"").concat(arrayUtenti[i].nome, "-carica-soldi\">Il saldo di ").concat(arrayUtenti[i].nome, " \u00E8 di ").concat(arrayUtenti[i].carica, " \u20AC</p>\n                        <p id=\"").concat(arrayUtenti[i].nome, "-chiamate-fatte\">Il numero di chiamate effettuate da ").concat(arrayUtenti[i].nome, " \u00E8 di ").concat(arrayUtenti[i].numeroChiamate, "</p>\n                    </div>\n                    <div class=\"bottom\">\n                        <div></div>\n                    </div>\n                    </div>\n                </figure>\n                <div class=\"d-flex flex-column align-items-center \">\n                    <div class=\"mb-3 w-100 row justify-content-center\">\n                        <input type=\"text\" placeholder=\"Quanto ricarichi?\" class=\"col-7 ricarica-valore\" id=\"").concat(arrayUtenti[i].nome, "-ricarica-valore\">\n                        <button class=\"col-5 ricarica-bottone\" id=\"").concat(arrayUtenti[i].nome, "-ricarica\">Effettua Ricarica</button>\n                    </div>\n                    <div class=\"row w-100\">\n                        <input type=\"text\" placeholder=\"Quanto dura la chiamata?\"class=\"col-9 chiamata-durata\" id=\"").concat(arrayUtenti[i].nome, "-durata-chiamata\">\n                        <button class=\"col-3 chiamata-bottone\" id=\"").concat(arrayUtenti[i].nome, "-chiama\">Chiama</button>\n                    </div>\n                </div>\n            </div>");
}
////// FUNZIONI ///////
var danielCaricaSoldi = document.querySelector('#Daniel-carica-soldi');
var valoreRicaricaDaniel = document.querySelector('#Daniel-ricarica-valore');
var bottoneRicaricaDaniel = document.querySelector('#Daniel-ricarica');
var dinoCaricaSoldi = document.querySelector('#Dino-carica-soldi');
var valoreRicaricaDino = document.querySelector('#Dino-ricarica-valore');
var bottoneRicaricaDino = document.querySelector('#Dino-ricarica');
var giuseppeCaricaSoldi = document.querySelector('#Giuseppe-carica-soldi');
var valoreRicaricaGiuseppe = document.querySelector('#Giuseppe-ricarica-valore');
var bottoneRicaricaGiuseppe = document.querySelector('#Giuseppe-ricarica');
bottoneRicaricaDaniel.addEventListener('click', function () {
    danielCaricaSoldi.textContent = "Il saldo di Daniel \u00E8 di ".concat((daniel.carica + eval(valoreRicaricaDaniel.value)), " \u20AC");
    valoreRicaricaDaniel.value = '';
});
bottoneRicaricaDino.addEventListener('click', function () {
    dinoCaricaSoldi.textContent = "Il saldo di Dino \u00E8 di ".concat(dino.carica + eval(valoreRicaricaDino.value), " \u20AC");
    valoreRicaricaDino.value = '';
});
bottoneRicaricaGiuseppe.addEventListener('click', function () {
    giuseppeCaricaSoldi.textContent = "Il saldo di Giuseppe \u00E8 di ".concat(giuseppe.carica + eval(valoreRicaricaGiuseppe.value), " \u20AC");
    valoreRicaricaGiuseppe.value = '';
});
