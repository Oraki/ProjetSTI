
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CasePanel extends javax.swing.JPanel {

    private final int ligne;
    private final int col;
    private final boolean[] possi;
    private final boolean[] erreurPossi;
    private boolean erreur;
    private boolean isPuzzle;
    private Sudoku main;

    public CasePanel(Sudoku sudo, int ligne, int col) {
        this.ligne = ligne;
        this.main = sudo;
        this.col = col;
        possi = new boolean[9];
        for (int i = 0; i < possi.length; ++i) {
            possi[i] = true;
        }
        erreurPossi = new boolean[9];
        initComponents();
        soluPanel.setVisible(false);
        possPanel.setVisible(true);
    }

    public void setErreurHypo(int valeur, boolean err) {
        erreurPossi[valeur] = err;
        updatePoss();
    }

    private void updatePoss() {
        if (possi[0]) {
            poss1Label.setForeground(Color.black);
        } else {
            poss1Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[0]) {
            poss1Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss1Panel.setBackground(Color.WHITE);
        }
        if (possi[1]) {
            poss2Label.setForeground(Color.black);
        } else {
            poss2Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[1]) {
            poss2Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss2Panel.setBackground(Color.WHITE);
        }
        if (possi[2]) {
            poss3Label.setForeground(Color.black);
        } else {
            poss3Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[2]) {
            poss3Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss3Panel.setBackground(Color.WHITE);
        }
        if (possi[3]) {
            poss4Label.setForeground(Color.black);
        } else {
            poss4Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[3]) {
            poss4Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss4Panel.setBackground(Color.WHITE);
        }
        if (possi[4]) {
            poss5Label.setForeground(Color.black);
        } else {
            poss5Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[4]) {
            poss5Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss5Panel.setBackground(Color.WHITE);
        }
        if (possi[5]) {
            poss6Label.setForeground(Color.black);
        } else {
            poss6Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[5]) {
            poss6Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss6Panel.setBackground(Color.WHITE);
        }
        if (possi[6]) {
            poss7Label.setForeground(Color.black);
        } else {
            poss7Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[6]) {
            poss7Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss7Panel.setBackground(Color.WHITE);
        }
        if (possi[7]) {
            poss8Label.setForeground(Color.black);
        } else {
            poss8Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[7]) {
            poss8Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss8Panel.setBackground(Color.WHITE);
        }
        if (possi[8]) {
            poss9Label.setForeground(Color.black);
        } else {
            poss9Label.setForeground(new Color(204, 204, 204));
        }
        if (erreurPossi[8]) {
            poss9Panel.setBackground(new Color(255, 102, 102));
        } else {
            poss9Panel.setBackground(Color.WHITE);
        }
    }

    private void setValeur(int v) {
        main.JouerCoup(ligne, col, v);
        setValeur(v, false);
    }

    public void setValeur(int v, boolean puzzle) {
        isPuzzle = puzzle;
        soluLabel.setText(v + "");
        if (puzzle) {
            soluLabel.setForeground(Color.blue);
        } else {
            soluLabel.setForeground(Color.BLACK);
        }
        soluPanel.setVisible(true);
        possPanel.setVisible(false);
    }

    private void retirerValeur() {
        if (!isPuzzle) {
            main.RetirerCoup(ligne, col, Integer.parseInt(soluLabel.getText()));
            soluPanel.setVisible(false);
            possPanel.setVisible(true);
        }
    }

    private void retirerPoss(int i) {
        if (possi[i - 1]) {
            main.RetirerHypothese(ligne, col, i);
        } else {
            main.RemettreHypothese(ligne, col, i);
        }
        possi[i - 1] = !possi[i - 1];
        updatePoss();
    }

    public void setErreur(boolean e) {
        erreur = e;
        if (erreur) {
            soluPanel.setBackground(new Color(255, 102, 102));
        } else {
            soluPanel.setBackground(Color.BLACK);
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

        soluPanel = new javax.swing.JPanel();
        soluLabel = new javax.swing.JLabel();
        possPanel = new javax.swing.JPanel();
        poss1Panel = new javax.swing.JPanel();
        poss1Label = new javax.swing.JLabel();
        poss2Panel = new javax.swing.JPanel();
        poss2Label = new javax.swing.JLabel();
        poss3Panel = new javax.swing.JPanel();
        poss3Label = new javax.swing.JLabel();
        poss4Panel = new javax.swing.JPanel();
        poss4Label = new javax.swing.JLabel();
        poss5Panel = new javax.swing.JPanel();
        poss5Label = new javax.swing.JLabel();
        poss6Panel = new javax.swing.JPanel();
        poss6Label = new javax.swing.JLabel();
        poss7Panel = new javax.swing.JPanel();
        poss7Label = new javax.swing.JLabel();
        poss8Panel = new javax.swing.JPanel();
        poss8Label = new javax.swing.JLabel();
        poss9Panel = new javax.swing.JPanel();
        poss9Label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(42, 42));
        setMinimumSize(new java.awt.Dimension(42, 42));
        setPreferredSize(new java.awt.Dimension(42, 42));
        setLayout(new javax.swing.OverlayLayout(this));

        soluPanel.setBackground(new java.awt.Color(255, 255, 255));
        soluPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        soluPanel.setMaximumSize(new java.awt.Dimension(42, 42));
        soluPanel.setMinimumSize(new java.awt.Dimension(42, 42));
        soluPanel.setPreferredSize(new java.awt.Dimension(42, 42));

        soluLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        soluLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soluLabel.setText("1");
        soluLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soluLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout soluPanelLayout = new javax.swing.GroupLayout(soluPanel);
        soluPanel.setLayout(soluPanelLayout);
        soluPanelLayout.setHorizontalGroup(
            soluPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(soluPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(soluLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        soluPanelLayout.setVerticalGroup(
            soluPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(soluPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(soluLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        add(soluPanel);

        possPanel.setBackground(new java.awt.Color(255, 255, 255));
        possPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        possPanel.setMaximumSize(new java.awt.Dimension(42, 42));
        possPanel.setMinimumSize(new java.awt.Dimension(42, 42));
        possPanel.setPreferredSize(new java.awt.Dimension(42, 42));
        possPanel.setLayout(new java.awt.GridLayout(3, 3));

        poss1Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss1Panel.setLayout(new java.awt.BorderLayout());

        poss1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss1Label.setText("1");
        poss1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss1LabelMouseClicked(evt);
            }
        });
        poss1Panel.add(poss1Label, java.awt.BorderLayout.CENTER);

        possPanel.add(poss1Panel);

        poss2Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss2Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss2Label.setText("2");
        poss2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss2LabelMouseClicked(evt);
            }
        });
        poss2Panel.add(poss2Label);

        possPanel.add(poss2Panel);

        poss3Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss3Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss3Label.setText("3");
        poss3Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss3LabelMouseClicked(evt);
            }
        });
        poss3Panel.add(poss3Label);

        possPanel.add(poss3Panel);

        poss4Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss4Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss4Label.setText("4");
        poss4Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss4LabelMouseClicked(evt);
            }
        });
        poss4Panel.add(poss4Label);

        possPanel.add(poss4Panel);

        poss5Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss5Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss5Label.setText("5");
        poss5Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss5LabelMouseClicked(evt);
            }
        });
        poss5Panel.add(poss5Label);

        possPanel.add(poss5Panel);

        poss6Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss6Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss6Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss6Label.setText("6");
        poss6Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss6LabelMouseClicked(evt);
            }
        });
        poss6Panel.add(poss6Label);

        possPanel.add(poss6Panel);

        poss7Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss7Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss7Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss7Label.setText("7");
        poss7Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss7LabelMouseClicked(evt);
            }
        });
        poss7Panel.add(poss7Label);

        possPanel.add(poss7Panel);

        poss8Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss8Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss8Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss8Label.setText("8");
        poss8Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss8LabelMouseClicked(evt);
            }
        });
        poss8Panel.add(poss8Label);

        possPanel.add(poss8Panel);

        poss9Panel.setBackground(new java.awt.Color(255, 255, 255));
        poss9Panel.setLayout(new java.awt.GridLayout(1, 0));

        poss9Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poss9Label.setText("9");
        poss9Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poss9LabelMouseClicked(evt);
            }
        });
        poss9Panel.add(poss9Label);

        possPanel.add(poss9Panel);

        add(possPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void poss4LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss4LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss4LabelMouseClicked

    private void poss1LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss1LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss1LabelMouseClicked

    private void poss2LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss2LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss2LabelMouseClicked

    private void poss3LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss3LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss3LabelMouseClicked

    private void poss5LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss5LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss5LabelMouseClicked

    private void poss6LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss6LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss6LabelMouseClicked

    private void poss7LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss7LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss7LabelMouseClicked

    private void poss8LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss8LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss8LabelMouseClicked

    private void poss9LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poss9LabelMouseClicked
        int i = Integer.parseInt(((JLabel) evt.getSource()).getText());
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setValeur(i);
        } else if (SwingUtilities.isRightMouseButton(evt)) {
            retirerPoss(i);
        }
    }//GEN-LAST:event_poss9LabelMouseClicked

    private void soluLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soluLabelMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            retirerValeur();
        }
    }//GEN-LAST:event_soluLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel poss1Label;
    private javax.swing.JPanel poss1Panel;
    private javax.swing.JLabel poss2Label;
    private javax.swing.JPanel poss2Panel;
    private javax.swing.JLabel poss3Label;
    private javax.swing.JPanel poss3Panel;
    private javax.swing.JLabel poss4Label;
    private javax.swing.JPanel poss4Panel;
    private javax.swing.JLabel poss5Label;
    private javax.swing.JPanel poss5Panel;
    private javax.swing.JLabel poss6Label;
    private javax.swing.JPanel poss6Panel;
    private javax.swing.JLabel poss7Label;
    private javax.swing.JPanel poss7Panel;
    private javax.swing.JLabel poss8Label;
    private javax.swing.JPanel poss8Panel;
    private javax.swing.JLabel poss9Label;
    private javax.swing.JPanel poss9Panel;
    private javax.swing.JPanel possPanel;
    private javax.swing.JLabel soluLabel;
    private javax.swing.JPanel soluPanel;
    // End of variables declaration//GEN-END:variables
}
