package com.mycompany.analista;

import java.util.ArrayList;
import java.util.List;
import io.github.guisso.meleeinterface.Decision;
import io.github.guisso.meleeinterface.IPlayer;

public class Analista implements IPlayer {
    
    private int round;
    private List<Decision> historicoOponente;
    private TipoOponente tipoIdentificado;

    
    private enum TipoOponente{
        DESCONHECIDO,
        SEMPRE_COOPERA, //cordeirinho
        SEMPRE_TRAI, //selvagem,viking
        COPIADOR, //mesma jogadas
        ADAPTADOR //mesma estrategia 
    }
    
    public void AnalistaPlayer(){
        reset();
    }
    
    private void reset(){
        this.round = 0;
        this.historicoOponente = new ArrayList<>();
        this.tipoIdentificado = TipoOponente.DESCONHECIDO;
    }
    
    @Override
    public String getDeveloperName(){
        return "Felipe Madureira";
    }
    
    @Override
    public String getEngineName(){
        return "Analista";
    }
    
    @Override
    public Decision makeMyMove(Decision opponentPreviousMove) {
        if(opponentPreviousMove == Decision.NONE){
            reset();
        }else{
            //vai guardar as jogadas anteriores dos oponente
            this.round++;
            this.historicoOponente.add(opponentPreviousMove);
        }
        
        //analisar as primeiras jogadas, irei usar como base a analise das
        //primeiras 3 jogadas
        
        if(this.round <3){
            return Decision.COOPERATE;
        }
        
        if(this.tipoIdentificado == TipoOponente.DESCONHECIDO){
            identificarOponente();
        }
        
        switch(this.tipoIdentificado){
            case SEMPRE_COOPERA:
                return Decision.DEFECT;
            case SEMPRE_TRAI:
                return Decision.DEFECT;
            
            case COPIADOR:
            case ADAPTADOR:
            case DESCONHECIDO:
            
            default:
                if(opponentPreviousMove == Decision.DEFECT){
                    return Decision.DEFECT;
                }
            return Decision.COOPERATE;
        }
    }
    
    private void identificarOponente(){
        boolean sempreCoopera = true;
        boolean sempreTrai = true;
        
        for(Decision jogada: this.historicoOponente){
            if(jogada != Decision.COOPERATE){
                sempreCoopera = false;
            }
            
            if(jogada != Decision.DEFECT){
                sempreTrai = false;
            }
        }
        
        if(sempreCoopera){
            this.tipoIdentificado = TipoOponente.SEMPRE_COOPERA;
        }else if(sempreTrai){
            this.tipoIdentificado = TipoOponente.SEMPRE_TRAI;
        }
        
    }
}