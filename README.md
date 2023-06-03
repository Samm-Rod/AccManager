
# :computer:AccManager :moyai:

### :dart:Gerenciador de Contas<br>
Esse é um projeto pessoal onde posso inserir dados<br>
de uma conta contendo Email, Nome de Usuário, Senha e Serviço sendo<br>
salvos no banco de dados. Outras funcionalidade são de:
- Atualizar (UPDATE)
- Consultar (SELECT * FROM)
- Consultar apenas por Id (SELECT * FROM login WHERE idLogin = ?)
- Deletar por Id (DELETE FROM login WHERE idLogin = ?)<br>
### Sample UML System Diagram<br> 
![UML Diagram AccManager](https://github.com/Samm-Rod/AccManager/assets/86389730/ca3da36d-fb67-4b58-9378-3aeaff15a6cd)<br>
### As it was in the database : 
![ERR BDS Login](https://github.com/Samm-Rod/AccManager/assets/86389730/80bff6e0-99c4-4c5f-9cdd-659f868062f1)<br>
### Esse é o Script SQL para gerar o Banco de dados e a tabela: 
```sql
CREATE DATABASE managerpass;
CREATE TABLE login(
idLogin INT(11) NOT NULL AUTO_INCREMENT,
email VARCHAR(45) NOT NULL,
usuario VARCHAR(45) NOT NULL,
senha VARCHAR(45) NOT NULL,
servico VARCHAR(45) NOT NULL,
PRIMARY KEY(idLogin)
);
```

*<h1 align = "center">Autor: Samuel Rodrigues:fleur_de_lis:</h1>*


