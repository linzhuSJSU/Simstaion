/*
 * Edit history:
 *   Lin, 4/7: created
 *   
 *
*/
package pdt;

import java.util.ArrayList;

public class AlwaysCooperate extends Strategy {

	public AlwaysCooperate(Prisoner owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean execute(ArrayList<Boolean> cooperateHistory) {
		// TODO Auto-generated method stub
		return true;
	}

}
