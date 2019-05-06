# Projeto 2 para disciplina de Desenvolvimento de Software para Web

## Instruções

- Clonar o repositorio
- Configurar o Tomcat
- Rodar usando Netbeans
- Utilizar o usuario `teste@teste.com` e senha `testeteste` para logar(ou crie
um novo)

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
- [ ]  Operações CRUD 1 de sites de venda de ingressos (requer login de
administrador)
- [ ] Operações CRUD de teatros (requer login de administrador)
- [ ] Listagem de todos os teatros em uma única página (não requer login)
- [ ] Listagem de todos os teatros por cidade (não requer login)
- [ ] Criação de uma promoção de um teatro (requer login do teatro: via e-
mail + senha). Depois de fazer login, o teatro pode cadastrar uma
promoção. Para isso, deve escolher o site de venda de ingressos
(digitando seu endereço/URL ou escolhendo a partir de uma lista), o nome
da peça, o preço, e o dia/horário da sessão, e deve ser gravada a
promoção na base de dados.
- [ ] Listagem de todas as promoções de um teatro (não requer login).
- [ ] Listagem de todas as promoções de um site de venda de ingressos
(requer login do site: via e-mail + senha).
- [ ] O sistema não deve permitir o cadastro de promoções de um mesmo
teatro ou de um mesmo site de venda de ingressos em um mesmo
dia/horário.
- [ ] O sistema deve ser internacionalizado em pelo menos dois idiomas:
português + outro de sua escolha.
