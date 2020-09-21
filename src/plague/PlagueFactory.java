/*
 * Edit history:
 *   Lin, 4/5: created
 *   
 *
*/
package plague;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;

public class PlagueFactory extends SimStationFactory {
    @Override
    public View getView(Model model) {
        return new PlagueView((PlagueSimulation) model);
    }

    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public String toString() {
        return "Plague Simulation";
    }
    
    @Override
    public String getTitle() {
    	return "Plague Simulation";
    }
    
    @Override
    public String about() {
    	return "Plague Simulation. Copyright 2020 by Mario Bros";
    }
}
