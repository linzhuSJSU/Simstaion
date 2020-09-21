/*
 * Edit history:
 *   Lin, 4/1: created
 *   
 *
*/
package simstation;

import java.io.Serializable;
import java.util.Random;

public abstract class Agent implements Runnable,Serializable{
    protected String name;
    protected Heading heading;
    protected Integer xc;
    protected Integer yc;
    protected Simulation world;
    protected AgentState state;
    private Thread thread;
    protected Random random = new Random();
    protected int speed;

    public Agent(String name, Simulation world){
        this.name = name;
        this.heading = Heading.values()[random.nextInt(4)];
        this.speed = random.nextInt(10);
        this.xc = random.nextInt(500);
        this.yc = random.nextInt(500);
        this.world = world;
        this.state = null;
    }

    public String getName(){
        return name;
    }
    public Heading getHeading(){
        return heading;
    }
    public Integer getXc(){
        return xc;
    }
    public Integer getYc(){
        return yc;
    }
    public synchronized AgentState getState(){
        return state;
    }

    public synchronized void join()throws InterruptedException{
        if(thread!= null){
            thread.join();
        }
    }

    public synchronized String toString(){
        return name + ".State = " + state;
    }

    public void run() {
        try {
            while(!isStopped()) {
                state = AgentState.RUNNING;
                update();
                Thread.sleep(20); // be cooperative
                synchronized(this) {
                    while(state == AgentState.SUSPENDED) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            onInterrupted();
        }
        onExit();
    }

    public void start(){
        if(state == null){
            state = AgentState.READY;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop(){
        if(state != AgentState.STOPPED){
            state = AgentState.STOPPED;
        }
    }

    public synchronized boolean isStopped(){
        return state == AgentState.STOPPED;
    }

    public synchronized void suspend(){
        if(state == AgentState.RUNNING){
            state = AgentState.SUSPENDED;
        }
    }

    public synchronized boolean isSuspended(){
        return state == AgentState.SUSPENDED;
    }

    public synchronized void resume(){
        if(state == AgentState.SUSPENDED){
            notify();
            state = AgentState.READY;
        }
    }

    public abstract void update();

    public void move(int steps) {
        switch(heading)
        {
            case NORTH:
            {
                yc += steps;
                if(yc >= Simulation.WORLD_SIZE){
                    yc = 0;
                }
                break;
            }
            case SOUTH:
            {
                yc -= steps;
                if(yc <= 0){
                    yc = Simulation.WORLD_SIZE;
                }
                break;
            }
            case EAST:
            {
                xc += steps;
                if(xc >= Simulation.WORLD_SIZE){
                    xc = 0;
                }
                break;
            }
            case WEST:
            {
                xc -= steps;
                if(xc <= 0){
                    xc = Simulation.WORLD_SIZE;
                }
                break;
            }
        }
        world.changed();
    }

    protected synchronized void onStart() {}
    protected synchronized void onExit() {}
    protected synchronized void onInterrupted() {}

}

