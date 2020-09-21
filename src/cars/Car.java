package cars;

import simstation.*;

class Car extends Agent {
    private int speed;
    public Car(String name, Simulation world) {
        super(name, world);
        speed = 5;
    }
    public void update() {
        Car neighbor = (Car)world.getNeighbor(this);
        if (neighbor != null) {
            // interact with neighbor
            Heading nbrHeading = neighbor.getHeading();
            switch (nbrHeading) {
                case NORTH: heading = Heading.SOUTH; break;
                case SOUTH: heading = Heading.NORTH; break;
                case EAST: heading = Heading.WEST; break;
                case WEST: heading = Heading.EAST; break;
            }
        }
        move(speed);
    }
    public synchronized int getSpeed() { return speed; }
}

