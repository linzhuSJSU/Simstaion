/*
 * Edit history:
 *   Lin, 4/7: created
 *   Greyson, 4/8: getPopup() added
 *
*/
package pdt;

import java.util.ArrayList;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;
import simstation.StatsCommand;

public class Prisoner extends Agent{

	private int fitness = 0;
    private Strategy strategy;
    private ArrayList<Boolean> cooperateHistory;
    private boolean popup = true;
    
    
    public Prisoner(String name, Simulation world) {
        super(name, world);
        strategy = new AlwaysCooperate(this);
        cooperateHistory = new ArrayList<Boolean>();
    }

    public synchronized void addCooperateHistory(boolean b){
        cooperateHistory.add(b);
    }

    public synchronized void setStrategy(Strategy s) {
        strategy = s;
    }

    public synchronized void increaseFitness(int num) {
        fitness += num;
    }

    public synchronized int getFitness() {
        return fitness;
    }

    public synchronized boolean cooperate() {
        return strategy.execute(cooperateHistory);
    }

    private  synchronized void getPopup() {
    	 	
    	if ((world.getClock() % 100 == 0.0) 
    			&& (world.getClock() != 0)) {
    		try {
    			if(((world.getClock() % 100 == 0) 
    					&& (this.getWorld().getAgents().get(0).equals(this)))) {
    				
    				(new StatsCommand(world)).execute();
    				Thread.sleep(1000);
				
    			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
    		
    	}
          	
    }
    
    private synchronized Simulation getWorld() {
		// TODO Auto-generated method stub
		return world;
	}

	@Override
    public void update() {
        PDT tournament = (PDT) world;
        Prisoner neighbor = (Prisoner) tournament.getNeighbor(this);

        if(neighbor != null){
            boolean prison1Choice = cooperate();
            boolean prison2Choice = neighbor.cooperate();

            if(prison1Choice && prison2Choice){
                increaseFitness(3);
                neighbor.increaseFitness(3);
            }else if(!prison1Choice && prison2Choice){
                increaseFitness(5);
                neighbor.increaseFitness(0);
            }else if(prison1Choice && !prison2Choice){
                increaseFitness(0);
                neighbor.increaseFitness(5);
            }else{
                increaseFitness(1);
                neighbor.increaseFitness(1);
            }

            addCooperateHistory(prison2Choice);
            neighbor.addCooperateHistory(prison1Choice);
        }

        this.heading = Heading.values()[random.nextInt(4)];
        this.speed = random.nextInt(10);

        move(speed);
        
        getPopup();
        world.changed();
        
        
      
    }
}