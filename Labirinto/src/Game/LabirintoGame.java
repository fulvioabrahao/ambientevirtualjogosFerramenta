/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Fulvio
 */
public class LabirintoGame {
    private AdmGame adm = new AdmGame();
    private Jogador player = new Jogador();
    private Labirinto maze = new Labirinto(adm.getDimensao());
    private Vector<Pair<Integer,Integer> > PosPergunta = new Vector<>() ;

    public Vector<Pair<Integer, Integer>> getPosPergunta() {
        return PosPergunta;
    }

    public void setPosPergunta(Vector<Pair<Integer, Integer>> PosPergunta) {
        this.PosPergunta = PosPergunta;
    }
    LabirintoGame(){
        boolean M[][] = new boolean [adm.getDimensao()][adm.getDimensao()];
        for(int i = 0;i<adm.getDimensao();i++){
            for(int j = 0;j<adm.getDimensao();j++){
                M[i][j] = false;
            }
        }
        Random randomGenerator = new Random();
        int qtd = adm.getDimensao();
        while(qtd>0){
            int i = randomGenerator.nextInt(adm.getDimensao()-1) + 1;
            int j = randomGenerator.nextInt(adm.getDimensao()-1) + 1;
            if(M[i][j] == true)
                continue;
            M[i][j] = true;
            qtd--;
            PosPergunta.add(new Pair<Integer,Integer>(new Integer(i),new Integer(j))); 
        }
        
    }
    
    public Pergunta getPergunta(int x , int y){
        for(int i = 0;i<adm.getQtdperguntas();i++){
            if(PosPergunta.get(i).first == x && PosPergunta.get(i).second == y){
                return adm.getP().get(i);
            }
        }
        return null;
    }
    
    public AdmGame getAdm() {
        return adm;
    }

    public void setAdm(AdmGame adm) {
        this.adm = adm;
    }

    public Jogador getPlayer() {
        return player;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }

    public Labirinto getMaze() {
        return maze;
    }

    public void setMaze(Labirinto maze) {
        this.maze = maze;
    }
    
    public boolean fimDeJogo(){
        return (adm.getQtdperguntas() == adm.getPerguntaAtual());
    }
    
    public boolean moveUp(){
        if(player.getY()-1>=0 && maze.getMaze(player.getX(), player.getY(), 1) == false){
            player.setY(player.getY()-1);
            return true;
        }
        return false;
    }
    
    public boolean moveLeft(){
        if(player.getX()-1>=0 && maze.getMaze(player.getX(), player.getY(), 0) == false){
            player.setX(player.getX()-1);
            return true;
        }
        return false;
    }
    
    public boolean moveDown(){
        if(player.getY()+1<maze.getM() && maze.getMaze(player.getX(), player.getY()+1, 1) == false){
            player.setY(player.getY()+1);
            return true;
        }
        
        return false;
    }
    
    public boolean moveRight(){
        if(player.getX()+1<maze.getN() && maze.getMaze(player.getX()+1, player.getY(), 0) == false){
            player.setX(player.getX()+1);
            return true;
        }
        return false;
    }
    
}
