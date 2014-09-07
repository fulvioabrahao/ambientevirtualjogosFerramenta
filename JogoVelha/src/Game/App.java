package Game;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.awt.GridLayout;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Fúlvio
 */
public class App extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    private static void setNimbusLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
    }

    @Override
    public void init() {
        setNimbusLookAndFeel();
        Forca g = new Forca(this);
        this.setLayout(new GridLayout(1, 1));
        this.setSize(500, 360);
        this.add(g);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
