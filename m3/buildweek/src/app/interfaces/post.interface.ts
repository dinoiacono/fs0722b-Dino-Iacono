export interface Post {
  title: string,
  body: string,
  imgUrl: string,
  id: number,
  userId: number
}

export interface ModificaPost{
  id: number,
  title: string,
  body: string
}

export interface NuovoPost{
  title: string,
  body: string,
  imgUrl: string,
  userId: number
}
