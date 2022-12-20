var balanceint = 1000;
var SonAccount = /** @class */ (function () {
    function SonAccount() {
    }
    SonAccount.prototype.Deposit = function (versamento) {
        return balanceint + versamento;
    };
    SonAccount.prototype.WithDraw = function (prelievo) {
        return balanceint - prelievo;
    };
    return SonAccount;
}());
var MotherAccount = /** @class */ (function () {
    function MotherAccount() {
    }
    MotherAccount.prototype.Deposit = function (versamento) {
        return balanceint + versamento;
    };
    MotherAccount.prototype.WithDraw = function (prelievo) {
        return balanceint - prelievo;
    };
    MotherAccount.prototype.addInterest = function (interessi) {
        return 'gli interessi sono di ' + (balanceint / 100) * interessi + '€';
    };
    return MotherAccount;
}());
var conto1 = new SonAccount();
console.log(conto1.Deposit(100));
console.log(conto1.WithDraw(50));
var conto2 = new MotherAccount();
console.log(conto2.Deposit(200));
console.log(conto2.WithDraw(200));
console.log(conto2.addInterest(10));
