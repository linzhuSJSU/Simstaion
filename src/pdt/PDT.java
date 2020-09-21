/*
 * Edit history:
 *   Lin, 4/7: created
 *   Greyson, 4/8: getStats() added
 *
*/
package pdt;

import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationFactory;
import simstation.SimStationPanel;
import simstation.Simulation;

public class PDT extends Simulation {

	public PDT(){
        super();
        
    }

    protected void populate(){
        for(int i=0; i<10; i++){
            Prisoner p = new Prisoner("prisoner",this);
            p.setStrategy(new AlwaysCheat(p));
            Agent newAgent = p;
            agents.add(newAgent);
        }

        for(int i=10; i<20; i++){
            Prisoner p = new Prisoner("prisoner",this);
            p.setStrategy(new AlwaysCooperate(p));
            Agent newAgent = p;
            agents.add(newAgent);
        }


        for(int i=20; i<30; i++){
            Prisoner p = new Prisoner("prisoner",this);
            p.setStrategy(new CooperateLastCooperated(p));
            Agent newAgent = p;
            agents.add(newAgent);
        }


        for(int i=30; i<40; i++){
            Prisoner p = new Prisoner("prisoner",this);
            p.setStrategy(new RandomlyCooperate(p));
            Agent newAgent = p;
            agents.add(newAgent);
        }

        changed();
    }

    @Override
    public String[] getStats() {
    	
        String[] stats = new String[6];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;

        double average;

        average = 0.0;
        for(int i = 0; i < 10; i++){
        	Prisoner p = (Prisoner)agents.get(i);
            average += p.getFitness();
        }
        average /= 10.0;
        stats[2] = "[Always Cheat Strategy]: " + average;

        average = 0.0;
        for(int i = 10; i < 20; i++){
        	Prisoner p = (Prisoner)agents.get(i);
            average += p.getFitness();
        }
        average /= 10.0;
        stats[3] = "[Always Cooperate Strategy]: " + average;

        average = 0.0;
        for(int i = 20; i < 30; i++){
        	Prisoner p = (Prisoner)agents.get(i);
            average += p.getFitness();
        }
        average /= 10.0;
        stats[4] = "[Cooperate Only If Last Opponent Cooperated Strategy]: " + average;

        average = 0.0;
        for(int i = 30; i < 40; i++){
        	Prisoner p = (Prisoner)agents.get(i);
            average += p.getFitness();
        }
        average /= 10.0;
        stats[5] = "[Randomly Cooperate Strategy] : " + average;
        
        return stats;
    	
    }
    
    public static void main(String[] args) {

        SimStationFactory factory = new PDTFactory();
        AppPanel panel = new SimStationPanel(factory);
        panel.display();
    }
}
