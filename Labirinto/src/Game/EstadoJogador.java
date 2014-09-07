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
public enum EstadoJogador {
   down(0),left(1),right(2),up(3);
   
    public int valor;
    EstadoJogador(int v){
        this.valor = v;
    }
}
