/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.*;

/**
 *
 * @author photonicDog
 */
public class GUI extends javax.swing.JFrame {

    /** Creates new form GUI */
    public GUI() {
        initComponents();
    }

    ArrayList validGrades = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
    ArrayList validColourTypes = new ArrayList<>(Arrays.asList("No colour","One colour","Two colour"));
    boolean initInner = true;
    
    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradeButtons = new javax.swing.ButtonGroup();
        colourTypeButtons = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        lengthLabel = new javax.swing.JLabel();
        diameterLabel = new javax.swing.JLabel();
        gradeLabel = new javax.swing.JLabel();
        colourLabel = new javax.swing.JLabel();
        propLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        lengthField = new javax.swing.JTextField();
        diameterField = new javax.swing.JTextField();
        lengthNote = new javax.swing.JLabel();
        diameterNote = new javax.swing.JLabel();
        gradeOneButton = new javax.swing.JRadioButton();
        gradeTwoButton = new javax.swing.JRadioButton();
        gradeThreeButton = new javax.swing.JRadioButton();
        gradeFourButton = new javax.swing.JRadioButton();
        gradeFiveButton = new javax.swing.JRadioButton();
        colourNoneRadio = new javax.swing.JRadioButton();
        colourOneRadio = new javax.swing.JRadioButton();
        colourTwoRadio = new javax.swing.JRadioButton();
        innerCheckBox = new javax.swing.JCheckBox();
        outerCheckBox = new javax.swing.JCheckBox();
        chemCheckBox = new javax.swing.JCheckBox();
        quantityField = new javax.swing.JTextField();
        orderButton = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        resultsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(557, 400));

        MainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pipe ordering system"));
        MainPanel.setFont(new java.awt.Font("Dialog", 1, 24));
        MainPanel.setPreferredSize(new java.awt.Dimension(557, 400));

        lengthLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lengthLabel.setText("Length");

        diameterLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        diameterLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        diameterLabel.setText("Diameter");

        gradeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gradeLabel.setText("Grade");

        colourLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        colourLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        colourLabel.setText("Colour");

        propLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        propLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        propLabel.setText("Properties");

        quantityLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        quantityLabel.setText("Quantity");

        lengthField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lengthFieldKeyReleased(evt);
            }
        });

        diameterField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diameterFieldKeyReleased(evt);
            }
        });

        lengthNote.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lengthNote.setForeground(new java.awt.Color(255, 0, 0));
        lengthNote.setText("(must be between 0.1 and 6 metres)");

        diameterNote.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        diameterNote.setForeground(new java.awt.Color(255, 0, 0));
        diameterNote.setText("(must be in inches)");

        gradeButtons.add(gradeOneButton);
        gradeOneButton.setText("1");
        gradeOneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gradeOneButtonMouseReleased(evt);
            }
        });

        gradeButtons.add(gradeTwoButton);
        gradeTwoButton.setText("2");
        gradeTwoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gradeTwoButtonMouseReleased(evt);
            }
        });

        gradeButtons.add(gradeThreeButton);
        gradeThreeButton.setText("3");
        gradeThreeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gradeThreeButtonMouseReleased(evt);
            }
        });

        gradeButtons.add(gradeFourButton);
        gradeFourButton.setText("4");
        gradeFourButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gradeFourButtonMouseReleased(evt);
            }
        });

        gradeButtons.add(gradeFiveButton);
        gradeFiveButton.setText("5");
        gradeFiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gradeFiveButtonMouseReleased(evt);
            }
        });

        colourTypeButtons.add(colourNoneRadio);
        colourNoneRadio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        colourNoneRadio.setText("No colour");
        colourNoneRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                colourNoneRadioMouseReleased(evt);
            }
        });

        colourTypeButtons.add(colourOneRadio);
        colourOneRadio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        colourOneRadio.setText("One colour");
        colourOneRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                colourOneRadioMouseReleased(evt);
            }
        });

        colourTypeButtons.add(colourTwoRadio);
        colourTwoRadio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        colourTwoRadio.setText("Two colour");
        colourTwoRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                colourTwoRadioMouseReleased(evt);
            }
        });

        innerCheckBox.setText("Inner insulation");
        innerCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                innerCheckBoxMouseReleased(evt);
            }
        });

        outerCheckBox.setText("Outer insulation");
        outerCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                outerCheckBoxMouseReleased(evt);
            }
        });

        chemCheckBox.setText("Chemical Resistance");

        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityFieldKeyReleased(evt);
            }
        });

        orderButton.setText("Submit Order");
        orderButton.setEnabled(false);
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetMouseReleased(evt);
            }
        });

        resultsLabel.setToolTipText("");
        resultsLabel.setFocusable(false);
        resultsLabel.setMaximumSize(new java.awt.Dimension(500, 40));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lengthLabel)
                            .addComponent(quantityLabel)
                            .addComponent(propLabel)
                            .addComponent(diameterLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lengthField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diameterField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(diameterNote, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lengthNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(innerCheckBox)
                            .addComponent(outerCheckBox)
                            .addComponent(chemCheckBox)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(colourNoneRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colourOneRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colourTwoRadio))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(gradeOneButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradeTwoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradeThreeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradeFourButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gradeFiveButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Reset, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(500, 500, 500))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(resultsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthLabel)
                    .addComponent(lengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lengthNote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diameterLabel)
                    .addComponent(diameterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diameterNote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeLabel)
                    .addComponent(gradeOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeTwoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeThreeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeFourButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeFiveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colourLabel)
                    .addComponent(colourNoneRadio)
                    .addComponent(colourTwoRadio)
                    .addComponent(colourOneRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(innerCheckBox)
                    .addComponent(propLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outerCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(0, 80, Short.MAX_VALUE)
                        .addComponent(Reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderButton))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(chemCheckBox)
                        .addGap(18, 18, 18)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        Order customerOrder = makeOrder();
        UI.addOrderToQueue(customerOrder);
    }//GEN-LAST:event_orderButtonActionPerformed

    private void gradeThreeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeThreeButtonMouseReleased
        gradeAdjust();
        orderCheck();
    }//GEN-LAST:event_gradeThreeButtonMouseReleased

    private void gradeTwoButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeTwoButtonMouseReleased
        gradeAdjust();
        orderCheck();
    }//GEN-LAST:event_gradeTwoButtonMouseReleased

    private void gradeOneButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeOneButtonMouseReleased
        gradeAdjust();
        orderCheck();
    }//GEN-LAST:event_gradeOneButtonMouseReleased

    private void gradeFourButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeFourButtonMouseReleased
        gradeAdjust();
        orderCheck();
    }//GEN-LAST:event_gradeFourButtonMouseReleased

    private void gradeFiveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeFiveButtonMouseReleased
        gradeAdjust();
        orderCheck();
    }//GEN-LAST:event_gradeFiveButtonMouseReleased

    private void ResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseReleased
        resetForm();
    }//GEN-LAST:event_ResetMouseReleased

    private void colourNoneRadioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colourNoneRadioMouseReleased
        colourAdjust();
        orderCheck();
    }//GEN-LAST:event_colourNoneRadioMouseReleased

    private void colourOneRadioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colourOneRadioMouseReleased
        colourAdjust();
        orderCheck();
    }//GEN-LAST:event_colourOneRadioMouseReleased

    private void colourTwoRadioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colourTwoRadioMouseReleased
        colourAdjust();
        orderCheck();
    }//GEN-LAST:event_colourTwoRadioMouseReleased

    private void innerCheckBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innerCheckBoxMouseReleased
        innerAdjust();
        orderCheck();
    }//GEN-LAST:event_innerCheckBoxMouseReleased

    private void outerCheckBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outerCheckBoxMouseReleased
        outerAdjust();
        orderCheck();
    }//GEN-LAST:event_outerCheckBoxMouseReleased

    private void lengthFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lengthFieldKeyReleased
        orderCheck();
    }//GEN-LAST:event_lengthFieldKeyReleased

    private void diameterFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diameterFieldKeyReleased
        orderCheck();
    }//GEN-LAST:event_diameterFieldKeyReleased

    private void quantityFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyReleased
        orderCheck();
    }//GEN-LAST:event_quantityFieldKeyReleased
    

    // cycles through each button in a button group and checks to see if its selected, if it is, it returns the value of it
    public String radioButtonGet(ButtonGroup group) {
            for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                AbstractButton radioButton = buttons.nextElement();
                if (radioButton.isSelected()) {
                    return radioButton.getText();
                }
            }
            return null;
    }
    
    private void updateValidButtons(ArrayList validButtons, ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton radioButton = buttons.nextElement();
            for (Object validButton : validButtons) {
                if(validButtons.contains(radioButton.getText())==true) {
                    radioButton.setEnabled(true);
                } else {
                    radioButton.setEnabled(false);
                    radioButton.setSelected(false);
                }
            }
        }
    }
    
    private void gradeAdjust(){
        if(radioButtonGet(gradeButtons)!=null) {
            switch(Integer.parseInt(radioButtonGet(gradeButtons))) {
                case 1:
                    validColourTypes = new ArrayList<>(Arrays.asList("No colour"));
                    updateValidButtons(validColourTypes, colourTypeButtons);
                    innerCheckBox.setEnabled(false);
                    innerCheckBox.setSelected(false);
                    outerCheckBox.setEnabled(false);
                    outerCheckBox.setSelected(false);
                    break;
                case 2:
                    validColourTypes = new ArrayList<>(Arrays.asList("No colour","One colour","Two colour"));
                    updateValidButtons(validColourTypes, colourTypeButtons);
                    innerCheckBox.setEnabled(true);
                    outerCheckBox.setEnabled(false);
                    outerCheckBox.setSelected(false);
                    break;
                case 3:
                    validColourTypes = new ArrayList<>(Arrays.asList("No colour","One colour","Two colour"));
                    updateValidButtons(validColourTypes, colourTypeButtons);
                    innerCheckBox.setEnabled(true);
                    outerCheckBox.setEnabled(true);
                    break;
                case 4:
                    validColourTypes = new ArrayList<>(Arrays.asList("One colour","Two colour"));
                    updateValidButtons(validColourTypes, colourTypeButtons);
                    innerCheckBox.setEnabled(true);
                    outerCheckBox.setEnabled(true);
                    break;
                case 5:
                    validColourTypes = new ArrayList<>(Arrays.asList("Two colour"));
                    updateValidButtons(validColourTypes, colourTypeButtons);
                    innerCheckBox.setEnabled(true);
                    outerCheckBox.setEnabled(true);
                    break;
                default:
            } 
        } else {
                validGrades = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
                updateValidButtons(validGrades, gradeButtons);
            }
    }
    
    private void colourAdjust(){
        if(radioButtonGet(colourTypeButtons)!=null) {
            switch(radioButtonGet(colourTypeButtons)) {
                case "No colour":
                    validGrades = new ArrayList<>(Arrays.asList("1","2","3"));
                    updateValidButtons(validGrades, gradeButtons);
                    innerCheckBox.setEnabled(false);
                    innerCheckBox.setSelected(false);
                    outerCheckBox.setEnabled(false);
                    outerCheckBox.setSelected(false);
                    break;
                case "One colour":
                    validGrades = new ArrayList<>(Arrays.asList("2","3","4"));
                    updateValidButtons(validGrades, gradeButtons);
                    innerCheckBox.setEnabled(false);
                    innerCheckBox.setSelected(false);
                    outerCheckBox.setEnabled(false);
                    outerCheckBox.setSelected(false);
                    break;
                case "Two colour":
                    validGrades = new ArrayList<>(Arrays.asList("2","3","4","5"));
                    updateValidButtons(validGrades, gradeButtons);
                    innerCheckBox.setEnabled(true);
                    outerCheckBox.setEnabled(true);
                    break;
            }
        } else {
            validColourTypes = new ArrayList<>(Arrays.asList("No colour","One colour","Two colour"));
            updateValidButtons(validColourTypes, colourTypeButtons);
        }
    }
    
    private void innerAdjust() {
        if(innerCheckBox.isSelected()==true){
            validGrades = new ArrayList<>(Arrays.asList("2","3","4","5"));
            updateValidButtons(validGrades, gradeButtons);
            validColourTypes = new ArrayList<>(Arrays.asList("Two colour"));
            updateValidButtons(validColourTypes, colourTypeButtons);
            outerCheckBox.setEnabled(true);
            
        } else if(innerCheckBox.isSelected()==false){
            colourAdjust();
            gradeAdjust();
            outerCheckBox.setEnabled(true);
        }
    }
    
    private void outerAdjust() {
        if(outerCheckBox.isSelected()==true){
            validGrades = new ArrayList<>(Arrays.asList("3","4","5"));
            updateValidButtons(validGrades, gradeButtons);
            validColourTypes = new ArrayList<>(Arrays.asList("Two colour"));
            updateValidButtons(validColourTypes, colourTypeButtons);
            initInner = innerCheckBox.isSelected();
            innerCheckBox.setEnabled(false);
            innerCheckBox.setSelected(true);
            
        } else if(outerCheckBox.isSelected()==false){
            colourAdjust();
            gradeAdjust();
            innerCheckBox.setEnabled(true);
            innerCheckBox.setSelected(initInner);
        }
    }
    
    private void orderCheck () {
        try {
            if(!lengthField.getText().isEmpty() && Float.parseFloat(lengthField.getText()) >= 0.1 && Float.parseFloat(lengthField.getText()) <= 6 &&
               !diameterField.getText().isEmpty() && Float.parseFloat(diameterField.getText()) > 0 &&
               gradeButtons.getSelection()!=null && colourTypeButtons.getSelection()!=null &&
               !quantityField.getText().isEmpty() && Integer.parseInt(quantityField.getText()) > 0)
            {
                orderButton.setEnabled(true);
            } else {
                orderButton.setEnabled(false);
            }
        }
        catch (NullPointerException | NumberFormatException ex){
            orderButton.setEnabled(false);
        }
    }
    
    private void resetForm() {
        lengthField.setText("");
        diameterField.setText("");
        validGrades = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        updateValidButtons(validGrades, gradeButtons);
        gradeButtons.clearSelection();
        validColourTypes = new ArrayList<>(Arrays.asList("No colour","One colour","Two colour"));
        updateValidButtons(validColourTypes, colourTypeButtons);
        colourTypeButtons.clearSelection();
        innerCheckBox.setEnabled(true);
        innerCheckBox.setSelected(false);
        outerCheckBox.setEnabled(true);
        outerCheckBox.setSelected(false);
        chemCheckBox.setSelected(false);
        quantityField.setText("");
        orderButton.setEnabled(false);
    }
    
    public Order makeOrder() {
        float length = Float.parseFloat(lengthField.getText());
        float diameter = Float.parseFloat(diameterField.getText());
        int grade = Integer.parseInt(radioButtonGet(gradeButtons));
        int colors = 0;
        switch(radioButtonGet(colourTypeButtons)) {
            case "No colour":
                colors = 0;
            case "One colour":
                colors = 1;
            case "Two colour":
                colors = 2;
        }
        boolean reinforced = outerCheckBox.isSelected();
        boolean insulated = innerCheckBox.isSelected();
        boolean chemResist = chemCheckBox.isSelected();
        
        int quantity = Integer.parseInt(quantityField.getText());
        
        reinforced = innerCheckBox.isSelected()==true;
        
        insulated = outerCheckBox.isSelected()==true;
        
        chemResist = chemCheckBox.isSelected()==true;
        
        Order customerOrder = new Order(grade, length, diameter, colors, insulated, reinforced, chemResist, quantity);
        return customerOrder;
    }
    
    public void displayCost(double cost) {
        resultsLabel.setText("Total cost: £" + String.format("%.2f", cost));
    }
    
    public void displayText(String text) {
        resultsLabel.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton Reset;
    private javax.swing.JCheckBox chemCheckBox;
    private javax.swing.JLabel colourLabel;
    private javax.swing.JRadioButton colourNoneRadio;
    private javax.swing.JRadioButton colourOneRadio;
    private javax.swing.JRadioButton colourTwoRadio;
    private javax.swing.ButtonGroup colourTypeButtons;
    private javax.swing.JTextField diameterField;
    private javax.swing.JLabel diameterLabel;
    private javax.swing.JLabel diameterNote;
    private javax.swing.ButtonGroup gradeButtons;
    private javax.swing.JRadioButton gradeFiveButton;
    private javax.swing.JRadioButton gradeFourButton;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JRadioButton gradeOneButton;
    private javax.swing.JRadioButton gradeThreeButton;
    private javax.swing.JRadioButton gradeTwoButton;
    private javax.swing.JCheckBox innerCheckBox;
    private javax.swing.JTextField lengthField;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JLabel lengthNote;
    private javax.swing.JButton orderButton;
    private javax.swing.JCheckBox outerCheckBox;
    private javax.swing.JLabel propLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel resultsLabel;
    // End of variables declaration//GEN-END:variables

}
