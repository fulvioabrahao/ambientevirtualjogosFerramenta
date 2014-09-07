/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author Fulvio
 */
public class Jogador {
    private int x = 0,y = 0;
    private int pnt = 0;

    public EstadoJogador getEst() {
        return est;
    }

    public void setEst(EstadoJogador est) {
        this.est = est;
    }
    private EstadoJogador est = EstadoJogador.right;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPnt() {
        return pnt;
    }

    public void setPnt(int pnt) {
        this.pnt = pnt;
    }
}
