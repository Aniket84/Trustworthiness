/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TruthFinder;

/**
 *
 * @author Asus
 */
import websphinx.*;
import java.awt.*;
import rcm.awt.Constrain;

public class SimpleCrawlerEditor2 extends CrawlerEditor2 {

    Label actionLabel;
    ActionEditor2 actionEditor;

    public SimpleCrawlerEditor2 () {
        super ();

        // remove all the pieces we don't need
        remove (typeLabel);
        remove (typeChoice);
        remove (depthLabel);
        remove (depthField);
        remove (depthLabel2);
        remove (searchOrderChoice);

        // add an action editor
        actionLabel = new Label("Action:");
        actionEditor = new ActionEditor2 ();
        Constrain.add (this, actionLabel, 
                       Constrain.labelLike (0, 4));
        Constrain.add (this, actionEditor, 
                       Constrain.areaLike (1, 4, 4));
    }

    public void setCrawler (Crawler crawler) {
        super.setCrawler (crawler);
        actionEditor.setAction (crawler.getAction());
    }

    public Crawler getCrawler () {
        crawler.setAction (actionEditor.getAction ());
        return super.getCrawler ();
    }

}
