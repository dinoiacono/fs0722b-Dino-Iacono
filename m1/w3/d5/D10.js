/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/
/* Questo array viene usato per gli esercizi. Non modificarlo. */

const movies = [
  {
    Title: "The Lord of the Rings: The Fellowship of the Ring",
    Year: "2001",
    imdbID: "tt0120737",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg",
  },

  {
    Title: "The Lord of the Rings: The Return of the King",
    Year: "2003",
    imdbID: "tt0167260",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
  },
  {
    Title: "The Lord of the Rings: The Two Towers",
    Year: "2002",
    imdbID: "tt0167261",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
  },
  {
    Title: "Lord of War",
    Year: "2005",
    imdbID: "tt0399295",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg",
  },
  {
    Title: "Lords of Dogtown",
    Year: "2005",
    imdbID: "tt0355702",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg",
  },
  {
    Title: "The Lord of the Rings",
    Year: "1978",
    imdbID: "tt0077869",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg",
  },
  {
    Title: "Lord of the Flies",
    Year: "1990",
    imdbID: "tt0100054",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg",
  },
  {
    Title: "The Lords of Salem",
    Year: "2012",
    imdbID: "tt1731697",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg",
  },
  {
    Title: "Greystoke: The Legend of Tarzan, Lord of the Apes",
    Year: "1984",
    imdbID: "tt0087365",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg",
  },
  {
    Title: "Lord of the Flies",
    Year: "1963",
    imdbID: "tt0057261",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg",
  },
  {
    Title: "The Avengers",
    Year: "2012",
    imdbID: "tt0848228",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
  },
  {
    Title: "Avengers: Infinity War",
    Year: "2018",
    imdbID: "tt4154756",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg",
  },
  {
    Title: "Avengers: Age of Ultron",
    Year: "2015",
    imdbID: "tt2395427",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg",
  },
  {
    Title: "Avengers: Endgame",
    Year: "2019",
    imdbID: "tt4154796",
    Type: "movie",
    Poster:
      "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg",
  },
];

// JS Basics

/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.
*/

let sum = 10 + 20; //creo la variable e gli attribuisco come valore 10+20
//console.log(sum); //uso il console.log() per verificare che il valore sia esatto

/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/

let random = Math.random() * 20; //creo la variabile ed uso il metodo Math.random() per attribuirgli un valore casuale tra 0 e 20
//console.log(random);        //uso il console.log() per verificarne il funzionamento

/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/

let me = {
  //creo la variabile col nome me e gli assegno un oggetto con le proprietà sopra elencate
  name: "Dino",
  surname: "Iacono",
  age: "22",
};
//console.log(me);            //uso il console.log() per verificare

/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/

delete me.age; //uso delete per eliminare la proprietà specifica age all'interno di me
//console.log(me);              //verifico di aver eliminato correttamente la proprietà

/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/

me.skills = [
  //mi richiamo l'oggetto me e gli aggiungo la proprietà skills
  "HTML",
  "CSS",
  "JAVASCRIPT",
];
//console.log(me);   //verifico di aver aggiunto correttamente la proprietà

/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/

me.skills.push("elemento aggiunto con push"); //mi richiamo l'array skills contenuto nell'oggetto me e con push aggiungo un nuovo elemento
//console.log(me);                          //verifico di aver eseguito correttamente l'operazione

/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/

me.skills.pop(); //mi richiamo l'array skills contenuto nell'oggetto me e con pop rimuovo l'ultimo elemento
//console.log(me);                          //verifico di aver eseguito correttamente l'operazione

// Funzioni

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/

function dice() {
  //con il metodo math.floor mi prendo solo i numeri interi e non decimali
  let numero = Math.floor(Math.random() * 6 + 1); //con il metodo math.random genero un numero casuale da 1 a 6 e poi uso return per avere il valore in console
  return numero;
}
//console.log(dice());

/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/

function whoIsBigger(a, b) {
  //imposto come parametri della funzione i due numeri da confrontare
  if (a > b) {
    //uso un if in modo da ccapire qual'è il numero maggiore
    return a; //con return ho il valore più grande in console
  } else {
    return b;
  }
}
//console.log(whoIsBigger(8,7))
/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.

  Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/

function splitMe(str) {
  //imposto una stringa come parametro della funzione
  return str.split(" "); //uso split con valore lo spazio in modo che mi ritorni un'array contenente le parole intere altrimenti mi farebbe un'array con tutte le lettere separate
}
//console.log(splitMe('i love coding'));

/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/

function deleteOne(str, booleano = true) {
  //imposto come parametri della funzione una stringa e un booleano impostato a true
  if (booleano) {
    //eseguo la verifica che il booleano sia true e ritorno la stringa senza la prima lettera usando slice, nel caso il booleano sia false me ritorna la stringa senza l'ultima lettera
    return str.slice(1);
  } else {
    return str.slice(0, -1);
  }
}
//console.log(deleteOne('ciao', false));
/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/

function onlyLetters(str) {
  //uso replace im modo da prendere tutti i caratteri numerici e sostituirli con un carattere nullo
  let noNumeri = str.replace(/[0-9]/g, "");
  return noNumeri;
}
//console.log(onlyLetters("I have 4 dogs"));
/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/

function isThisAnEmail(email) {
  return email.indexOf("@") > 0 && email.indexOf(".") > 0; //tramite index of verifico la presenza dei due caratteri necessari per l'e-mail
}
//console.log(isThisAnEmail('dino@google.com'));
/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/

function whatDayIsIt() {
  let data = new Date(); //con new date prendo la data
  return data.getDay(); //con get day prendo solo il giorno della data presa prima
}

/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/

function rollTheDices(numero) {
  //eseguo un ciclo e come numero di cicli imposto il parametro, poi prendo ogni tiro e li sommo all'interno di sum, ed il valore di ogni tiro lo metto all'interno di values tramite il push
  let result = {
    sum: 0,
    values: [],
  };
  for (let i = 0; i < numero; i++) {
    let diceTiro = dice();
    result.sum += diceTiro;
    result.values.push(diceTiro);
  }

  return result;
}
//console.log(rollTheDices(6));
/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/

function howManyDays(data) {
  //ottengo la data con new date e la imposto come data1, come data 2 mi prendo il valore del parametro e poi eseguo l'operazione prendendo i numeri interi e dividendoli con l'espressione dopo
  let data1 = new Date();
  let data2 = new Date(data);
  return parseInt((data1 - data2) / (1000 * 60 * 60 * 24), 10);
}
//console.log(howManyDays('2020-02-06'));
/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/
function isTodayMyBirthday() {
  if (`${new Date().getDate()} ${new Date().getMonth()}` == "29 09") {
    return true; //mi prendo il mese ed il giorno corrente e li metto in una stringa, usando l'operatore di paragone verifico se sie uguale al compleanno, in tal caso imposto il ritorno a true altrimenti lo imposto a false
  } else {
    return false;
  }
}
//console.log(isTodayMyBirthday());

// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/

let epicode = {
  //creo l'oggetto e poi tramite delete con il parametro passato in funzione rimuovo la proprietà
  corsi: 2,
  alunni: 60,
};
function deleteProp(ogg = {}, str) {
  delete ogg[str];
  return ogg;
}
//console.log(deleteProp(epicode, 'corsi'));
/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/

function newestMovie() {
  //metto il primo film della lista in una variabile in modo che dopo essermi ciclato tutti i film se l'anno del film preso in quel momento dal ciclo è superiore si sovrascrive la variabile con il film più recente
  let film = movies[0];
  for (let i = 0; i < movies.length; i++) {
    {
      if (movies[i].Year > film.Year) {
        film = movies[i];
      }
    }
  }
  return film;
}

//console.log(newestMovie());

/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/

function countMovies() {
  //con length ottengo il numero di film nell'array
  return movies.length;
}
//console.log(countMovies());

/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/

function onlyTheYears(item) {
  //imposto la funzione per accedere alla proprietà anni
  return [item.Year];
}
let anni = movies.map(onlyTheYears); //con map mi creo il nuvo array richiamando la funzione impostata prima
//console.log(anni);

/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/

function onlyInLastMillennium() {
  //creo l'array vuoto e poi mi ciclo tutti i film, uso l'if per verificarne l'anno e poi uso il push per metterli nell'array
  let vecchioMillennio = [];
  for (let i = 0; i < movies.length; i++) {
    if (movies[i].Year < 2000) {
      vecchioMillennio.push(movies[i]);
    }
  }
  return vecchioMillennio;
}
//console.log(onlyInLastMillennium());
/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/

function sumAllTheYears() {
  //mi ciclo tutti i film e mi vado a prendere gli anni usando il parse int perchè sono scritti sotto forma di stringa e li sommo tra loro nella variabile
  let somma = 0;
  for (let x of movies) {
    somma += parseInt(x.Year);
  }
  return somma;
}
//console.log(sumAllTheYears());
/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/

function searchByTitle(str) {
  //mi ciclo i film e poi uso il metodo to upper case in modo da rendere la stringa di parametro e i titoli maiuscoli così che non mi dia problemi con il match che verifica se sono uguali e poi uso il push per metterli nell'array
  let lista = [];
  for (let i = 0; i < movies.length; i++) {
    if (movies[i].Title.toUpperCase().match(str.toUpperCase())) {
      lista.push(movies[i]);
    }
  }
  return lista;
}
//console.log(searchByTitle('lord'));
/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/

function searchAndDivide(str) {
  let divisioneFilm = {
    match: [], //uso la stessa logica dell'esercizio precedente solo che in caso di ugugaglianza li metto nella lista match altrimenti in unmatch
    unmatch: [],
  };
  for (let i = 0; i < movies.length; i++) {
    if (movies[i].Title.toUpperCase().match(str.toUpperCase())) {
      divisioneFilm.match.push(movies[i]);
    } else {
      divisioneFilm.unmatch.push(movies[i]);
    }
  }
  return divisioneFilm;
}
//console.log(searchAndDivide('avengers'));

/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/

function removeIndex(number) {
  movies.splice(number, 1);
  return movies;
}
//console.log(removeIndex(3));
// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/

function container() {
  let elemento = document.getElementById("container");
}
//container();
/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/

function tag() {
  let elementi = document.getElementsByTagName("td");
}
//tag();
/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/

function stampaConsole() {
  let testi = document.querySelectorAll("td");
  //mi creo una variabile dove mi bersaglio tutti i td del DOM
  for (let i = 0; i < testi.length; i++) {
    console.log(testi[i].textContent);
  }
  //eseguo un ciclo for per stampare in console tutti i testi al loro interno
}
//stampaConsole();
/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/

function coloreLink() {
  let links = document.querySelectorAll("a");
  //mi creo una variabile dove mi bersaglio tutte i link all'interno del documento
  for (let i = 0; i < links.length; i++) {
    links[i].style.backgroundColor = "red";
  }
  //eseguo un ciclo for per attribuire ad ogni link un colore di background rosso
}
//coloreLink();
/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/

function nuovoElemento() {
  let nuovoElemento = document.createElement("li");
  // mi creo una variabile e gli do come valore un createElement per creare un elemento
  let lista = document.getElementById("myList");
  // mi creo una seconda variabile per bersagliare il contenitore dove mettere il nuovo elemento
  lista.append(nuovoElemento);
  // infine con il metodo append e metto il nuovo elemento al suo interno
}
//nuovoElemento();
/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/

function svuotaLista() {
  //creo la funzione e uso il get element by id in modo da bersagliare quel singolo elemento e poi dando un valore vuoto a innerHTML cancello quello che c'è all'interno del tag bersagliato
  document.getElementById("myList").innerHTML = "";
}
//svuotaLista();
/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/

function aggiungiClasse() {
  //creo la funzione e uso il get element by tag per bersagliare tutti gli elementi con quel tag, eseguo un ciclo for per attribbuire ad ognuno di essi la classe test
  let tag = document.getElementsByTagName("tr");
  for (let i = 0; i < tag.length; i++) {
    tag[i].classList.add("test");
  }
}
//aggiungiClasse();
// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/

/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/

/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/

function isItPrime(number) {
  //creo la funzione e gli attribuisco come parametro il numero da verificare
  for (let i = 2; i < number; i++) {
    //eseguo un ciclo for e lo faccio partire da 2 perchè è
    //il primo numero con cui provare a dividere il parametro in modo da verificare che sia un numero primo
    if (number % i != 0) {
      //uso un if così in caso il risultato del modulo sia diverso da zero mi ritorna in console true
      return true;
    } else {
      return false;
    }
  }
}
//console.log(isItPrime(4))
