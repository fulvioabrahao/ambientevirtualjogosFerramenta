/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Fulvio
 */
public class App extends Applet implements Runnable , KeyListener,MouseListener, MouseMotionListener{
    private int x, y;
    private int n;
    private LabirintoGame MazeGame;
    private Image img;
    private Graphics doubleG;
    private int raio;
    private boolean key[];
    private EstadoJogo est = EstadoJogo.Menu;
    private int Dp;
    private Image MenuImg;
    private Image BotaoMenuImg;
    private Image ScenarioGame;
    private Image Star;
    private Image PersonSprite;
    private Image WaitQuestion;
    private Image Fim;
    private boolean buttonFlag = false;
    private Pergunta p;
    private Contador contador = new Contador();
    
    @Override
    
    public void init() {
        setSize(640,480);
        addKeyListener(this);
        key = new boolean [1000];
        for(int i = 0;i<1000;i++)key[i] = false;
        setBackground(Color.black);
       
        try {
            MenuImg = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("LabirintoMenu.jpg")))).getImage();
            BotaoMenuImg = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("BotaoMenu.jpg")))).getImage();
            ScenarioGame = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("GameImg.png")))).getImage();
            Star = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("star.png")))).getImage();
            PersonSprite = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("person.png")))).getImage();
            WaitQuestion = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("question.png")))).getImage(); 
            Fim = (new ImageIcon(ImageIO.read(getClass().getResourceAsStream("fim.png")))).getImage(); 
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
      this.setFocusable(true);
      addMouseListener( this );
      addMouseMotionListener( this );
      MazeGame = new LabirintoGame();
      n = MazeGame.getAdm().getDimensao();
      Dp = 100/n;

    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        while(true){
            repaint();        
            if(est == EstadoJogo.Rodando){
                p = MazeGame.getPergunta(MazeGame.getPlayer().getX(), MazeGame.getPlayer().getY());
                if(p!=null && !p.isRespondeu()){       
                    est = EstadoJogo.Pergunta;
                    if(!p.isVisible()) p.setVisible(true);
                }
                if(contador.getTimeSeconds() == 0 || MazeGame.getAdm().getQtdPerguntasRespondidas()==MazeGame.getAdm().getQtdperguntas()){
                    est = EstadoJogo.Fim;
                    MoodleUtilities.enviaPontos(MazeGame.getAdm().getQtdAcertos()*MazeGame.getAdm().getPontuacao()/MazeGame.getAdm().getQtdperguntas(), this);
                }

            }else
            if(est == EstadoJogo.Fim){
            
            
            }else
            if(est == EstadoJogo.Pergunta){
                while(!p.isRespondeu()){
                    repaint(); 
                    p.setFocusable(true);
                    p.requestFocus();
                    if(!p.isVisible()) p.setVisible(true);
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                est = EstadoJogo.Rodando;
                this.requestFocus();
                
            }
            
            //controle de fps
            try {
                Thread.sleep(17);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void stop() {
   
    }

    @Override
    public void destroy() {
  
    }

    @Override
    public void update(Graphics g) {
       if(img == null){
           img = createImage(this.getSize().width, this.getSize().height);
           doubleG = img.getGraphics();
       }

       
       paint(doubleG);
       g.drawImage(img,0,0,this);
    }
    
    @Override
    public void paint(Graphics g) {
      
       
        if(est == EstadoJogo.Menu){
            g.drawImage(MenuImg, 0, 0, this);
            if(buttonFlag)g.drawImage(BotaoMenuImg,213,263,this);
        }else
        if(est == EstadoJogo.Rodando || est == EstadoJogo.Pergunta){
           g.drawImage(ScenarioGame,0,0,this);
           g.setFont(new Font("Calibri", Font.PLAIN, 20)); 
           g.setColor(Color.BLACK);
           if((contador.getTimeSeconds()%60<10)){
               g.drawString(contador.getTimeMinutes() + " : " + 0 +contador.getTimeSeconds()%60, 530, 30);
           }else
               g.drawString(contador.getTimeMinutes() + " : " + contador.getTimeSeconds()%60, 530, 30);
           g.drawString(MazeGame.getAdm().getQtdAcertos()*MazeGame.getAdm().getPontuacao()/MazeGame.getAdm().getQtdperguntas() + "/" + MazeGame.getAdm().getPontuacao(),165,33);
            for(int i  = 0;i<n;i++)
                for(int j = 0;j<n;j++)
                    for(int k = 0;k<2;k++){
                        int sumx = 562%n + 1;
                        int sumy = 370%n + 1;
                        if(i!=n-1)sumx = 0;
                        if(j!=n-1)sumy = 0;
                        if(MazeGame.getMaze().getMaze(i, j, k) == true)
                            if(k == 0)
                                g.fillRect(37 + i* (562/n) - Dp/2 , 70 + j*(370/n) , Dp,  (370/n) + sumy);
                            else
                                g.fillRect(37 + i*(562/n),70 + j*(370/n) - Dp/2, (562/n) + sumx , Dp); // horizontal
                    }
            
            for(int i = 0;i<MazeGame.getAdm().getQtdperguntas();i++){
                if(MazeGame.getAdm().getP().get(i).isRespondeu() == false){
                    g.drawImage(Star, 37 + MazeGame.getPosPergunta().get(i).first* (562/n) + Dp/2, 70 + MazeGame.getPosPergunta().get(i).second*(370/n), 370/n - Dp, 370/n - Dp, this);
                }
            }
            int xJ = MazeGame.getPlayer().getX();
            int yJ = MazeGame.getPlayer().getY();
            int eJ = MazeGame.getPlayer().getEst().valor;
            BufferedImage bimage = (BufferedImage) PersonSprite;
          
            g.drawImage(bimage.getSubimage(31*eJ, 0, 30, 38),  37 + xJ* (562/n) + Dp/2, 70 + yJ*(370/n), 370/n - Dp, 370/n - Dp, this);
            if(est == EstadoJogo.Pergunta)
                g.drawImage(WaitQuestion,0,0,this);
        }
        else
            
        if(est == EstadoJogo.Fim){
            g.drawImage(Fim,0,0,this);
            g.setFont(new Font("Calibri", Font.PLAIN, 30)); 
            g.setColor(Color.WHITE);
            g.drawString("Pontuacao: " + MazeGame.getAdm().getQtdAcertos()*MazeGame.getAdm().getPontuacao()/MazeGame.getAdm().getQtdperguntas(),200, 280);
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       
           
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       if(est == EstadoJogo.Rodando){
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                MazeGame.getPlayer().setEst(EstadoJogador.up);
                MazeGame.moveUp();
            }
            if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                MazeGame.getPlayer().setEst(EstadoJogador.left);
                MazeGame.moveLeft();
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                MazeGame.getPlayer().setEst(EstadoJogador.down);
                MazeGame.moveDown();
            }
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                MazeGame.getPlayer().setEst(EstadoJogador.right);
                MazeGame.moveRight();
            }
       }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
     //    key[ke.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(est == EstadoJogo.Menu){
            if(buttonFlag){
                est = EstadoJogo.Rodando;
                contador.start(MazeGame.getAdm().getTempo());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if(est == EstadoJogo.Menu){
            if(mx>=210 && mx<=415 && my>=263 && my<=330)
                buttonFlag = true;
            else 
                buttonFlag = false;
        }
    }
    


}
