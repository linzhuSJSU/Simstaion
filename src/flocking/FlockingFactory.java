/*
 * Edit history:
 *   Greyson, 4/5: created
 *   
 *
*/
package flocking;


import mvc.Model;
import simstation.SimStationFactory;

public class FlockingFactory extends SimStationFactory {

    @Override
    public Model makeModel() {
        return new Flocking();
    }

    @Override
    public String toString() {
        return "Flocking Simulation";
    }
    
    @Override
    public String getTitle() {
    	return "Flocking Simulation";
    }
    
    @Override
    public String about() {
    	return "Flocking Simulation. Copyright 2020 by Mario Bros";
    }
}
