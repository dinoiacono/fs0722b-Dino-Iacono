var contenitore = document.getElementById('contenitore');
var Vestito = /** @class */ (function () {
    function Vestito(element) {
        this.id = element.id;
        this.codprod = element.codprod;
        this.collezione = element.collezione;
        this.capo = element.capo;
        this.modello = element.modello;
        this.quantita = element.quantita;
        this.colore = element.colore;
        this.prezzoivaesclusa = element.prezzoivaesclusa;
        this.prezzoivainclusa = element.prezzoivainclusa;
        this.disponibile = element.disponibile;
        this.saldo = element.saldo;
    }
    Vestito.prototype.getSaldoCapo = function () {
        return parseFloat((this.prezzoivainclusa / 100 * this.saldo).toFixed(2));
    };
    ;
    Vestito.prototype.getAcquistoCapo = function () {
        return parseFloat((this.prezzoivainclusa - this.getSaldoCapo()).toFixed(2));
    };
    return Vestito;
}());
var vestiti = [];
fetch("https://mocki.io/v1/765b2daf-41d5-4e94-a0d5-abd918f57b8f")
    .then(function (response) { return response.json(); })
    .then(function (result) {
    result.forEach(function (element) {
        vestiti.push(new Vestito(element));
    });
    //console.log(vestiti[0].getSaldoCapo())
    vestiti.forEach(function (element) {
        console.log(element);
        contenitore.innerHTML += "<div class=\"col-2 border rounded-3 justify-content-center text-center px-0\">\n    <img src=\"download.jpeg\" alt=\"\" class=\"w-100 rounded-top mb-2\">\n    <h2>".concat(element.capo, "</h2>\n    <p class=\"mb-0\">").concat(element.collezione, "</p>\n    <span class=\"fs-4 text-decoration-line-through\">").concat(element.prezzoivainclusa, "</span>\n    <p class=\"fs-3 text-danger\">").concat(element.getAcquistoCapo(), "</p>\n</div>");
    });
});
