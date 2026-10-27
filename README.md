# Padrão Strategy

Projeto desenvolvido para demonstrar a utilização do padrão de projeto **Strategy** em Java.

## 📌 Sobre o projeto

O projeto simula um navegador que escolhe uma rota entre opções já cadastradas. Cada rota possui nome, distância, tempo e custo estimados. O critério de escolha pode ser alterado durante a execução:

- **Rota mais curta:** menor distância.
- **Rota mais rápida:** menor tempo.
- **Rota mais econômica:** menor custo.

Os dados são fictícios e simplificados para fins didáticos. Em caso de empate, a primeira rota encontrada é escolhida.

## 🧩 Padrão Strategy

O **Strategy** é um padrão comportamental que define uma família de algoritmos, encapsula cada um deles e permite trocá-los conforme a necessidade.

Neste projeto, a interface `EstrategiaRota` define o método `escolher()`. As classes `RotaMaisCurta`, `RotaMaisRapida` e `RotaMaisEconomica` implementam formas diferentes de selecionar uma rota.

A classe `Navegador` mantém uma referência à estratégia e delega a escolha a ela. A estratégia pode ser substituída sem criar outro navegador:

```java
Navegador navegador = new Navegador(new RotaMaisCurta());
Rota primeira = navegador.calcularRota(rotas);

navegador.setEstrategia(new RotaMaisRapida());
Rota segunda = navegador.calcularRota(rotas);
```

## 📁 Estrutura do projeto

```
Strategy_Rotas/
├── src/
│   ├── main/java/strategy/
│   │   ├── Aplicacao.java
│   │   ├── EstrategiaRota.java
│   │   ├── Navegador.java
│   │   ├── Rota.java
│   │   ├── RotaMaisCurta.java
│   │   ├── RotaMaisRapida.java
│   │   └── RotaMaisEconomica.java
│   └── test/java/strategy/
│       └── NavegadorTest.java
├── diagrama-classes.png
├── pom.xml
└── README.md
```

## ⚙️ Funcionamento

A classe `Rota` armazena as informações usadas na comparação. A classe `Aplicacao` cria três opções e troca a estratégia do navegador para demonstrar cada critério:

| Estratégia | Critério | Rota escolhida no exemplo |
| --- | --- | --- |
| `RotaMaisCurta` | Menor distância | Centro |
| `RotaMaisRapida` | Menor tempo | Rodovia |
| `RotaMaisEconomica` | Menor custo | Bairro |

### Validação dos dados

A rota exige nome preenchido, distância e custo finitos e não negativos, além de tempo não negativo. O navegador exige uma lista não vazia, sem elementos nulos. Nessas situações inválidas, é lançada uma `IllegalArgumentException`. Uma estratégia nula provoca `NullPointerException`.

## ▶️ Executando a aplicação

Com o **JDK 11 ou superior** e o **Maven** instalados, execute na pasta que contém o `pom.xml`:

```bash
mvn compile
java -cp target/classes strategy.Aplicacao
```

A saída esperada é:

```text
Mais curta: Centro
Mais rápida: Rodovia
Mais econômica: Bairro
```

## 🏗️ Estrutura do Strategy

| Elemento do padrão | Implementação |
| --- | --- |
| Strategy — interface dos algoritmos | `EstrategiaRota` |
| Concrete Strategy — menor distância | `RotaMaisCurta` |
| Concrete Strategy — menor tempo | `RotaMaisRapida` |
| Concrete Strategy — menor custo | `RotaMaisEconomica` |
| Context — utiliza a estratégia | `Navegador` |
| Dados avaliados | `Rota` |
| Cliente — demonstração | `Aplicacao` |

## 🧪 Testes

O projeto utiliza **JUnit 5**. A classe `NavegadorTest` verifica a escolha por cada critério, a troca de estratégia e a rejeição de dados inválidos.

Para executar os testes:

```bash
mvn test
```

## 📊 Diagrama de classes

O arquivo [diagrama-classes.png](diagrama-classes.png) apresenta as principais classes, a interface e as relações entre elas.

## 🛠️ Tecnologias utilizadas

- Java 11
- Maven
- JUnit 5.5.2
- Padrão de Projeto Strategy

## 🎯 Objetivo

Demonstrar como diferentes algoritmos podem ser encapsulados em classes independentes e escolhidos em tempo de execução. Novos critérios podem ser criados implementando `EstrategiaRota`.

## 👨‍💻 Autor

**Felipe Baba**

Projeto desenvolvido para fins acadêmicos, como aplicação prática do padrão de projeto Strategy.
