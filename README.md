# Trie Patricia Tree

Implementação em Java de uma árvore **Patricia** (Practical Algorithm to Retrieve Information Coded in Alphanumeric), também conhecida como **Trie Comprimida**.

## Sobre o Projeto

Este projeto implementa uma estrutura de dados Patricia Tree, que é uma variação otimizada da estrutura Trie tradicional. A principal diferença é que a Patricia Tree comprime caminhos com apenas um filho, reduzindo o espaço de armazenamento e melhorando a eficiência em algumas operações.

### O que é uma Patricia Tree?

Uma Patricia Tree (ou Radix Tree) é uma árvore de busca comprimida que armazena strings de forma eficiente. Ao contrário de uma Trie tradicional onde cada nó armazena um único caractere, a Patricia Tree pode armazenar sequências de caracteres (prefixos) em cada nó, comprimindo os caminhos quando há apenas um filho.

## Estrutura do Projeto

```
src/main/java/com/fipp/
├── Tree.java        # Classe principal da árvore Patricia
├── NoTree.java      # Nó da árvore
├── Fila.java        # Implementação de fila para BFS
└── NoFila.java      # Nó da fila
```

## Funcionalidades

### Classe `Tree`

- **`inserir(String palavra)`**: Insere uma palavra na árvore Patricia
  - Comprime automaticamente os caminhos comuns
  - Ignora diferenças entre maiúsculas e minúsculas
  - Suporta apenas letras (a-z)

- **`exibirEmNivel()`**: Exibe a estrutura da árvore em níveis
  - Utiliza algoritmo BFS (Busca em Largura)
  - Mostra a hierarquia com indentação
  - Marca com `[x]` os nós que representam fim de palavra

- **`imprimir()`**: Lista todas as palavras armazenadas na árvore
  - Percorre a árvore e reconstrói as palavras completas
  - Exibe apenas palavras marcadas como completas

### Classe `NoTree`

Representa um nó da árvore com os seguintes atributos:

- **`palavra`**: Sequência de caracteres armazenada no nó
- **`Vlig[]`**: Array de 26 posições para os filhos (uma para cada letra)
- **`flag`**: Indica se o nó representa o final de uma palavra válida

## Como Executar

### Pré-requisitos

- Java 24 ou superior
- Maven 3.x

### Compilação e Execução

```bash
# Compilar o projeto
mvn clean compile

# Executar o programa principal
mvn exec:java -Dexec.mainClass="com.fipp.Tree"
```

Ou diretamente com Java:

```bash
# Compilar
javac -d target/classes src/main/java/com/fipp/*.java

# Executar
java -cp target/classes com.fipp.Tree
```

## Exemplo de Uso

```java
Tree tree = new Tree();

// Inserir palavras
tree.inserir("amarelo");
tree.inserir("amar");
tree.inserir("ama");
tree.inserir("bear");
tree.inserir("bell");

// Exibir estrutura em níveis
System.out.println("Estrutura da árvore:");
tree.exibirEmNivel();

// Listar todas as palavras
System.out.println("\nPalavras armazenadas:");
tree.imprimir();
```

### Saída Esperada

A exibição em níveis mostra a estrutura comprimida da árvore:
```
1. am
  2. a[x]
    3. r[x]
      4. elo[x]
  2. igo[x]
  2. or[x]
1. be
  2. ar[x]
  2. ll[x]
```

A listagem de palavras reconstrói e exibe todas as palavras completas:
```
ama
amar
amarelo
amigo
amor
bear
bell
```

## Características da Implementação

- **Compressão de Prefixos**: Nós são comprimidos quando há apenas um caminho
- **Alfabeto**: Suporta apenas letras de 'a' a 'z' (26 caracteres)
- **Case Insensitive**: Todas as palavras são convertidas para minúsculas
- **Marcação de Palavras**: Flag booleana indica fim de palavra válida
- **Travessia em Níveis**: Implementação de BFS para exibição hierárquica

## Complexidade

- **Inserção**: O(m), onde m é o comprimento da palavra
- **Busca**: O(m), onde m é o comprimento da palavra
- **Espaço**: O(n), onde n é o número total de caracteres únicos armazenados (comprimido)

## Possíveis Melhorias

- [ ] Adicionar funcionalidade de busca
- [ ] Implementar remoção de palavras
- [ ] Adicionar suporte para autocompletar
- [ ] Implementar busca por prefixo
- [ ] Adicionar suporte para caracteres especiais e números
- [ ] Implementar serialização/desserialização da árvore
- [ ] Adicionar testes unitários

## Autor

Desenvolvido como projeto acadêmico para estudo de estruturas de dados avançadas.

## Licença

Este projeto é de uso educacional.
