package players;

import games.Game;
import java.util.*;

public class NegamaxPlayer implements Player{ // Réalisé par GRIMAULT Nathan

  public NegamaxPlayer(){
    //ne fais rien
  }

  public int evaluate(Game jeu){ //= algo n°2
    if(jeu.getWinner()==jeu.getCurrentPlayer()){ //WIN
      return +1;
    }
    else if(jeu.getWinner()!=jeu.getCurrentPlayer() && jeu.getWinner()!=null){ //LOOSE
      return -1;
    }
    else if(jeu.getWinner()==null && jeu.isOver()==true){ //EGALITE
      return 0;
    }
    else{ //S n'est pas terminale
    Integer res=null;
    for(int coup : jeu.validMoves()){
      Game s2 = jeu.copy();
      s2.execute(coup);
      Integer v=-evaluate(s2);
      if(res==null || v>res){
        res=v;
      }
    }
    return res;
    }
  }

  public int chooseMove(Game jeu){ //= algo n°1
    Integer meilleureValeur = null;
    Integer meilleurCoup = null;
    for(int coup : jeu.validMoves()){
      Game s2 = jeu.copy();
      s2.execute(coup);
      Integer v = -evaluate(s2);
      if(meilleureValeur==null || v>meilleureValeur){
        meilleureValeur = v;
        meilleurCoup = coup;
      }
    }
    System.out.println("L'IA à choisi le coup : "+jeu.moveToString(meilleurCoup));
    return meilleurCoup;
  }
}
