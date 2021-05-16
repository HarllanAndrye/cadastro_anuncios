# Cadastro de Anúncios

![JavaScript](https://img.shields.io/badge/-JavaScript-333333?style=flat&logo=javascript)
![Angular](https://img.shields.io/badge/-Angular-333333?style=flat&logo=angular&logoColor=E23237)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-333333?style=flat&logo=bootstrap&logoColor=563D7C)
![TypeScript](https://img.shields.io/badge/-TypeScript-333333?style=flat&logo=typescript)
![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/-Spring_Boot-333333?style=flat&logo=spring)
![Apache Maven](https://img.shields.io/badge/-Apache_Maven-333333?style=flat&logo=apache-maven&logoColor=C71A36)
![Swagger](https://img.shields.io/badge/-Swagger-333333?style=flat&logo=swagger)


**O problema**

A agência **Divulga Tudo** precisa de um programa para gerenciar os seus anúncios online. O objetivo dos anúncios faz parte de uma campanha nas redes sociais. O sistema de gerenciamento permitirá a gestão do anúncio e o rastreio dos resultados da campanha.

**Este programa será composto de duas partes:**

- 1ª Parte - Uma calculadora de alcance de anúncio online.
- 2ª Parte - Um sistema de cadastro de anúncios.

**1ª Parte - Considere os seguintes critérios fictícios para desenvolver a calculadora de alcance de anúncio:**

Baseados em dados de análise de anúncios anteriores, a agência tem os seguintes dados:
- a cada 100 pessoas que visualizam o anúncio 12 clicam nele.
- a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
- cada compartilhamento nas redes sociais gera 40 novas visualizações.
- 30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
- o mesmo anúncio é compartilhado no máximo 4 vezes em sequência

> (1ª pessoa -> compartilha -> 2ª pessoa -> compartilha - > 3ª pessoa -> compartilha -> 4ª pessoa)

Crie um script em sua linguagem de programação preferida que receba o valor investido em reais e retorne uma projeção aproximada da quantidade máxima de pessoas que visualizarão o mesmo anúncio (`considerando o anúncio original + os compartilhamentos`).

**2ª Parte - Considere os seguintes critérios fictícios para desenvolver o cadastro de anúncios:**
 

Crie um sistema que permita o cadastro de anúncios. O anúncio deverá conter os seguintes dados:
- nome do anúncio
- cliente
- data de início
- data de término
- investimento por dia

O sistema fornecerá os relatórios de cada anúncio contendo:
- valor total investido
- quantidade máxima de visualizações
- quantidade máxima de cliques
- quantidade máxima de compartilhamentos

Os relatórios poderão ser filtrados por intervalo de tempo e cliente.

## Aplicação

A aplicação está dividida em duas partes: front-end e back-end.

Front-end (:file_folder: anuncios-frontend): Onde o usuário irá acessar para cadastrar os anúncios e ver o relatório referentes aos mesmos.

Back-end (:file_folder: anuncios): API REST que faz a comunicação com o front-end e persiste os dados no BD.


> **Obs.**: Os procedimentos de como compilar e executar a aplicação estão descritos em cada diretório (anuncios e anuncios-frontend).
