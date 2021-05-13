package games;

import java.util.*;
import players.Player;

public class TicTacToe extends AbstractGame{

  private Player[][] gameboard;

  public TicTacToe(Player joueur1,Player joueur2){
    super(joueur1,joueur2);
    this.gameboard = new Player[3][3];
  }

  @Override
  public void doExecute(int coup){
    int cpt=0;
    for (int i=0;i<gameboard.length;i++){
      for (int j=0;j<gameboard[i].length;j++){
        if (cpt == coup){
          gameboard[i][j]=joueur_courant;
        }
        cpt+=1;
      }
    }
  }

  @Override
  public boolean isValid(int coup){
    int cpt=0;
    for (int i=0;i<gameboard.length;i++){
      for (int j=0;j<gameboard[i].length;j++){
        if (cpt==coup){
          if (gameboard[i][j]==null && coup>=0 && coup<=8){
            return true;
          }
          else{
            return false;
          }
        }
        cpt+=1;
      }
    }
    return false;
  }

  @Override
  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> liste = new ArrayList<>();
    int cpt=0;
    for (int i=0;i<gameboard.length;i++){
      for (int j=0;j<gameboard[i].length;j++){
        if (gameboard[i][j]==null){
          liste.add(cpt);
        }
        cpt+=1;
      }
    }
    return liste;
  }

  public boolean wins(Player joueur,int row, int column,int deltaRow,int deltaColumn){ //delta = -1 ou 0 ou +1
    if(gameboard[row][column]==joueur && gameboard[row+deltaRow][column+deltaColumn]==joueur && gameboard[row+2*deltaRow][column+2*deltaColumn]==joueur){
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public Player getWinner(){
    for (int i=0;i<gameboard.length;i++){
      if(wins(joueur1,i,0,0,1)==true || wins(joueur1,0,i,1,0)==true || wins(joueur1,0,0,1,1)==true || wins(joueur1,0,2,1,-1)==true){ //check de rangées, colonnes et diagonales
        return joueur1;
      }
      else if (wins(joueur2,i,0,0,1)==true || wins(joueur2,0,i,1,0)==true || wins(joueur2,0,0,1,1)==true || wins(joueur2,0,2,1,-1)==true){
        return joueur2;
      }
    }
    return null;// => personne à win pour l'instant ou égalité
  }

  @Override
  public boolean isOver(){
    int cpt=0;
    for(int i=0;i<gameboard.length;i++){
      for(int j=0;j<gameboard[i].length;j++){
        if (gameboard[i][j]==null){
          cpt+=1;
        }
      }
    }
    if (getWinner() != null){ //si on a un gagnant alors la partie est FINI LOGIQUE !
      return true;
    }
    else if(getWinner()==null && cpt!=0){ //si il y a un élément null dans le gameboard la partie n'est PAS FINI
      return false;
    }
    else if(getWinner()==null && cpt==0){ // si ya pas de gagnant mais que le tableau est plein alors EGALITE donc FINI
      return true;
    }
  return false;
  }

  @Override
  public String moveToString(int coup){
    String chaine = "";
    int cpt=0;
    for (int i=0;i<gameboard.length;i++){
      for (int j=0;j<gameboard[i].length;j++){
        if (cpt==coup){
          int row = i+1;
          int col = j+1;
          chaine+=cpt+" = ("+row+","+col+")";
        }
        cpt+=1;
      }
    }
  return chaine;
  }

  @Override
  public String situationToString(){
    String[][] gameboard3 = new String[4][4];
    int cpt=0;
    for(int i=0;i<gameboard.length;i++){
      for(int j=0;j<gameboard[i].length;j++){
        if(gameboard[i][j]==joueur1){
          gameboard3[i+1][j+1]="X";
        }
        else if(gameboard[i][j]==joueur2){
          gameboard3[i+1][j+1]="O";
        }
        else if(gameboard[i][j]==null){
          gameboard3[i+1][j+1]=".";
        }
        if(validMoves().contains(cpt)==true && isOver()==false){//représntation comme dans l'énoncé
          int row = i+1;
          int col = j+1;
          System.out.println(cpt+" = ("+row+","+col+")");
        }
        cpt+=1;
      }
    }

    gameboard3[0][0]=" ";
    gameboard3[0][1]="1";
    gameboard3[0][2]="2";
    gameboard3[0][3]="3";
    gameboard3[1][0]="1";
    gameboard3[2][0]="2";
    gameboard3[3][0]="3";

    String chaine1=gameboard3[0][0]+" "+gameboard3[0][1]+" "+gameboard3[0][2]+" "+gameboard3[0][3];
    String chaine2=gameboard3[1][0]+" "+gameboard3[1][1]+" "+gameboard3[1][2]+" "+gameboard3[1][3];
    String chaine3=gameboard3[2][0]+" "+gameboard3[2][1]+" "+gameboard3[2][2]+" "+gameboard3[2][3];
    String chaine4=gameboard3[3][0]+" "+gameboard3[3][1]+" "+gameboard3[3][2]+" "+gameboard3[3][3];

    String chaine=System.lineSeparator();
    chaine+=chaine1;
    chaine+=System.lineSeparator();
    chaine+=chaine2;
    chaine+=System.lineSeparator();
    chaine+=chaine3;
    chaine+=System.lineSeparator();
    chaine+=chaine4;
    chaine+=System.lineSeparator();
    return chaine;
  }

  @Override
  public Game copy(){
    TicTacToe res = new TicTacToe(this.joueur1,this.joueur2);
    res.joueur_courant = super.joueur_courant;
    res.gameboard = new Player[3][3];
    for(int i=0 ; i<gameboard.length ; i++){
      for (int j=0 ; j<gameboard[i].length ; j++){
        res.gameboard[i][j] = this.gameboard[i][j];
      }
    }
    return res;
  }

}
