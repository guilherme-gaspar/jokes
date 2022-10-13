# Jokes
Projeto que randomiza piadas do Chuck Norris, realizando chamadas a API https://api.chucknorris.io/ e convertendo a resposta da API para uma lista dentro do APP.

# Arquitetura
Foi dividido a aplicaçao em pacotes que nos possibilita trabalhar com features modules, a arquitetura geral do app segue os príncipios do Clean Architecture. Visando no futuro uma escalabilidade do projeto, e também uma modularização foi pensando justamente nessa questão de isolar a feature e trabalhar dentro dela com uma arquitetura que segue uma divisão por 3 principais camadas (Data, Domain e Presentation). 

![arch](https://user-images.githubusercontent.com/22418520/195513075-4d97d6c4-c5a4-4f96-b733-1bb7b1b23219.png)

# O que foi utilizado
- Conceitos de arquitetura/código limpo/padrões
* Clean Architecture
* MVVM
* SOLID
* Padrão repositório

- Android
* Componentes do Jetpack
* ViewModel
* Compose
* Coroutines
* Flow
* Retrofit

- Framework DI
* Koin

- Testes unitários
* MockK

- Testes instrumentados
* Espresso
