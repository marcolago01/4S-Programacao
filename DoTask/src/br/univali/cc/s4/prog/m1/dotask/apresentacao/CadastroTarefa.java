/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.cc.s4.prog.m1.dotask.apresentacao;

import br.univali.cc.s4.prog.m1.dotask.persistencia.GerenciadorDadosMYSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class CadastroTarefa extends javax.swing.JFrame {

    /**
     * Creates new form CadastroTarefa
     */
    public CadastroTarefa() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        botaoCadatrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
                String tag;
                boolean lembrar;
                String email;

                Date javaTimeStramp = new Date();
                LocalDateTime getTimestramp = LocalDateTime.now();
                Calendar timeInMillis = Calendar.getInstance();
                
                nome = campoTextoNome.getText();
                tag = campoTextoTag.getText();
                email = campoTextoEmail.getText();
                lembrar = checkboxLembrar.isSelected();
                
                try{
                    getTimestramp = coletorDataTempo.getDateTimePermissive();
                    timeInMillis.set(getTimestramp.getYear(), getTimestramp.getMonthValue()-1, getTimestramp.getDayOfMonth(), getTimestramp.getHour(), getTimestramp.getMinute(), getTimestramp.getSecond());
                    javaTimeStramp = new Date(timeInMillis.getTimeInMillis());
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(rootPane, "Selecione uma data válida", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                GerenciadorDadosMYSQL gerenciadorDadosMYSQL = new GerenciadorDadosMYSQL();
                
                try{
                    gerenciadorDadosMYSQL.cadastrarTarefa(nome, lembrar, javaTimeStramp, tag, email);
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(rootPane, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso", "Informativo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        painelSuperior = new javax.swing.JPanel();
        rotuloNome = new javax.swing.JLabel();
        rotuloLembrarEm = new javax.swing.JLabel();
        rotuloTag = new javax.swing.JLabel();
        rotuloEmail = new javax.swing.JLabel();
        campoTextoNome = new javax.swing.JTextField();
        checkboxLembrar = new javax.swing.JCheckBox();
        coletorDataTempo = new com.github.lgooddatepicker.components.DateTimePicker();
        campoTextoEmail = new javax.swing.JTextField();
        campoTextoTag = new javax.swing.JTextField();
        painelInferior = new javax.swing.JPanel();
        preenchedorLateralInferior = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(2000, 32767));
        botaoCadatrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tarefa");

        painelSuperior.setPreferredSize(new java.awt.Dimension(377, 170));
        painelSuperior.setLayout(new java.awt.GridBagLayout());

        rotuloNome.setText("Nome: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        painelSuperior.add(rotuloNome, gridBagConstraints);

        rotuloLembrarEm.setText("Lembrar em: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        painelSuperior.add(rotuloLembrarEm, gridBagConstraints);

        rotuloTag.setText("Tag:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        painelSuperior.add(rotuloTag, gridBagConstraints);

        rotuloEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        painelSuperior.add(rotuloEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 244;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 50);
        painelSuperior.add(campoTextoNome, gridBagConstraints);

        checkboxLembrar.setText("Lembrar");
        checkboxLembrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxLembrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 0, 0);
        painelSuperior.add(checkboxLembrar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 0, 50);
        painelSuperior.add(coletorDataTempo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 244;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 23, 50);
        painelSuperior.add(campoTextoEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 244;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 50);
        painelSuperior.add(campoTextoTag, gridBagConstraints);

        getContentPane().add(painelSuperior, java.awt.BorderLayout.NORTH);

        painelInferior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelInferior.setLayout(new javax.swing.BoxLayout(painelInferior, javax.swing.BoxLayout.LINE_AXIS));
        painelInferior.add(preenchedorLateralInferior);

        botaoCadatrar.setText("Cadastrar");
        painelInferior.add(botaoCadatrar);

        botaoCancelar.setText("Cancelar");
        painelInferior.add(botaoCancelar);

        getContentPane().add(painelInferior, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxLembrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxLembrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxLembrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadatrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JTextField campoTextoEmail;
    private javax.swing.JTextField campoTextoNome;
    private javax.swing.JTextField campoTextoTag;
    private javax.swing.JCheckBox checkboxLembrar;
    private com.github.lgooddatepicker.components.DateTimePicker coletorDataTempo;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.Box.Filler preenchedorLateralInferior;
    private javax.swing.JLabel rotuloEmail;
    private javax.swing.JLabel rotuloLembrarEm;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloTag;
    // End of variables declaration//GEN-END:variables
}
