/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ferramenta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.*;

/**
 *
 * @author Fulvio
 */
public class Ferramenta extends javax.swing.JFrame {

    /**
     * Creates new form Ferramenta
     */
    private String[] Disponiveis = new String[0];
    
    private static Object resizeArray (Object oldArray, int newSize) {
    int oldSize = java.lang.reflect.Array.getLength(oldArray);
    Class elementType = oldArray.getClass().getComponentType();
    Object newArray = java.lang.reflect.Array.newInstance(
          elementType, newSize);
    int preserveLength = Math.min(oldSize, newSize);
    if (preserveLength > 0)
       System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
    return newArray; }
    
    public Ferramenta() {
        initComponents();
       
    
        File dir = new File("./Games");
        File[] filesList = dir.listFiles();
        for (File file : filesList) {
            if (file.isDirectory()) {
                String fileName = file.getName();
              /*  if(fileName.length()>6){
                    if(fileName.substring(fileName.length()-6).equals(".class")){
                        String aux = fileName.substring(0,fileName.length()-6);
                        boolean flag = false;
                        for(int i = 0;i<aux.length();i++){
                            if(aux.charAt(i) == '$')flag = true;
                        }
                        if(flag)continue;
                    }
                }*/
                Disponiveis = (String[])resizeArray(Disponiveis,Disponiveis.length+1);
                Disponiveis[Disponiveis.length-1] = fileName;
            }
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings =  Disponiveis;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }

    Ferramenta(String ferramenta) {
        super(ferramenta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Selecionar Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gerar Pacote Scorm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Selecione Algum Jogo");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setText("Ao Lado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)))
                .addGap(105, 105, 105))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Folder = "./Games/"+jList1.getSelectedValue()+"/Configuracao";
        File classFolder = new File(Folder);
        String S = "Config"+jList1.getSelectedValue();
      
         try {
           URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { classFolder.toURI().toURL() });
           Class<?> cls = Class.forName(S, true, classLoader);
           jPanel2.removeAll();
           jPanel2.setLayout(new java.awt.BorderLayout());
           jPanel2.add((JPanel)cls.newInstance());
           jPanel2.revalidate();
           jPanel2.repaint();
         } catch (Exception e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
public static void addFilesToExistingZip(File zipFile, File[] files,String novoNome) throws IOException {

        Files.copy(zipFile.toPath(), new File(novoNome).toPath(),REPLACE_EXISTING);
        zipFile = new File(novoNome);
        // get a temp file
	File tempFile = File.createTempFile(zipFile.getName(), null);
               // delete it, otherwise you cannot rename your existing zip to it.
	tempFile.delete();
        
	boolean renameOk=zipFile.renameTo(tempFile);
	if (!renameOk)
	{
		throw new RuntimeException("could not rename the file "+zipFile.getAbsolutePath()+" to "+tempFile.getAbsolutePath());
	}
	byte[] buf = new byte[1024];
	
	ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
	ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
	
	ZipEntry entry = zin.getNextEntry();
	while (entry != null) {
		String name = entry.getName();
		boolean notInFiles = true;
		for (File f : files) {
			if (f.getName().equals(name)) {
				notInFiles = false;
				break;
			}
		}
		if (notInFiles) {
			// Add ZIP entry to output stream.
			out.putNextEntry(new ZipEntry(name));
			// Transfer bytes from the ZIP file to the output file
			int len;
			while ((len = zin.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		}
		entry = zin.getNextEntry();
	}
	// Close the streams		
	zin.close();
	// Compress the files
	for (int i = 0; i < files.length; i++) {
		InputStream in = new FileInputStream(files[i]);
		// Add ZIP entry to output stream.
		out.putNextEntry(new ZipEntry("Game/"+files[i].getName()));
		// Transfer bytes from the file to the ZIP file
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		// Complete the entry
		out.closeEntry();
		in.close();
	}
	// Complete the ZIP file
	out.close();
	tempFile.delete();
}

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File[] aux = new File[1];
        aux[0] = new File("config.txt");
        try {
            addFilesToExistingZip(new File("./Games/"+jList1.getSelectedValue()+"/Jogo/"+jList1.getSelectedValue()+".jar"),aux,"./Games/"+jList1.getSelectedValue()+"/Jogo/"+"Game.jar" );
        } catch (IOException ex) {
            Logger.getLogger(Ferramenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        aux[0] = new File("./Games/"+jList1.getSelectedValue()+"/Jogo/Game.jar");
        try {
            addFilesToExistingZip(new File("ScormModel/ScormPack.zip"),aux,jList1.getSelectedValue()+".zip");
        } catch (IOException ex) {
            Logger.getLogger(Ferramenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ferramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ferramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ferramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ferramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ferramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}