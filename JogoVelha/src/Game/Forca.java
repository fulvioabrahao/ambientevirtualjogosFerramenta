package Game;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Fúlvio
 */
public final class Forca extends JPanel {

    private String[] palavra;
    private String[] perguntas;
    private String palavraUsr;
    private int vidaAtual;
    private int vidasUsadas = 0;
    private int qtdRodadas;
    private int rodadaAtual = -1;
    private JButton[] letras = new JButton[26];
    private ImageIcon img;
    private App referencia;

    public void terminou() {
        if (palavra[rodadaAtual].equals(palavraUsr) || vidaAtual == 0) {
            jButton1.setEnabled(true);
            if (qtdRodadas - 1 == rodadaAtual) {
                jButton1.setText("Pontucao");
            }
            for (Component aux : jPanel2.getComponents()) {
                aux.setEnabled(false);
            }
        }
    }

    public void proximaRodada() {
        rodadaAtual++;
        jButton1.setEnabled(false);
        if (rodadaAtual >= qtdRodadas) {
            LabelPergunta.setText("Pontuação:");
            LabelPalavra.setText("" + getPontos());
            MoodleUtilities.enviaPontos(getPontos(), referencia);
        } else {
            LabelPergunta.setText(perguntas[rodadaAtual]);
            vidaAtual = 6;
            palavraUsr = new String();
            String auxP = palavra[rodadaAtual].toUpperCase();
            palavra[rodadaAtual] = new String();
            for (int i = 0; i < auxP.length(); i++) {
                palavra[rodadaAtual] += auxP.charAt(i);
                palavra[rodadaAtual] += ' ';
                palavra[rodadaAtual] += ' ';
                if (auxP.charAt(i) != ' ') {
                    palavraUsr += '_';
                } else {
                    palavraUsr += ' ';
                }
                palavraUsr += ' ';
                palavraUsr += ' ';
            }

            jPanel2.removeAll();
            LabelPalavra.setText(palavraUsr);
            for (int i = 0; i < 26; i++) {
                letras[i] = new JButton("" + ((char) ('A' + i)));
                letras[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton) e.getSource();
                        char jog = (char) (b.getText().charAt(0));
                        int k = (int) (jog - 'A');
                        letras[k].setEnabled(false);
                        jogada(jog);
                        jPanel1.repaint();
                    }
                });

                jPanel2.add(letras[i]);
            }
        }
        repaint();
    }

    public Forca(App ref) {
        referencia = ref;
        initComponents();

        try {
            img = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("forca.png")));
            InputStream is = getClass().getResourceAsStream("forca.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String strLine = br.readLine();
                qtdRodadas = Integer.parseInt(strLine);
                palavra = new String[qtdRodadas];
                perguntas = new String[qtdRodadas];
                for (int i = 0; i < qtdRodadas; i++) {
                    strLine = br.readLine();
                    perguntas[i] = strLine;
                    strLine = br.readLine();
                    palavra[i] = strLine;
                }
            }
        } catch (IOException | NumberFormatException e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            jButton1.setText(e.getMessage());
        }
        proximaRodada();
    }

    public void jogada(char letra) {
        boolean ok = false;
        for (int i = 0; i < palavra[rodadaAtual].length(); i++) {
            if (palavra[rodadaAtual].charAt(i) == letra) {
                StringBuilder aux = new StringBuilder(palavraUsr);
                aux.setCharAt(i, letra);
                palavraUsr = aux.toString();
                ok = true;
            }
        }
        if (!ok) {
            vidaAtual--;
            vidasUsadas++;
        }
        LabelPalavra.setText(palavraUsr);

        terminou();
    }

    private int getPontos() {
        if (qtdRodadas == 0) {
            return 100;
        }
        return ((qtdRodadas * 6 - vidasUsadas) * 100) / (qtdRodadas * 6);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        LabelPalavra = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LabelPergunta = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 360));
        setPreferredSize(new java.awt.Dimension(500, 360));

        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(9, 3));

        LabelPalavra.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LabelPalavra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelPalavra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1 = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                img.paintIcon(jPanel1, g, -((6 - vidaAtual)%(7))*132, 0);
            }
        };

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        LabelPergunta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelPergunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Prox Rodada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(LabelPalavra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LabelPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        proximaRodada();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPalavra;
    private javax.swing.JLabel LabelPergunta;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
