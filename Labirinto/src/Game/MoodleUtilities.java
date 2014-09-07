/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import netscape.javascript.JSObject;

/**
 *
 * @author Fúlvio
 */
public class MoodleUtilities {
    private MoodleUtilities(){
        
    }
    
    public static void enviaPontos(int pts,App app){
        JSObject window = JSObject.getWindow(app);
        window.call("SubmitAnswers", new Object[] {pts});
    }
    
}
