/*
 * Edit history:
 *   Lin, 4/7: created
 *   
 *
*/
package pdt;

import java.util.ArrayList;

public class CooperateLastCooperated extends Strategy {

	public CooperateLastCooperated(Prisoner owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(ArrayList<Boolean> cooperateHistory) {
		if(cooperateHistory.size() == 0){
            return false;
        }

        if(cooperateHistory.get(cooperateHistory.size() - 1)){
            return true;
        }

        return false;
    }


}
