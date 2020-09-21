/*
 * Edit history:
 *   Greyson, 4/5: created
 *   
 *
*/
package flocking;


import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationPanel;
import simstation.Simulation;

public class Flocking extends Simulation {

    public Flocking(){
        super();
    }

    protected void populate(){
        for(int i = 0; i < 50; i++){
            Agent newAgent = new Bird("bird",this);
            agents.add(newAgent);
        }
        changed();
    }
    
    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new FlockingFactory());
        panel.display();
    }
}
