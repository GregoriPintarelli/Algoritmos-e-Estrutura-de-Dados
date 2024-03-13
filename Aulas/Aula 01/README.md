## O que é estrutura de dados?

Uma estrutura de dados são jeitos diferentes de armazenar dados, tendo os seus próprios jeitos de editar e buscar os dados. Diferentes estruturas de dados podem ser aplicados para solucionar diferentes problemas do melhor jeito possivel.
***
## Qual a importância de estrutura de dados?

Com as estruturas de dados, conseguimos guardar e resgatar dados, e, dependendo da estrutura de dados selecionada, conseguimos fazer isso do jeito mais eficiente possível para solucionar nosso problema.
***
## Explicação e exemplos das estruturas de dados de:

### Array:

Guarda dados baseado em um índice, podendo se atribuir ou buscar um valor a um índice especificando o Array e o índice

#### Estático:

Possui um tamanho fixo, definido na hora que criamos o Array  
Ex:  
int[] numeros = int[10] // Array que contem 10 espaços, de 0 a 9, para ints  
numero[9] = 20 // Último espaço definido como tendo o valor 20

#### Dinâmico (Vector):

Possui um tamanho que aumenta automaticamente com a adição de elementos
Ex:  
int n = 10 // int com valor 10  
List<Integer> numeros // Vector criado como Lista, mas não inicializado  
numeros = new Vector<Integer>(n) // Array dinâmico Vector inicializado com n espaços, de 0 a 9, para Integers  
numero.add(0, 20) // Primeiro espaço definido como tendo o valor 20

### Lista:

Guarda dados baseado em um índice, podendo se atribuir ou buscar um valor a um índice especificando a Lista e o índice  
Possui um tamanho que varia dependendo do número de elementos dentro  
Ex:  
List<Integer> numeros = new ArrayList<Integer>() // Cria uma Lista de Integers  
numeros.add(20) // Adiciona o valor 20 na primeira posição da Lista

### Fila:

Guarda dados em uma fila, onde o primeiro elemento que entra é o primeiro que sai (FIFO - First-In-First-Out)  
Tamanho variavel dependendo do número de elementos  
Não pode ter elementos duplicados  
Ex:  
Queue<Integer> numeros = new LinkedList<Integer>() // Cria uma Fila de Integers  
numeros.add(20) // Adiciona o valor 20 na primeira posição da Fila

### Pilha:

Guarda dados em uma pilha, onde o ultimo elemento que entra é o primeiro que sai (LIFO - Last-In-First-Out)  
Tamanho variavel dependendo do número de elementos  
Pode ter elementos duplicados  
Ex:  
Stack<Integer> numeros = new Stack<Integer>() // Cria uma Pilha de Integers  
numeros.push(20) // Adiciona o valor 20 em cima da Pilha
***