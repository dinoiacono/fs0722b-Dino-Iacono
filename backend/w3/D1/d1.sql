CREATE TABLE IF NOT EXISTS Clienti (
	NumeroCliente SERIAL,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita INT8 NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Fatture (
	NumeroFattura SERIAL,
	Tipologia VARCHAR NOT NULL,
	Importo INT8 NOT NULL,
	Iva INT8 NOT NULL,
	IdCliente INT8 NOT NULL,
	DataFattura INT8 Not null,
	NumeroFornitore int8 not null
);

CREATE TABLE IF NOT EXISTS Prodotti (
	IdProdotto SERIAL,
	Descrizione varchar not null,
	InProduzione boolean not null,
	InCommercio boolean not null,
	DataAttivazione int8 not null,
	DataDisattivazione int8 not null
);

CREATE TABLE IF NOT EXISTS Fornitori (
	NumeroFornitore SERIAL,
	Denominazione varchar not null,
	RegioneResidenza varchar not null
);


SELECT Nome, Cognome FROM Clienti WHERE DataNascita=1982;
SELECT max(id) FROM Fatture where Iva=20;
