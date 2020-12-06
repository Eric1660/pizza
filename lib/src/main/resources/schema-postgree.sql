CREATE TABLE IF NOT EXIST pizza {
	 id food PRIMARY KEY,
     sabor varchar(50),
     preco numeric CHECK(preco > 0),
     descricao varchar(255),
     

};

CREATE TABLE IF NOT EXIST cliente {
	 id fregues PRIMARY KEY,
     nome varchar(50),
     email varchar(50),
     endereco varchar(50),

};


CREATE TABLE IF NOT EXIST pedido {
	 id serial PRIMARY KEY,
     sabor varchar(50) REFERENCES pizza(sabor),
     nome varchar(50) REFERENCES cliente(nome),


};

