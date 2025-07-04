package com.mycompany.analista;

import io.github.guisso.meleeinterface.Decision;
import io.github.guisso.meleeinterface.IPlayer;

public class Diplomata implements IPlayer {

    private int rodada;
    private int traicoesConsecutivasOponente;
    private int traicoesMutuasConsecutivas;
    private boolean oponenteEUmTraidor;
    private Decision minhaUltimaJogada;
    
    //reseta após trocar de adversario
    private void reset() {
        this.rodada = 0;
        this.traicoesConsecutivasOponente = 0;
        this.traicoesMutuasConsecutivas = 0;
        this.oponenteEUmTraidor = false;
        this.minhaUltimaJogada = Decision.NONE;
    }

    @Override
    public String getDeveloperName() {
        return "Felipe Madureira";
    }

    @Override
    public String getEngineName() {
        return "Diplomata Pacifista";
    }

    @Override
    public Decision makeMyMove(Decision jogadaAnteriorOponente) {
        //identifica a primeira rodada
        if(jogadaAnteriorOponente == Decision.NONE){
            reset();//reseta tudo para o proximo participante
            return Decision.COOPERATE;//começa sempre coperando
        }
        //verificar as ações do meu adversario
        if(jogadaAnteriorOponente == Decision.DEFECT){
            this.traicoesConsecutivasOponente++;
            
            if (this.minhaUltimaJogada == Decision.DEFECT){
                 this.traicoesMutuasConsecutivas++;
            }
            
        }else{ //se o adversario ajudou então eu reseto e volto a cooperar
            this.traicoesConsecutivasOponente = 0;
            this.traicoesMutuasConsecutivas = 0;
        }
        
        Decision minhaJogada;//variavel para guardar minha decisaõ antes de retornar
        
        //Lógica de Decisão
        //se houver muita traição então ele ira ser marcado como traidor
        if (!this.oponenteEUmTraidor && this.traicoesConsecutivasOponente >= 4) {
            this.oponenteEUmTraidor = true;
        }
        if (this.oponenteEUmTraidor){
            minhaJogada = Decision.DEFECT;
        //tentar reverter o ciclo de traição    
        }else if (this.traicoesMutuasConsecutivas > 10){
            this.traicoesMutuasConsecutivas = 0;
            minhaJogada = Decision.COOPERATE;
        //continua ajudando mesmo sendo traido a primeira vez   
        }else if (this.traicoesConsecutivasOponente == 1){
            minhaJogada = Decision.COOPERATE;
        //caso nada disso for satisfeito ele copia a jogada anterior do adversario    
        }else{
            minhaJogada = jogadaAnteriorOponente;
        }
        
        
        this.minhaUltimaJogada = minhaJogada;//guardar minha decisão antes de rotornar
        return minhaJogada;
  
    }
}