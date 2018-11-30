
export class Token {
token:string;
expiracao:number;
}


export class Role {
nome:string;
}

export class Utilizador {
nome:string;
login:string;
password:string;
role:Role;
identificador:string;
token:Token;
especializacao:string;
}
