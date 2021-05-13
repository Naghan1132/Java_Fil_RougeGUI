package games;

import java.util.*;
import players.Player;

public class Shifumi extends AbstractGame{ // Réalisé par GRIMAULT Nathan

  private String gameboard[];
  private Player[] wins_cpt;

  public Shifumi(Player joueur1,Player joueur2){ //J1 = gameboard[0] J2=gameboard[1], Best of 3
    super(joueur1,joueur2);
    this.gameboard = new String[2];
    this.wins_cpt = new Player[3];
  }

  @Override
  public void doExecute(int coup){
    if(joueur_courant==joueur1){
      if(coup==1){
        gameboard[0]="Rock";
      }
      else if(coup==2){
        gameboard[0]="Scissors";
      }
      else if(coup==3){
        gameboard[0]="Paper";
      }
    }
    else{
      if(coup==1){
        gameboard[1]="Rock";
      }
      else if(coup==2){
        gameboard[1]="Scissors";
      }
      else if(coup==3){
        gameboard[1]="Paper";
      }
    }
  }

  @Override
  public boolean isValid(int coup){
    if(coup==1 || coup==2 || coup==3){
      return true;
    }
    return false;
  }

  @Override
  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> liste = new ArrayList<>();
    liste.add(1);
    liste.add(2);
    liste.add(3);
    return liste;
  }

  public boolean wins(){
    int cpt=0;
    for(int i=0;i<gameboard.length;i++){
      if(gameboard[i]==null){
        cpt+=1;
      }
    }
    if(cpt==0){
      System.out.println(" ");
      if(gameboard[0]=="Rock" && gameboard[1]=="Rock"){
        System.out.println("!! NOUVELLE MANCHE !!");
        this.gameboard= new String[2]; //Egalite on fais rien a pars vider le gameboard
      }
      if(gameboard[0]=="Rock" && gameboard[1]=="Scissors"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur1;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
      if(gameboard[0]=="Rock" && gameboard[1]=="Paper"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur2;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
      if(gameboard[0]=="Scissors" && gameboard[1]=="Scissors"){
        System.out.println("!! NOUVELLE MANCHE !!");
        this.gameboard= new String[2];
      }
      if(gameboard[0]=="Scissors" && gameboard[1]=="Rock"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur2;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
      if(gameboard[0]=="Scissors" && gameboard[1]=="Paper"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur1;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
      if(gameboard[0]=="Paper" && gameboard[1]=="Paper"){
        System.out.println("!! NOUVELLE MANCHE !!");
        this.gameboard= new String[2];
      }
      if(gameboard[0]=="Paper" && gameboard[1]=="Rock"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur1;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
      if(gameboard[0]=="Paper" && gameboard[1]=="Scissors"){
        for(int i=0;i<wins_cpt.length;i++){
          if(wins_cpt[i]==null){
            wins_cpt[i]=joueur2;
            System.out.println("!! NOUVELLE MANCHE !!");
            this.gameboard= new String[2];
            break;
          }
        }
      }
    }
    return false;
  }

  @Override
  public Player getWinner(){
    int j1=0;
    int j2=0;
    for(int i=0;i<wins_cpt.length;i++){
      if(wins_cpt[i]==joueur1){
        j1+=1;
      }
      else if(wins_cpt[i]==joueur2){
        j2+=1;
      }
    }
    if(j1>j2){
      return joueur1;
    }
    else if(j2>j1){
      return joueur2;
    }
    return null;
  }

  @Override
  public boolean isOver(){
    wins();
    int cpt=0;
    for(int i=0;i<wins_cpt.length;i++){
      if(wins_cpt[i]==null){
        cpt+=1;
      }
    }
    if(cpt==0){
      System.out.println(" ");
      System.out.println("Historique des victoires : "+wins_cpt[0] );
      for(int i=1;i<wins_cpt.length;i++){
        System.out.println("                           "+wins_cpt[i]);
      }
      return true;
    }
    return false;
  }

  @Override
  public String moveToString(int coup){
    String chaineMS=" ";
    if(coup==1){
      chaineMS+="1 : Rock";
    }
    else if(coup==2){
      chaineMS+="2 : Scissors";
    }
    else if(coup==3){
      chaineMS+="3 : Paper";
    }
    return chaineMS;
  }

  @Override
  public String situationToString(){
    System.out.println("1 : Rock");
    System.out.println("2 : Scissors");
    System.out.println("3 : Paper");
    for(int i=0;i<wins_cpt.length;i++){
      if(wins_cpt[i]!=null){
      }
      else{
        if(joueur_courant==joueur1){ //on affiche les coups avant/après que tout le monde a jouer
          System.out.println(" ");
          String truc="Plateau de jeu   J1 : "+gameboard[0]+" J2 : "+gameboard[1];
          System.out.println(" ");
          return truc;
        }
      }
    }
    String rien = " ";
    return rien;
  }

  @Override
  public Game copy(){
    Shifumi res = new Shifumi(this.joueur1,this.joueur2);
    res.joueur_courant = super.joueur_courant;
    res.gameboard = new String[2];
    for(int i=0 ; i<gameboard.length ; i++){
      res.gameboard[i] = gameboard[i];
    }
    return res;
  }

}
