/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Vector;

/**
 *
 * @author Fulvio
 */
public class AdmGame {
    private int perguntaAtual = 0;
    private Vector<Pergunta> P = new Vector<>();
    private Leitura le = new Leitura("config.txt");;
    private int dimensao;
    private int tempo;
    private int pontuacao;
    

    public int getPerguntaAtual() {
        return perguntaAtual;
    }

    public void setPerguntaAtual(int perguntaAtual) {
        this.perguntaAtual = perguntaAtual;
    }

    public int getQtdperguntas() {
        return qtdperguntas;
    }

    public void setQtdperguntas(int qtdperguntas) {
        this.qtdperguntas = qtdperguntas;
    }
    int qtdperguntas;
    public AdmGame(){
        dimensao = le.nextInt();
        tempo = le.nextInt();
        pontuacao = le.nextInt();
        qtdperguntas = le.nextInt();
        for(int i = 0;i<qtdperguntas;i++){
            String p, q1,q2,q3,q4,q5;
            p = le.proximaLinha();
            q1 = le.proximaLinha();
            q2 = le.proximaLinha();
            q3 = le.proximaLinha();
            q4 = le.proximaLinha();
            q5 = le.proximaLinha();
            int r = le.nextInt();
            P.add(new MultiplaEscolha(p, q1, q2, q3, q4, q5, r));
        }
       
    }
    
    public int getQtdAcertos(){
        int qtd = 0;
        for(int i = 0;i<P.size();i++)
            if(P.get(i).isAcertou())qtd++;
        return qtd;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    
    public int getQtdPerguntasRespondidas(){
        int qtd = 0;
        for(int i = 0;i<P.size();i++)
            if(P.get(i).isRespondeu())qtd++;
        return qtd;
    }
    
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    public Vector<Pergunta> getP() {
        return P;
    }

    public void setP(Vector<Pergunta> P) {
        this.P = P;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao =dimensao;
    }
    
}
