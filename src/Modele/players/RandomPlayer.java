package players;

import games.Game;
import java.util.*;


public class RandomPlayer implements Player{ // Réalisé par GRIMAULT Nathan

  protected java.util.Random rand;

  public RandomPlayer(java.util.Random rand){
    this.rand=rand;
  }

  public int chooseMove(Game jeu){
    int taille = jeu.validMoves().size(); //on prends la taille totale
    int indice_rand = this.rand.nextInt(taille); //on tire un indice aléatoire
    int coup = jeu.validMoves().get(indice_rand); //on récupére le coup situé a cet indice
    System.out.println("Le robot à jouer le coup : "+jeu.moveToString(coup));
    return coup;
  }

  public String toString(){
    String chaine = ("Joueur aléatoire n° " + this.hashCode());
    return chaine;
  }
}
