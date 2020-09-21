/*
 * Edit history:
 *   Lin, 4/5: created
 *   
 *
*/
package plague;


import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Host extends Agent {
    private boolean infected;

    public Host(String name, PlagueSimulation world, boolean infected) {
        this(name, world);
        this.infected = infected;
    }

    public boolean isInfected() {
        return infected;
    }


    public Host(String name, Simulation world) {
        super(name, world);
        infected = false;
    }

    @Override
    public void update() {
        //move randomly
        moveRandomly();

        //get the neighbor
        Host neighbor = (Host) world.getNeighbor(this);

        //then infect its neighbor
        if (this.infected)
            infectOthers(neighbor);

        world.changed();
    }

    private void moveRandomly() {
        this.heading = Heading.values()[random.nextInt(4)];
        this.speed = 5;

        move(speed);
        world.changed();
    }

    private synchronized void infectOthers(Host target) {

        //generate a number from 0 to 99
        int randomNumber = (int) (random.nextDouble() * 100);


        //if the random number is bigger than the percentage, then the target will be infected
        if (randomNumber < PlagueSimulation.VIRULENCE) {

            //generate another random number
            randomNumber = (int) (random.nextDouble() * 100);

            if (randomNumber > PlagueSimulation.RESISTANCE && !target.isInfected()) {
                //infect the neighbor
                target.infected = true;
                PlagueSimulation world = (PlagueSimulation) this.world;
            }
        }
    }
}
