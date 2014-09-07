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
public class Contador {
    private long inicio;
    private double tempo;
    private boolean ligado;
    
    public Contador(){
        ligado = false;
        tempo = 0;
        inicio = System.currentTimeMillis();
    }
    
    public void start(int time){
        inicio = System.currentTimeMillis();
        ligado = true;
        tempo = time * 1000;
    }
    
    public long getTimeSeconds(){
        if(!ligado)
            return (long) (tempo/1000);
        else
            return (long) (Math.max(0.0,tempo - (System.currentTimeMillis() - inicio))/1000);
    }
        
 
    public void stop(){
        tempo = getTimeSeconds()*1000.0;
        ligado = false;
    }

    public long  getTimeMinutes() {
         if(!ligado)
            return (long) (tempo/60000);
        else
            return (long) (Math.max(0.0,tempo - (System.currentTimeMillis() - inicio))/60000);
    }
  
}
