# Jokes
Projeto que randomiza piadas do Chuck Norris, realizando chamadas a API https://api.chucknorris.io/ e convertendo a resposta da API para uma lista dentro do APP.

# Demonstração
<img src="(https://user-images.githubusercontent.com/22418520/195515114-8be11f3d-b1e5-42dc-8c56-bf9bc22bc094.jpg)" alt="listagem" width="300"/>

# Arquitetura
Foi dividido a aplicaçao em pacotes que nos possibilita trabalhar com features modules, a arquitetura geral do app segue os príncipios do Clean Architecture. Visando no futuro uma escalabilidade do projeto, e também uma modularização foi pensando justamente nessa questão de isolar a feature e trabalhar dentro dela com uma arquitetura que segue uma divisão por 3 principais camadas (Data, Domain e Presentation). 

![arch](https://user-images.githubusercontent.com/22418520/195513075-4d97d6c4-c5a4-4f96-b733-1bb7b1b23219.png)

# O que foi utilizado
- Conceitos de arquitetura/código limpo/padrões
Clean Architecture
MVVM
SOLID
Padrão repositório

- Android
Componentes do Jetpack
ViewModel
Compose
Coroutines
Flow
Retrofit

- Framework DI
Koin

- Testes unitários
MockK
MockWebServer (okHttp)

- Testes instrumentados
Espresso

# Futuro
Como o aplicativo ainda pode ser melhorados, tem alguns pontos que podem e já foram analisados e pensados:
- Modularizar
- Nova feature de Favorito (Existe um TODO no código)
- Botão para chegar ao top da lista (Existe um TODO no código)
