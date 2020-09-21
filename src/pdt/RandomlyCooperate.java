/*
 * Edit history:
 *   Lin, 4/7: created
 *   
 *
*/
package pdt;

import java.util.ArrayList;
import java.util.Random;

public class RandomlyCooperate extends Strategy {

	public RandomlyCooperate(Prisoner owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(ArrayList<Boolean> cooperateHistory) {

		boolean result = true;
		Random random = new Random();
		int num = random.nextInt(2);
		if (num == 0) {
			result = false;
		}
		return result;
	}

}
