/*
 * Edit history:
 *   Lin, 4/5: created
 *   Greyson, 4/6: fixed bug in paintComponent()
 *
*/
package plague;

import simstation.Agent;
import simstation.SimulationView;

import java.awt.*;

public class PlagueView extends SimulationView {

    public PlagueView(PlagueSimulation model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics gc) {
        PlagueSimulation plagueSimulation = (PlagueSimulation) model;
        Color oldColor = gc.getColor();

        for (Agent agent : getAgents()) {

            Host plagueAgent = (Host) agent;

            //paint the healthy patients
            if (plagueAgent.isInfected())
                gc.setColor(Color.RED);
            else
                gc.setColor(Color.GREEN);

            int r = 5;
            gc.fillOval(agent.getXc(), agent.getYc(), r, r);
        }

        gc.setColor(oldColor);
    }
}
