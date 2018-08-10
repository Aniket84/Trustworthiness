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
import websphinx.*;
import rcm.awt.Constrain;
import rcm.awt.PopupDialog;
import rcm.util.Win;
import websphinx.workbench.*;

// FIX: consider implementing java.beans.PropertyEditor
public class ActionEditor2 extends Panel { 

    ActionFeatureChoice2 choice;

    /**
     * Make a ActionEditor.
     */
    public ActionEditor2 () {
        setLayout (new GridBagLayout ());
        choice = new ActionFeatureChoice2 ();
        Constrain.add (this, choice, Constrain.labelLike (0, 0));
        Constrain.add (this, choice.getArgs(), Constrain.areaLike (0, 1));
        setAction (null);
    }

    public void setAction (Action act) {
        choice.setAction (act);
    }

    public Action getAction () {
        return choice.getAction ();
    }

}

class ActionFeatureChoice2 extends FeatureChoice2 {
    ActionFeatureArgs2 args = new ActionFeatureArgs2 ();

    final static String NULL_ACTION = "none";
  
    final static String EXTRACT_ACTION = "extract";
   

    public ActionFeatureChoice2 () {
        addItem (NULL_ACTION);
       
        addItem (EXTRACT_ACTION);
        
    }
    
    public void setAction (Action act) {
        if (act == null) {
            select (NULL_ACTION);
        }
        else if (act instanceof ExtractAction) {
            ExtractAction extract = (ExtractAction)act;
            select (EXTRACT_ACTION);
            args.setExtractFilename (extract.getFilename ());
            args.setExtractUseBrowser (extract.getUseBrowser ());
            args.setExtractPattern (extract.getPattern ().toString ());
            args.setTextOnly (extract.getTextOnly ());
        }
        
        else {
            select (NULL_ACTION);
        }
    }

    public Panel getArgs () {
        return args;
    }

    public Action getAction () {
        String actn = getSelectedItem ();
         if (actn.equals (EXTRACT_ACTION))
            return new ExtractAction2 (new Tagexp (args.getExtractPattern()),
                                      args.getExtractUseBrowser (),
                                      args.getExtractFilename (),
                                      args.getTextOnly ());
        
        else
            return null;
    }
}

class ActionFeatureArgs2 extends Panel {

    static final String TEMPORARY_DIR = "(temporary directory)";
    static final String TEMPORARY_FILE = "(temporary file)";

    Choice color;
    Choice scale;
    //Choice icon;        
    TextField mirrorDirectory;    
    Checkbox mirrorUseBrowser;

    TextField concatFilename;
    Checkbox concatUseBrowser;
    Button optionsButton;
    String prolog = Concatenator.defaultProlog;
    String header = Concatenator.defaultHeader;
    String footer = Concatenator.defaultFooter;
    String divider = Concatenator.defaultDivider;
    String epilog = Concatenator.defaultEpilog;

    TextField extractFilename;
    TextArea extractPattern;
    Choice extractMedium;
    Checkbox extractUseBrowser;

    TextArea script;

    Button browseMirrorDirectory;
    Button browseConcatFilename;
    Button browseExtractFilename;

    public ActionFeatureArgs2 () {
        Panel panel;

        setLayout (new CardLayout ());

        add (ActionFeatureChoice2.NULL_ACTION, panel = new Panel ());

        
        
        add (ActionFeatureChoice2.EXTRACT_ACTION, panel = Constrain.makeConstrainedPanel (5, 4));
        Constrain.add (panel, new Label ("regions matching the HTML tag expression:"), Constrain.labelLike (0, 0, 5));
        Constrain.add (panel, extractPattern = new TextArea(3, 40), Constrain.fieldLike (0, 1, 5));
        Constrain.add (panel, new Label ("as"), Constrain.labelLike (0, 2));
        Constrain.add (panel, extractMedium = new Choice (), Constrain.labelLike (1, 2));
        extractMedium.addItem ("HTML");
        extractMedium.addItem ("text");
        Constrain.add (panel, new Label ("to file: "), Constrain.labelLike (2, 2));
        Constrain.add (panel, extractFilename = new TextField(), Constrain.fieldLike (3, 2));
        Constrain.add (panel, browseExtractFilename = new Button ("..."), Constrain.labelLike (4, 2));
        extractUseBrowser = new Checkbox ("Display in browser");
        extractUseBrowser.setState (true);
        if (Context.getBrowser() != null) {
            extractFilename.setText (TEMPORARY_FILE);
            Constrain.add (panel, extractUseBrowser, Constrain.labelLike (3, 3));
        }
            
       
       
    }
    
    public boolean handleEvent (Event event) {
        if (event.id == Event.ACTION_EVENT) {
            if (event.target == browseExtractFilename)
                browse ("Save Extracts As", extractFilename);
           
            else
                return super.handleEvent (event);
        }
        else
            return super.handleEvent (event);
            
        return true;
    }
        
    
    void browse (String title, TextField target) {
        String fn = PopupDialog.askFilename (this, title, target.getText(), false);
        if (fn != null)
            target.setText (fn);
    }
                       
    public void setColor (String color) {
        this.color.select (color);
    }

    public String getColor () {
        return color.getSelectedItem ();
    }

    public void setScale (String scale) {
        try {
            double d = Double.valueOf (scale).doubleValue();
            // FIX: allow user to enter any scale factor ?
            if (d < 1)
                this.scale.select ("small");
            else if (d > 1)
                this.scale.select ("large");
            else
                this.scale.select ("normal");
        } catch (NumberFormatException e) {
            this.scale.select ("normal");                
        }
    }

    public String getScale () {
        switch (scale.getSelectedIndex()) {
            case 0: return "0.5";
            case 2: return "2.0";
            default: return "1.0";
        }
    }

    public void setIcon (String icon) {
        //this.icon.select (color);
    }

    public String getIcon () {
        return null;
        //return icon.getSelectedItem ();
    }

    
    public void setMirrorDirectory (String directory) {
        mirrorDirectory.setText (directory != null ? directory : TEMPORARY_DIR);
    }

    public String getMirrorDirectory () {
        String f = mirrorDirectory.getText ();
        return f.equals (TEMPORARY_DIR) ? null : f;
    }

    public void setMirrorUseBrowser (boolean use) {
        mirrorUseBrowser.setState (use);
    }

    public boolean getMirrorUseBrowser () {
        return mirrorUseBrowser.getState ();
    }

    public void setConcatFilename (String filename) {
        concatFilename.setText (filename != null ? filename : TEMPORARY_FILE);
    }

    public String getConcatFilename () {
        String f = concatFilename.getText ();
        return f.equals (TEMPORARY_FILE) ? null : f;
    }

    public void setConcatUseBrowser (boolean use) {
        concatUseBrowser.setState (use);
    }

    public boolean getConcatUseBrowser () {
        return concatUseBrowser.getState ();
    }

    public void setExtractFilename (String filename) {
        extractFilename.setText (filename != null ? filename : TEMPORARY_FILE);
    }

    public String getExtractFilename () {
        String f = extractFilename.getText ();
        return f.equals (TEMPORARY_FILE) ? null : f;
    }

    public void setExtractUseBrowser (boolean use) {
        extractUseBrowser.setState (use);
    }

    public boolean getExtractUseBrowser () {
        return extractUseBrowser.getState ();
    }

    public void setExtractPattern (String pattern) {
        extractPattern.setText (pattern);
    }

    public String getExtractPattern () {
        return extractPattern.getText ();
    }
    
    public void setTextOnly (boolean f) {
        extractMedium.select (f ? "text" : "HTML");
    }
    
    public boolean getTextOnly () {
        return extractMedium.getSelectedItem().equals ("text");
    }

    public void setScript (String script) {
        this.script.setText (script);
    }

    public String getScript () {
        return script.getText ();
    }
}

