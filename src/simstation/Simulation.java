/*
 * Edit history:
 *   Lin, 4/1: created
 *   Greyson, 4/2: fixed the bug (clock is not working)
 *
*/
package simstation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation extends Model {
	protected int clock;
    private Timer timer;
    protected ArrayList<Agent> agents;
    public static Integer WORLD_SIZE = 250;

    public Simulation(){
        agents = new ArrayList<>();
        clock = 0;
    }

    private class ClockUpdater extends TimerTask {
        @Override
        public void run() {
            clock++;
        }
    }

    private void startTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000,1000);
    }
    
    private void stopTimer(){
        timer.cancel();
        timer.purge();
    }

    protected void populate() {}

    public void start(){
    	clock = 0;
        agents = new ArrayList<>();
        populate();
        startTimer();
        for(int i = 0; i < agents.size(); i++){
            agents.get(i).start();
        }
        changed();
    }

    public void suspend(){

        for(int i = 0; i < agents.size(); i++){
            agents.get(i).suspend();
        }
        stopTimer();
        changed();
    }

    public void resume(){
    	
    	startTimer();
        for(int i = 0; i < agents.size(); i++){
            agents.get(i).resume();
        }
        changed();
    }

    public void stop(){

        for(int i = 0; i < agents.size(); i++){
            agents.get(i).stop();
        }
        stopTimer();
        changed();
    }

    public synchronized Agent getNeighbor(Agent seeker){
        Agent agent = null;
        double min = Integer.MAX_VALUE;

        for(Agent a: agents){
            if(seeker!=a){
                double distance = Math.sqrt(Math.pow((seeker.getXc() - a.getXc()),2) + Math.pow((seeker.getYc() - a.getYc()),2));
                if(distance < min){
                    min = distance;
                    agent = a;
                }
            }
        }
        return agent;
    }

    public String[] getStats(){
        String[] stats = new String[2];
        stats[0] = "Number of agents: " + agents.size();
        stats[1] = "clock: " + clock;
        return stats;
    }

    public int getClock() {
    	return clock;
    }

	public ArrayList<Agent> getAgents() {
		// TODO Auto-generated method stub
		return agents;
	}

}
