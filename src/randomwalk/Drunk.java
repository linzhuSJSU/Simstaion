/*
 * Edit history:
 *   Dickson, 4/14: created
 *   
 *
*/
package randomwalk;

import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Drunk extends Agent{

	public Drunk(String name, Simulation world) {
		// TODO Auto-generated constructor stub
		super(name, world);
		this.speed = 5;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move(speed);
		this.heading = Heading.values()[random.nextInt(4)];
        world.changed();
	}

}
