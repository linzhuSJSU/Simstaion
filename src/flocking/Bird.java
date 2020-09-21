/*
 * Edit history:
 *   Greyson, 4/5: created
 *   
 *
*/
package flocking;


import simstation.Agent;
import simstation.Simulation;

public class Bird extends Agent {

    public Bird(String name, Simulation world) {
        super(name, world);
    }



    public void update(){
        Flocking flocking = (Flocking) world;
        Bird b = (Bird) flocking.getNeighbor(this);
        this.speed = b.speed;
        this.heading = b.heading;
        move(speed);
        world.changed();
    }

}
