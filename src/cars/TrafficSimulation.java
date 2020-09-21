package cars;

import mvc.AppPanel;
import simstation.*;

public class TrafficSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 50; i++) {
            Agent newAgent = new Car("Car",this);
            agents.add(newAgent);
        }
    }
    public static void main(String[] args) {
        AppPanel panel = new SimStationPanel(new TrafficFactory());
        panel.display();
    }
}