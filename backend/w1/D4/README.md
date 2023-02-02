Esercizio #1
Scrivere la classe Dipendente che ha i seguenti attributi:

Attributi statici
- stipendioBase - numero decimale con stipendio base mensile prevalorizzato a 1000 accessibile a tutte le classi

- matricola - identificativo univoco del dipendente
- stipendio - numero decimale con stipendio base mensile calcolato per il dipendente
- importoOrarioStraordinario - numero decimale con importo per ogni ora di straordinario
- Livello - valori possibili [OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE]
- Dipartimento - Valori possibili [PRODUZIONE, AMMINISTRAZIONE, VENDITE]

Le proprietÃ  devono essere accessibili solo dalla classe Dipendente e deve essere possibile leggerle tramite opportuni metodi get ma non modificarle, tranne le proprietÃ  Dipartimento e importoOrarioStraordinario  che possono essere modificate da altre classi tramite un metodo di set.

Definire due costruttori: 
- uno che accetti solo la matricola e Dipartimento ed imposti i seguenti valori
	- stipendio = stipendioBase
	- importoOrarioStraordinario = 30
	- Livello = OPERAIO
- Uno che accetti tutti i parametri

Definire i seguenti metodi
- stampaDatiDipendente - Stampa i dati del dipendente
- promuovi - aggiorna il livello del dipendente con la seguente logica 
	se il Dipendente Ã¨ operaio lo promuove a impiegato
	se il Dipendente Ã¨ impiegato lo promuove a quadro
	se il Dipendente Ã¨ quadro lo promuove a dirigente
	se il Dipendente Ã¨ dirigente resta tale e scrive un messaggio di errore
  Il metodo aggiorna inoltre lo stipendio del dipendente con la seguente logica
	- IMPIEGATO = stipendioBase * 1,2
	- QUADRO = stipendioBase * 1,5
	- DIRIGENTE = stipendioBase * 2
 Infine il metodo ritorna il nuovo livello del dipendente

Definire i seguenti metodi statici:
- calcolaPaga - accetta un'istanza di dipendente e ne ritorna lo stipendio mensile
- calcolaPaga - accetta un'istanza di dipendente ed un parametro intero con le ore di straordinario e ritorna lo stipendio mensile comprensivo di straordinario