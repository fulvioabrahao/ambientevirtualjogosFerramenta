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
public class Crypt {
    private Crypt(){
    
    }

    public static String Decrypt(String frase){
        if(frase == null)return null;
        StringBuilder Ecr = new StringBuilder(frase);
        for(int i = 0;i<frase.length();i++){
            Ecr.setCharAt(i, (char) (Ecr.charAt(i) - 3));
        }        
        return Ecr.toString();
    }
    
    public static String Ecrypt(String frase){
        if(frase == null)return null;
        StringBuilder Ecr = new StringBuilder(frase);
        for(int i = 0;i<frase.length();i++){
            Ecr.setCharAt(i, (char) (Ecr.charAt(i) + 3));
        }        
        return Ecr.toString();
    }
}
