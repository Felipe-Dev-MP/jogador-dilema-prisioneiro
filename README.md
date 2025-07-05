# Projeto Jogador: Dilema do Prisioneiro

## Sobre o Projeto

Este repositório contém o código-fonte do meu competidor para o torneio do Dilema do Prisioneiro, desenvolvido para a disciplina de Programação Orientada a Objetos. O objetivo foi criar um agente inteligente capaz de maximizar sua pontuação em um ecossistema com diversas estratégias, aplicando conceitos de Teoria dos Jogos.

---

## O Competidor: "Democrata Pacifista"

O "Democrata Pacifista" é a versão final e otimizada do meu jogador, projetado para vencer em um torneio de longo prazo, priorizando a construção de confiança e a cooperação mútua.

### Filosofia Geral

A filosofia do jogador é que a pontuação mais alta e sustentável não vem da exploração de curto prazo, mas sim de parcerias estáveis e confiáveis. Ele se comporta como um "cidadão modelo" no ecossistema do torneio: é fundamentalmente bom e pacífico, mas não é ingênuo. Sua maior força é a capacidade de perdoar e até de tentar ativamente reconciliar um conflito, transformando adversários em parceiros.

### A Lógica da Estratégia

O cérebro do "Democrata Pacifista" opera com base em um conjunto de princípios, em ordem de prioridade:

1.  **Princípio da Confiança (Nunca Atacar Primeiro)**
    * Em qualquer novo confronto, o jogador sempre começa cooperando. Ele oferece um "aperto de mão", sinalizando sua intenção de formar uma parceria.

2.  **Princípio da Autodefesa**
    * Embora seja pacífico, ele não é um alvo fácil. Se um oponente trair 4 vezes consecutivas, o jogador o classifica como um agressor implacável ("Selvagem"). A partir desse ponto, ele passa a trair sempre contra esse oponente específico, apenas para minimizar as perdas.

3.  **Princípio da Esperança**
    * Esta é sua habilidade mais sofisticada. Se o jogador se encontrar preso em um ciclo de traições mútuas por mais de 10 rodadas, ele proativamente arrisca cooperar uma única vez. Essa "oferta de paz" serve para quebrar o ciclo de vingança e tentar restaurar uma parceria lucrativa.

4.  **Princípio do Perdão**
    * Para evitar espirais de vingança causadas por mal-entendidos ou traições esporádicas, o jogador sempre perdoa a primeira traição de um oponente. Ele só retalia se for traído duas vezes seguidas.

5.  **Comportamento Padrão**
    * Se nenhuma das regras especiais acima for acionada, o jogador se comporta como um "Copiador" clássico, simplesmente devolvendo a última jogada do oponente.

---

## Evolução da Estratégia

O desenvolvimento foi um processo iterativo:

1.  **Versão 1 - "O Analista":** Uma estratégia inicial, puramente predatória, que se provou ineficaz em um ambiente com jogadores inteligentes, pois sua ganância destruía parcerias.
2.  **Versão 2 - "O Diplomata":** Uma evolução que priorizava a cooperação e o perdão, mostrando resultados drasticamente melhores.
3.  **Versão Final - "Democrata Pacifista":** A versão atual, que adicionou a lógica da "Esperança" (oferta de paz), provando ser a estratégia campeã nos testes simulados.

---
### Visual do Personagem: O Democrata Pacifista

![Visual do Democrata Pacifista](src/main/resources/Democrata.png)
