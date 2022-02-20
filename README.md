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
#### O pen Closed Principle
#### L iskov Substitution Principle
#### I nterface Segregation Principle
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
