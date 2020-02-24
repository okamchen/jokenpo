# Jokenpo - O Jogo

Jokenpo é uma brincadeira japonesa, onde dois jogadores escolhem um dentre três possíveis itens: Pedra, Papel ou Tesoura.

O objetivo é fazer um juiz de Jokenpo que dada a jogada dos dois jogadores informa o resultado da partida.

As regras são as seguintes: 

- Pedra empata com Pedra e ganha de Tesoura
- Tesoura empata com Tesoura e ganha de Papel
- Papel empata com Papel e ganha de Pedra

## A implementação

Tendo a premissa que o jogo permite apenas 3 tipos de jogadas, foi criado um enum representando cada tipo (`PEDRA`, `PAPEL`, `TESOURA`).
Após a definição de tipo, foi criada uma interface (`RegraJogada`), obrigando cada tipo a implementar a sua regra diante o valor de tipo recebido.
A ideia foi manter os tipos de jogadas bem definidos e claros, para caso algum dia surja um novo tipo no jogo(talvez `DIAMANTE` :p), o desenvolvedor em questão saiba que para esse tipo uma nova regra deverá ser implementada.
Da mesma forma, foi criada uma regra de exceção em cada tipo, para que caso surja um novo tipo, o teste de comparação com os demais tipos falhe pela sua falta de implementação.

o projeto ficou divido em pacotes, procurando manter a clareza em suas responsabilidades.


## Rodando o projeto

Após clonar o projeto, vá até a pasta raiz e execute os seguintes comandos:
```scrip
mvn install
```

```scrip
java -jar target/jokenpo-0.0.1-SNAPSHOT.jar ${valor1} ${valor2}
```

### Valores de entrada: 

- `PEDRA`
- `PAPEL`
- `TESOURA`

### Valor de saída: 

- Resultado descritivo apresentado em console.