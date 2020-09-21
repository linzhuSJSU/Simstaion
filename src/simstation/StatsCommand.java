/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package simstation;

import mvc.Command;
import mvc.Model;

import javax.swing.*;


public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        String[] stats = simulation.getStats();
        String message = "";
        for(int i = 0; i < stats.length; i++){
            message += stats[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
