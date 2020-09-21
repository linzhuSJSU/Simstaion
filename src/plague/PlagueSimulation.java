/*
 * Edit history:
 *   Lin, 4/5: created
 *   
 *
*/
package plague;

import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationPanel;
import simstation.Simulation;

import java.util.Arrays;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 10; // % chance of infection
    public static int RESISTANCE = 10; // % chance of resisting infection

    public PlagueSimulation() {
        super();
    }

    @Override
    protected void populate() {
        for (int i = 0; i < 49; i++) {
            Agent newAgent = new Host("PlagueAgent", this);
            agents.add(newAgent);
        }

        //make an infected agent
        Agent newAgent = new Host("PlagueAgent", this, true);
        agents.add(newAgent);

        changed();

    }

    @Override
    public String[] getStats() {
        String[] old = super.getStats();
        String[] newStats = Arrays.copyOf(old, old.length + 2);
        int infectedAgents = 0;
        for (Agent a : agents) {
            Host agent = (Host) a;
            if (agent.isInfected())
                infectedAgents++;
        }

        newStats[old.length] = "Infected Agents: " + infectedAgents;
        newStats[old.length + 1] = "Healthy Agents: " + (agents.size() - infectedAgents);
        return newStats;
    }

    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new PlagueFactory());
        panel.display();
    }
}

