package games;

import java.util.*;
import players.*;

public abstract class AbstractGame implements Game{

  protected players.Player joueur1;
  protected players.Player joueur2;
  protected players.Player joueur_courant;

  public AbstractGame(players.Player joueur1,players.Player joueur2){
    this.joueur1=joueur1;
    this.joueur2=joueur2;
    this.joueur_courant=joueur1;
  }

  protected abstract void doExecute(int coup);

  @Override
  public void execute(int coup){
    doExecute(coup);
    if(joueur_courant==joueur1){
      joueur_courant=joueur2;
    }
    else{
      joueur_courant=joueur1;
    }
  }

  @Override
  public Player getCurrentPlayer(){
    return joueur_courant;
  }

}
