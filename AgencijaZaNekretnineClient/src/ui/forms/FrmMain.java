/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.forms;

import domain.Menadzer;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.controller.Controller;


/**
 *
 * @author Korisnik
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    private Menadzer menadzer;
    
    public FrmMain(Menadzer menadzer) {
        initComponents();
        this.menadzer = menadzer;
        setTitle("Dobrodosli, "+menadzer.getImeMenadzera()+" "+menadzer.getPrezimeMenadzera());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

    
        // Add btnLogOut to the frame
        add(btnLogOut);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogOut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jMenu1.setText("Glavni meni");

        jMenuItem1.setText("Kreiranje agenta za nekretnine");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Kreiranje tipa klijenta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Kreiranje novog klijenta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Pretraga agenata");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Pretraga klijenata");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Kreiranje angažovanja");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          try {
            JDialog dialog=new JDialog(this, "Novi agent za nekretnine", true);
            JPanel panel=new FrmNoviAgent();
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Person", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         try {
            JDialog dialog=new JDialog(this, "Novi tip klijenta.", true);
            JPanel panel=new frmNoviTipKlijenta();
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Person", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
          try {
            JDialog dialog=new JDialog(this, "Novi klijent.", true);
            JPanel panel=new FrmNoviKlijent();
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Person", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
           try {
            JDialog dialog=new JDialog(this, "Pretraga agenata.", true);
            JPanel panel=new PretragaAgenta();
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Person", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
          try {
            JDialog dialog=new JDialog(this, "Pretraga klijenata.", true);
            JPanel panel=new PretragaKlijenta();
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Person", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
            try {
            JDialog dialog=new JDialog(this, "Kreiranje angažovanja.", true);
            JPanel panel=new FrmCreateAngažovanje(this.menadzer);
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n"+ex.getMessage(), "New Angažovanje", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        try {
            // TODO add your handling code here:
            boolean signal = Controller.getInstance().logOutMenadzer(this.menadzer);
            if(signal){
                JOptionPane.showMessageDialog(this,"Uspešno ste se izlogovali!", "Log out", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Niste se uspešno izlogovali!", "Log out", JOptionPane.WARNING_MESSAGE);
            
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}