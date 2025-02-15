/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.forms;

import domain.Agent;
import javax.swing.JOptionPane;
import ui.controller.Controller;


/**
 *
 * @author Korisnik
 */
public class FrmNoviAgent extends javax.swing.JPanel {

    /**
     * Creates new form FrmNoviAgent
     */
    public FrmNoviAgent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRedniBrojURegistruPosrednika = new javax.swing.JTextField();
        txtImeAgenta = new javax.swing.JTextField();
        txtPrezimeAgenta = new javax.swing.JTextField();
        txtAdresaAgenta = new javax.swing.JTextField();
        txtUspesnostRealizacije = new javax.swing.JTextField();
        txtBrojDodeljenihKlijenata = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnPonisti = new javax.swing.JButton();

        jLabel1.setText("Redni broj u registru posrednika");

        jLabel2.setText("Ime agenta: ");

        jLabel3.setText("Prezime agenta:");

        jLabel4.setText("Adresa agenta:");

        jLabel5.setText("Uspešnost realizacije: ");

        jLabel6.setText("Broj dodeljenih klijenata: ");

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnPonisti.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnPonisti.setText("Poništi");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRedniBrojURegistruPosrednika)
                    .addComponent(txtImeAgenta)
                    .addComponent(txtPrezimeAgenta)
                    .addComponent(txtAdresaAgenta)
                    .addComponent(txtUspesnostRealizacije)
                    .addComponent(txtBrojDodeljenihKlijenata, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnSacuvaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(btnPonisti)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtRedniBrojURegistruPosrednika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtImeAgenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPrezimeAgenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtAdresaAgenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtUspesnostRealizacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtBrojDodeljenihKlijenata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnPonisti))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
       try{    
        int rBroj= Integer.parseInt(txtRedniBrojURegistruPosrednika.getText());
        String ime = txtImeAgenta.getText();
        String prezime = txtPrezimeAgenta.getText();
        String adresa = txtAdresaAgenta.getText();
        double uspesnost = Double.parseDouble(txtUspesnostRealizacije.getText());        
        int brKlijenata = Integer.parseInt(txtBrojDodeljenihKlijenata.getText());
        Agent agent = new Agent(rBroj, ime, prezime, adresa, uspesnost, brKlijenata);
        boolean signal = Controller.getInstance().createAgent(agent);
        if (signal == true){
           JOptionPane.showMessageDialog(this, "Sistem je zapamtio agenta.", "Kreiranje agenta", JOptionPane.INFORMATION_MESSAGE);
           this.getTopLevelAncestor().setVisible(false);
        }else{
           JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti agenta. ", "Kreiranje agenta", JOptionPane.WARNING_MESSAGE);
           this.getTopLevelAncestor().setVisible(false);
        }
 
       }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti agenta!\n"+ex.getMessage(), "Create Person", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        // TODO add your handling code here:
        this.getTopLevelAncestor().setVisible(false);

    }//GEN-LAST:event_btnPonistiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAdresaAgenta;
    private javax.swing.JTextField txtBrojDodeljenihKlijenata;
    private javax.swing.JTextField txtImeAgenta;
    private javax.swing.JTextField txtPrezimeAgenta;
    private javax.swing.JTextField txtRedniBrojURegistruPosrednika;
    private javax.swing.JTextField txtUspesnostRealizacije;
    // End of variables declaration//GEN-END:variables
}
