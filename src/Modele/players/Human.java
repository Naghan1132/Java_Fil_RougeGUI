package players;

import games.Game;
import java.util.*;


public class Human implements Player{ // Réalisé par GRIMAULT Nathan

  protected String name;
  protected java.util.Scanner scanner;

  public Human(String name,java.util.Scanner scanner){
    this.name=name;
    this.scanner=scanner;
  }

  public int chooseMove(Game jeu){
    System.out.println(jeu.situationToString());
    System.out.println(" ");
    System.out.println("Quel coup choisi tu ?");
    String coup=this.scanner.next();
    while(jeu.isValid(Integer.parseInt(coup))!=true){
      System.out.println("Le coup n'est pas valide, recommence");
      coup=this.scanner.next();
    }
    System.out.println("Vous avez choisis : "+jeu.moveToString(Integer.parseInt(coup)));
    return Integer.parseInt(coup);
  }

  public String toString(){
    return name;
  }

}
