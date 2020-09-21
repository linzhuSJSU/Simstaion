package cars;

import mvc.Model;
import simstation.SimStationFactory;

class TrafficFactory extends SimStationFactory {
    public Model makeModel() { return new TrafficSimulation(); }
}