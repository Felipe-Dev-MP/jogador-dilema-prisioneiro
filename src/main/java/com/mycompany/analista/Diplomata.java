package com.mycompany.analista;

import io.github.guisso.meleeinterface.Decision;
import io.github.guisso.meleeinterface.IPlayer;

public class Diplomata implements IPlayer {

    private int rodada;
    private int traicoesConsecutivasOponente;
    private int traicoesMutuasConsecutivas;
    private boolean oponenteEUmTraidor;

    private void reset() {
        this.rodada = 0;
        this.traicoesConsecutivasOponente = 0;
        this.traicoesMutuasConsecutivas = 0;
        this.oponenteEUmTraidor = false;
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
        this.rodada++;
        if(jogadaAnteriorOponente == Decision.NONE){
            reset();
            return Decision.COOPERATE;
        }

        if(jogadaAnteriorOponente == Decision.DEFECT){
            this.traicoesConsecutivasOponente++;
            
            if (this.traicoesMutuasConsecutivas >= 0){
                 this.traicoesMutuasConsecutivas++;
            }
            
        }else{
            this.traicoesConsecutivasOponente = 0;
            this.traicoesMutuasConsecutivas = 0;
        }
        
        //Lógica de Decisão
        if(!this.oponenteEUmTraidor && this.traicoesConsecutivasOponente >= 4){
            this.oponenteEUmTraidor = true;
        }
        
        if(this.oponenteEUmTraidor){
            return Decision.DEFECT;
        }

        //NOVA REGRA: Oferta de Paz
        if(this.traicoesMutuasConsecutivas > 10){
            this.traicoesMutuasConsecutivas = 0;
            return Decision.COOPERATE;
        }

        if(this.traicoesConsecutivasOponente == 1){
            return Decision.COOPERATE; 
        }

        return jogadaAnteriorOponente;
    }
}