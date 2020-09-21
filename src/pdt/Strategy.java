/*
 * Edit history:
 *   Lin, 4/7: created
 *   
 *
*/
package pdt;

import java.util.ArrayList;

public abstract class Strategy {
	
	  protected Prisoner owner;
	  
	  public Strategy(Prisoner owner) { 
		  
		  this.owner = owner; 
		  
	  }
	  
	  public abstract boolean execute(ArrayList<Boolean> cooperateHistory);
	  
}

