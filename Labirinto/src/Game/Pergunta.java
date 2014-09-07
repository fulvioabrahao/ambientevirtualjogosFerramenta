/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import javax.swing.JFrame;

/**
 *
 * @author Fulvio
 */
public class Pergunta extends JFrame{
    private boolean respondeu = false;
    private boolean acertou = false;

    public boolean isRespondeu() {
        return respondeu;
    }

    public void setRespondeu(boolean respondeu) {
        this.respondeu = respondeu;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }
}
