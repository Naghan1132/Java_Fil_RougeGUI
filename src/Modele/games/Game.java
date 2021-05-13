package games;

import players.*;
import java.util.*;

public interface Game{

  public void execute(int coup);
  public Player getCurrentPlayer();
  public ArrayList<Integer> validMoves();
  public boolean isValid(int coup);
  public String situationToString();
  public String moveToString(int coup);
  public boolean isOver();
  public Player getWinner();
  public Game copy(); //Pour Negamax

}
