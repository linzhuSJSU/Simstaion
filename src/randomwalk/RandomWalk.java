/*
 * Edit history:
 *   Dickson, 4/14: created
 *   
 *
*/
package randomwalk;

import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationPanel;
import simstation.Simulation;

public class RandomWalk extends Simulation {

	public RandomWalk() {
		// TODO Auto-generated constructor stub
		super();
	}

	protected void populate(){
        for(int i = 0; i < 50; i++){
            Agent newAgent = new Drunk("drunkPeople",this);
            agents.add(newAgent);
        }
        changed();
    }
	
	public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new RandomWalkFactory());
        panel.display();
    }
	
}
