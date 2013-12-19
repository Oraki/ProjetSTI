
public class Grille extends javax.swing.JFrame {
	
    private final CasePanel[][] tabCP;
    private final Sudoku sudo;

    public Grille(Sudoku sudo) {
        tabCP = new CasePanel[9][9];
        this.sudo = sudo;
        initComponents();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                tabCP[i][j] = new CasePanel(sudo, i, j);
                tabCP[i][j].setBounds(i * 42 + (i / 3) * 3 + 3, j * 42
                        + (j / 3) * 3 + 3, 42, 42);
                jeuPanel.add(tabCP[i][j]);
            }
        }
    }

    public void ajouterMessage(String s) {
        if (!s.equals("\n")) {
            texteTuteur.append("\nTuteur :\n   " + s);
        } else {
            texteTuteur.append(s);
        }
    }

    public void effacerMessages() {
        texteTuteur.setText("");
    }

    public void erreurHypo(int ligne, int col, int valeur, boolean err) {
        tabCP[ligne][col].setErreurHypo(valeur, err);
    }

    public void erreurValeur(int ligne, int col, boolean err) {
        tabCP[ligne][col].setErreur(err);
    }

    public void setPuzzle(int[][] puzzle) {
        for (int i = 0; i < puzzle.length; ++i) {
            for (int j = 0; j < puzzle[i].length; ++j) {
                if (puzzle[i][j] != 0) {
                    tabCP[i][j].setValeur(puzzle[i][j], true);
                }
            }
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

        jeuPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texteTuteur = new javax.swing.JTextArea();
        indiceBouton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jeuPanel.setMinimumSize(new java.awt.Dimension(390, 390));

        javax.swing.GroupLayout jeuPanelLayout = new javax.swing.GroupLayout(jeuPanel);
        jeuPanel.setLayout(jeuPanelLayout);
        jeuPanelLayout.setHorizontalGroup(
            jeuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jeuPanelLayout.setVerticalGroup(
            jeuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jeuPanel, java.awt.BorderLayout.CENTER);

        texteTuteur.setEditable(false);
        texteTuteur.setColumns(20);
        texteTuteur.setRows(5);
        texteTuteur.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(texteTuteur);

        indiceBouton.setText("indice");
        indiceBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indiceBoutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indiceBouton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(indiceBouton)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void indiceBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indiceBoutonActionPerformed
        sudo.afficherIndice();
    }//GEN-LAST:event_indiceBoutonActionPerformed

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
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Grille g = new Grille(null);
                g.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton indiceBouton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jeuPanel;
    private javax.swing.JTextArea texteTuteur;
    // End of variables declaration//GEN-END:variables
}
