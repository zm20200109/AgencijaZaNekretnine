/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.forms;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.controller.Controller;
import ui.forms.tables.ModelTabeleStatistikaAgenata;

/**
 *
 * @author Korisnik
 */
public class StatistikaAgenata extends javax.swing.JPanel {

    /**
     * Creates new form StatistikaAgenata
     */
    public StatistikaAgenata() {
        try {
            initComponents();
            popuniPodatke();
        } catch (Exception ex) {
            Logger.getLogger(StatistikaAgenata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatistikaAgenata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNazad = new javax.swing.JButton();

        tblStatistikaAgenata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStatistikaAgenata);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel1.setText("STATISTIKA USPEHA AGENATA");

        btnNazad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnNazad)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnNazad)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        this.getTopLevelAncestor().setVisible(false);
    }//GEN-LAST:event_btnNazadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNazad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStatistikaAgenata;
    // End of variables declaration//GEN-END:variables

    private void popuniPodatke() throws Exception {
        List<domain.StatistikaAgenata> listaAgenata = Controller.getInstance().getStatistikaAgenata();
        ModelTabeleStatistikaAgenata mtsa = new ModelTabeleStatistikaAgenata(listaAgenata);
        tblStatistikaAgenata.setModel(mtsa);
    }
}
