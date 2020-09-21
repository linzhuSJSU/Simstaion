/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package simstation;

import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements SimFactory {

	@Override
	public Model makeModel() {
		
		return new Simulation();
	}

	@Override
	public String[] getEditCommands() {
		
		return new String[] { "Start", "Suspend", "Resume", "Stop", "Stats" };
	}

	@Override
	public String getTitle() {
		
		return "SimStation";
	}

	@Override
	public String about() {
		
		return "SimStation. Copyright 2020 by Mario Bros";
	}

	@Override
	public String[] getHelp() {
		
		String[] cmmds = new String[6];
		cmmds[0] = "**Command**";
		cmmds[1] = "Start: Start the simulation";
		cmmds[2] = "Suspend: Suspend the simulation";
		cmmds[3] = "Resume: Resume the simulation";
		cmmds[4] = "Stop: Resume the simulation";
		cmmds[5] = "Stats: Display stats for the simulation";
		return cmmds;
	}

	@Override
	public Command makeEditCommand(Model model, String cmmd) {
		if (cmmd == "Start")
			return new StartCommand(model);
		if (cmmd == "Suspend")
			return new SuspendCommand(model);
		if (cmmd == "Resume")
			return new ResumeCommand(model);
		if (cmmd == "Stop")
			return new StopCommand(model);
		if (cmmd == "Stats")
			return new StatsCommand(model);
		
		return null;
	}

	@Override
	public View getView(Model m) {
		// TODO Auto-generated method stub
		return new SimulationView((Simulation) m);
	}

}
