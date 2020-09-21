/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package simstation;

import mvc.AppFactory;
import mvc.Model;
import mvc.View;

public interface SimFactory extends AppFactory{

	public View getView(Model m);
	
}
