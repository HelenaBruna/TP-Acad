Create schema alunoAcademia;
use alunoAcademia;

Create table alunoAcademia
(
	Id int  NOT NULL AUTO_INCREMENT,
    Nome varchar(255),
    Idade int,
    Peso float,
    Altura float,
    Objetivo text,
    constraint fk_alunoAcademia primary key (Id)
);
