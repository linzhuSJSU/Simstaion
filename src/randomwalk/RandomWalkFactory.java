/*
 * Edit history:
 *   Dickson, 4/14: created
 *   
 *
*/
package randomwalk;

import mvc.Model;
import simstation.SimStationFactory;

public class RandomWalkFactory extends SimStationFactory {

    @Override
    public Model makeModel() {
        return new RandomWalk();
    }

    @Override
    public String toString() {
        return "RandomWalk Simulation";
    }
    
    @Override
    public String getTitle() {
    	return "RandomWalk Simulation";
    }
    
    @Override
    public String about() {
    	return "RandomWalk Simulation. Copyright 2020 by Mario Bros";
    }
}