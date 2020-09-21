/*
 * Edit history:
 *   Lin, 4/7: created
 *   
 *
*/
package pdt;

import mvc.Model;
import simstation.SimStationFactory;

public class PDTFactory extends SimStationFactory{

    @Override
    public Model makeModel() {
        return new PDT();
    }

    @Override
    public String toString() {
        return "PDT Simulation";
    }
    
    @Override
    public String getTitle() {
    	return "PDT Simulation";
    }
    
    @Override
    public String about() {
    	return "PDT Simulation. Copyright 2020 by Mario Bros";
    }
}
