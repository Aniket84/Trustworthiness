/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TruthFinder;

/**
 *
 * @author Asus
 */
import java.awt.*;
abstract class FeatureChoice2 extends Choice
{

    public FeatureChoice2 () {
    }        

    public abstract Panel getArgs ();

    public synchronized void select (int pos) {
        super.select (pos);
        flipArgs ();
    }

    public synchronized void select (String item) {
       // item="";
        super.select (item);
        flipArgs ();
    }

    public boolean handleEvent (Event event) {
        if (event.id == Event.ACTION_EVENT && event.target == this) {
            flipArgs ();
            return true;
        }
        else
            return super.handleEvent (event);
    }

    void flipArgs () {
        Panel args = getArgs();
        CardLayout layout = (CardLayout)(args.getLayout ());
        layout.show (args, getSelectedItem());
    }

}
