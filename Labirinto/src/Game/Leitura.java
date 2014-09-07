/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fulvio
 */
public class Leitura {
    private BufferedReader br;

    public Leitura(String str){
        InputStream in = getClass().getResourceAsStream(str);
        InputStreamReader isr =  new InputStreamReader(in);
        br = new BufferedReader(isr);
        
    }
    
    public String proximaLinha(){
        try {
            String pal = br.readLine();
            return Crypt.Decrypt(pal);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public int nextInt(){
        try {
            String pal = Crypt.Decrypt(br.readLine());
            return Integer.parseInt(pal);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
