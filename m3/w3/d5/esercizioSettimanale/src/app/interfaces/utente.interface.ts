export interface Utente {
    email: string,
    nome: string,
    id: number,
}

export interface UtenteLoggato {
    accessToken: string,
	user:{
        email: string,
        nome: string,
        id: number
    }
}
