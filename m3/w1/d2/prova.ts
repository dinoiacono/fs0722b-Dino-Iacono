var balanceint:number = 1000;

class SonAccount{
    Deposit(versamento:number){
        return balanceint+versamento;
    }
    WithDraw(prelievo:number) {
        return balanceint-prelievo
    }
}

class MotherAccount{
    Deposit(versamento:number) {
        return balanceint+versamento;
    }
    WithDraw(prelievo:number) {
        return balanceint-prelievo
    }
    addInterest(interessi:number){
        return 'gli interessi sono di ' +(balanceint/100)*interessi + '€'
    }
}

const conto1 = new SonAccount();
console.log(conto1.Deposit(100));
console.log(conto1.WithDraw(50));

const conto2 = new MotherAccount();
console.log(conto2.Deposit(200));
console.log(conto2.WithDraw(200));
console.log(conto2.addInterest(10));
