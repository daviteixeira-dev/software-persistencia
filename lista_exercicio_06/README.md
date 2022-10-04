<h2>Lista de exercicios 06</h2>

<ul>
    <li>
        1. Crie e use uma fábrica de conexões nas questões seguintes.
    </li>
    <li>
        2. Crie uma aplicação que use um banco relacional contendo uma tabela de alunos, com suas respectivas classes Java. Cada aluno deve ter um id, cpf, matrícula, nome, email e telefone.
    </li>
    <li>
        3. Crie métodos para: (a) inserir aluno e também para (b) listar todos os alunos.
    </li>
    <li>
        4. A aplicação deve ter um menu para realizar as funcionalidades previstas nas questões anteriores (consultas e inserções).
    </li>
</ul>

<h3>Codigos para a criação da tabela e incerção de um valor</h3>

<ul>
    <li>
        create table alunos (id serial primary key, cpf varchar(14), matricula varchar(50), nome varchar(50), email varchar(50), telefone varchar(50));
    </li>
    <li>
        insert into alunos (cpf, matricula, nome, email, telefone) values ('07003190055', '322841', 'Davi', 'davi@gmail.com', '40028922');
    </li>
</ul>