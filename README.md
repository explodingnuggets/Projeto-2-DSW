# Projeto 2 para disciplina de Desenvolvimento de Software para Web

## Instruções

- Clone o repositorio
- Configurare o Tomcat
- Rode usando Netbeans
- Crie um usuario qualquer (podendo ser admin ou não)
- Abra perfil para criar teatro e site (usuarios normais podem criar apenas para si mesmos, já admins podem criar para qualquer pessoa)

## Descrição

Sistema para criação de promoções em sites de venda de ingressos

O sistema deve possuir um cadastro de sites de venda de ingressos, com os
seguintes dados: e-mail, senha, endereço/URL, nome e telefone.

O sistema deve possuir um cadastro de salas de teatro, com os seguintes dados:
e-mail, senha, CNPJ, nome e cidade.

O sistema deve possuir um cadastro de promoções, com os seguintes dados:
endereço/URL do site de venda de ingressos, CNPJ do teatro, nome da peça,
preço e dia/horário.

## Funcionalidades necessárias
- [X]  Operações CRUD 1 de sites de venda de ingressos (requer login de
administrador)
- [X] Operações CRUD de teatros (requer login de administrador)
- [X] Listagem de todos os teatros em uma única página (não requer login)
- [X] Listagem de todos os teatros por cidade (não requer login)
- [X] Criação de uma promoção de um teatro (requer login do teatro: via e-
mail + senha). Depois de fazer login, o teatro pode cadastrar uma
promoção. Para isso, deve escolher o site de venda de ingressos
(digitando seu endereço/URL ou escolhendo a partir de uma lista), o nome
da peça, o preço, e o dia/horário da sessão, e deve ser gravada a
promoção na base de dados.
- [X] Listagem de todas as promoções de um teatro (não requer login).
- [X] Listagem de todas as promoções de um site de venda de ingressos
(requer login do site: via e-mail + senha).
- [X] O sistema não deve permitir o cadastro de promoções de um mesmo
teatro ou de um mesmo site de venda de ingressos em um mesmo
dia/horário.
- [X] O sistema deve ser internacionalizado em pelo menos dois idiomas:
português + outro de sua escolha.
