# javaBasicsConcepts

Um objeto é uma entidade com fronteira e identidade bem definidas que encapsulam o estado e comportamento. 


Um atributo representa as informações que o objeto pode ter. 



Pilares da Orientação a Objetos

Abstração
Encapsulamento
Modularização 
Hierarquia


![image](https://user-images.githubusercontent.com/93552647/149983187-328cd3b0-141f-485d-8f56-29671c225bb0.png)



![image](https://user-images.githubusercontent.com/93552647/149983410-2ffe36d0-0008-48df-863d-4ccd677e6693.png)


# SOLID AND GOOD PRACTICES 

##### 1.Tell don't ask 
##### =>Fail fast é forma de criar um if de forma mais direta evitando criar identações e else. assim validando logo a condição de direta.

### Principles
#### S ingle Responsibility Principle
Uma classe (ou módulo, função, etc) deve ter um e apenas um motivo para mudar.
SRP (Single Responsibility Principle)
#### O pen Closed Principle
Que cada classe deve conhecer e ser responsável por suas próprias regras de negócio;
Que o princípio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para a extensão, mas fechado para a modificação
Isso significa que devemos poder criar novas funcionalidades e estender o sistema sem precisar modificar muitas classes já existentes
Uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma espécie de refatoração.
#### L iskov Substitution Principle
Que o Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema
#### I nterface Segregation Principle
Uma classe não deve ser obrigada a implementar um método de determinada interface, se ele não será útil. Para isso, uma interface deverá ser extraída apenas com os métodos necessários.
#### D ependency Inversion Principle
-------------------------------------------------------------------------------
## Principios de OOP

### Coesão 
Classes não coesas tendem a crescer indefinitivamente, o que as tornam dificeis de manter.
Uma classe que executa bem a sua única tarefa, de forma concisa.
Classes coesas não devem ter várias responsabilidades.
### Encapsulamento
Classes não encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento.
 Getters e setters por si só não fornecem nenhum tipo de encapsulamento.
 Encapsulamento ajuda no uso correto dos objetos.
Getters e setters não são formas eficientes de aplicar encapsulamento
É interessante fornecer acesso apenas ao que é necessário em nossas classes
O encapsulamento torna o uso das nossas classes mais fácil e intuitivo

### Acoplamento
Classes acopladas causam fragilidade no Código da aplicação, o que difiulta sua manutenção.
Acoplamento é a dependência entre classes
Acoplamento nem sempre é ruim, e que é impossível criar um sistema sem nenhum acoplamento
Devemos controlar o nível de acoplamento na nossa aplicação




Que é mais interessante e mais seguro para o nosso código depender de interfaces (classes abstratas, assinaturas de métodos e interfaces em si) do que das implementações de uma classe;
Que as interfaces são menos propensas a sofrer mudanças enquanto implementações podem mudar a qualquer momento;
Que o Princípio de Inversão de Dependência (DIP) diz que implementações devem depender de abstrações e abstrações não devem depender de implementações;
Que as interfaces devem definir apenas os métodos que fazem sentido para seu contexto;
Que o Princípio de Segregação de Interfaces (ISP) diz que uma classe não deve ser obrigada a implementar um método que ela não precisa;
Os conceitos aprendidos formam o acrônimo SOLID
#### Single Responsibility Principle
#### Open Closed Principle
#### Liskov Substitution Principle
#### Interface Segregation Principle
#### Dependency Inversion Principle

## DESIGN PATTERNS

#### COMPORTAMENTAIS (mais usados)
###### 1.Strategy
Este padrão pode ser utilizado quando há diversos possíveis algoritmos para uma ação (como calcular imposto, por exemplo). Nele, nós separamos cada um dos possíveis algoritmos em classes separadas
###### 2.Chain of Responsiblity
###### 3.Template Method
###### 4. Template Method 
###### 5. State
###### 6. Command
###### 7. Observer
#### CRIACIONAIS

#### ESTRUTURAIS

