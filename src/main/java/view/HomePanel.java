/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bot.BotAsistencia;
import dao.FormValuesDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.FormValues;
import xmlutil.XMLDataBase;

/**
 *
 * @author Joel
 */
public class HomePanel extends javax.swing.JPanel {

    private FormValuesDAO formValuesDAO;

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        initComponents();

        formValuesDAO = new FormValuesDAO();
        formValuesDAO.checkXMLDataBase();
        setUp();
    }

    private void setUp() {
        setMateriasListUp();

        recursosButtonGroup.add(educappRadioButton);
        recursosButtonGroup.add(moodleRadioButton);
        recursosButtonGroup.add(correoInstRadioButton);

        retroalimentacioButtonGroup.add(meetRadioButton);
        retroalimentacioButtonGroup.add(recursosMoodleRadioButton);
        retroalimentacioButtonGroup.add(viaEmailRadioButton);

        evaluacionButtonGroup.add(parcial1RadioButton);
        evaluacionButtonGroup.add(parcial2RadioButton);
        evaluacionButtonGroup.add(parcial3RadioButton);
        evaluacionButtonGroup.add(extrasRadioButton);
    }

    public void setMateriasListUp() {

        try {
            List<FormValues> formValuesList = formValuesDAO.getAllMaterias();

            if (formValuesList != null) {

                DefaultListModel modeloLista = new DefaultListModel();

                for (FormValues fv : formValuesList) {
                    modeloLista.addElement(fv.getMateria());
                }

                materiasRegistradasList.setModel(modeloLista);
            }
        } catch (Exception ex) {
            System.out.println("Excepcion al levantar lista de materias: " + ex.getMessage());
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

        recursosButtonGroup = new javax.swing.ButtonGroup();
        retroalimentacioButtonGroup = new javax.swing.ButtonGroup();
        evaluacionButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        materiasRegistradasList = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        meetLinkField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionActArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        educappRadioButton = new javax.swing.JRadioButton();
        moodleRadioButton = new javax.swing.JRadioButton();
        correoInstRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        viaEmailRadioButton = new javax.swing.JRadioButton();
        recursosMoodleRadioButton = new javax.swing.JRadioButton();
        meetRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        parcial1RadioButton = new javax.swing.JRadioButton();
        parcial2RadioButton = new javax.swing.JRadioButton();
        parcial3RadioButton = new javax.swing.JRadioButton();
        extrasRadioButton = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        otraActDecripcionArea = new javax.swing.JTextArea();
        agregarMateriaButton = new javax.swing.JButton();
        eliminarMateriaButton = new javax.swing.JButton();
        salidaButton = new javax.swing.JButton();
        entradaButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        materiasRegistradasList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        materiasRegistradasList.setToolTipText("");
        materiasRegistradasList.setSelectionBackground(new java.awt.Color(124, 172, 92));
        materiasRegistradasList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                materiaChanged(evt);
            }
        });
        jScrollPane1.setViewportView(materiasRegistradasList);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Videoconferencia");

        meetLinkField.setBackground(new java.awt.Color(245, 245, 245));
        meetLinkField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        meetLinkField.setForeground(new java.awt.Color(0, 51, 204));
        meetLinkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetLinkFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Link de la videoconferencia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetLinkField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 403, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meetLinkField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Videoconferencia", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Actividad en clase");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Descipcion de la actividad:");

        descripcionActArea.setBackground(new java.awt.Color(245, 245, 245));
        descripcionActArea.setColumns(20);
        descripcionActArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descripcionActArea.setRows(5);
        jScrollPane2.setViewportView(descripcionActArea);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Recurso utilizado");

        educappRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        educappRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        educappRadioButton.setText("EDUCAPP");

        moodleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        moodleRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        moodleRadioButton.setText("MOODLE");

        correoInstRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        correoInstRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        correoInstRadioButton.setText("Correo Institucional");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correoInstRadioButton)
                            .addComponent(moodleRadioButton)
                            .addComponent(educappRadioButton)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(educappRadioButton)
                .addGap(18, 18, 18)
                .addComponent(moodleRadioButton)
                .addGap(18, 18, 18)
                .addComponent(correoInstRadioButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Actividad en clase", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        viaEmailRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        viaEmailRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        viaEmailRadioButton.setText("Via Correo Institucional");

        recursosMoodleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        recursosMoodleRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        recursosMoodleRadioButton.setText("Recursos MOODLE");

        meetRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        meetRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        meetRadioButton.setText("Viedoconferencia");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Retroalimentacion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viaEmailRadioButton)
                    .addComponent(recursosMoodleRadioButton)
                    .addComponent(meetRadioButton)
                    .addComponent(jLabel6))
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(meetRadioButton)
                .addGap(18, 18, 18)
                .addComponent(recursosMoodleRadioButton)
                .addGap(18, 18, 18)
                .addComponent(viaEmailRadioButton)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Retroalimanetacion", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Evaluacion");

        parcial1RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        parcial1RadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        parcial1RadioButton.setText("Primer parcial");

        parcial2RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        parcial2RadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        parcial2RadioButton.setText("Segundo parcial");

        parcial3RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        parcial3RadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        parcial3RadioButton.setText("Tercer parcial");

        extrasRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        extrasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        extrasRadioButton.setText("Extraordinario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(extrasRadioButton)
                    .addComponent(parcial3RadioButton)
                    .addComponent(parcial2RadioButton)
                    .addComponent(parcial1RadioButton)
                    .addComponent(jLabel7))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(parcial1RadioButton)
                .addGap(18, 18, 18)
                .addComponent(parcial2RadioButton)
                .addGap(18, 18, 18)
                .addComponent(parcial3RadioButton)
                .addGap(18, 18, 18)
                .addComponent(extrasRadioButton)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Evaluacion", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Otra actividad");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Descipcion de la actividad:");

        otraActDecripcionArea.setBackground(new java.awt.Color(245, 245, 245));
        otraActDecripcionArea.setColumns(20);
        otraActDecripcionArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        otraActDecripcionArea.setRows(5);
        jScrollPane3.setViewportView(otraActDecripcionArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Otra actividad", jPanel5);

        agregarMateriaButton.setBackground(new java.awt.Color(179, 179, 179));
        agregarMateriaButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        agregarMateriaButton.setForeground(new java.awt.Color(255, 255, 255));
        agregarMateriaButton.setText("+");
        agregarMateriaButton.setBorderPainted(false);
        agregarMateriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMateriaButtonActionPerformed(evt);
            }
        });

        eliminarMateriaButton.setBackground(new java.awt.Color(179, 179, 179));
        eliminarMateriaButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eliminarMateriaButton.setForeground(new java.awt.Color(255, 255, 255));
        eliminarMateriaButton.setText("-");
        eliminarMateriaButton.setBorderPainted(false);
        eliminarMateriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMateriaButtonActionPerformed(evt);
            }
        });

        salidaButton.setBackground(new java.awt.Color(209, 74, 68));
        salidaButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        salidaButton.setForeground(new java.awt.Color(255, 255, 255));
        salidaButton.setText("Salida");
        salidaButton.setBorderPainted(false);
        salidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaButtonActionPerformed(evt);
            }
        });

        entradaButton.setBackground(new java.awt.Color(124, 172, 92));
        entradaButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entradaButton.setForeground(new java.awt.Color(255, 255, 255));
        entradaButton.setText("Entrada");
        entradaButton.setBorderPainted(false);
        entradaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaButtonActionPerformed(evt);
            }
        });

        guardarButton.setBackground(new java.awt.Color(255, 238, 170));
        guardarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        guardarButton.setForeground(new java.awt.Color(85, 68, 0));
        guardarButton.setText("Guardar");
        guardarButton.setBorderPainted(false);
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregarMateriaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarMateriaButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entradaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salidaButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(salidaButton)
                    .addComponent(entradaButton)
                    .addComponent(guardarButton)
                    .addComponent(eliminarMateriaButton)
                    .addComponent(agregarMateriaButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMateriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMateriaButtonActionPerformed
        SelectorMateriaDialog nuevaMateria = new SelectorMateriaDialog(null, true);

        nuevaMateria.setHomePanel(this);
        nuevaMateria.setLocationRelativeTo(null);
        nuevaMateria.setVisible(true);
    }//GEN-LAST:event_agregarMateriaButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        String nombreMateria = materiasRegistradasList.getSelectedValue();

        if (!materiasRegistradasList.isSelectionEmpty()) {
            FormValues fv = new FormValues();

            fv.setMateria(nombreMateria);
            fv.setVideoconferencia(meetLinkField.getText());
            fv.setActividad(descripcionActArea.getText());

            fv.setRecurso(getSelectedItemTextFromButtonGroup(recursosButtonGroup));

            fv.setRetroalimentacion(getSelectedItemTextFromButtonGroup(retroalimentacioButtonGroup));

            fv.setEvaluacion(getSelectedItemTextFromButtonGroup(evaluacionButtonGroup));

            fv.setOtra_actividad(otraActDecripcionArea.getText());

            formValuesDAO.editFormValues(fv);
        } else {
            JOptionPane.showMessageDialog(null, "Para ejecutar esta accion debe seleccionar una materia primero.");
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void meetLinkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetLinkFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meetLinkFieldActionPerformed

    private void materiaChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_materiaChanged
        String nombreMateria = materiasRegistradasList.getSelectedValue();
        //JOptionPane.showMessageDialog(null, nombreMateria);

        FormValues fv = formValuesDAO.getFormValuesByNombreMateria(nombreMateria);

        meetLinkField.setText(fv.getVideoconferencia());
        descripcionActArea.setText(fv.getActividad());
        otraActDecripcionArea.setText(fv.getOtra_actividad());

        recursosButtonGroup.clearSelection();
        switch (fv.getRecurso()) {
            case "EDUCAPP":
                recursosButtonGroup.setSelected(educappRadioButton.getModel(), true);
                break;
            case "MOODLE":
                recursosButtonGroup.setSelected(moodleRadioButton.getModel(), true);
                break;
            case "Correo Institucional":
                recursosButtonGroup.setSelected(correoInstRadioButton.getModel(), true);
                break;
        }

        retroalimentacioButtonGroup.clearSelection();
        switch (fv.getRetroalimentacion()) {
            case "Videoconferencia":
                retroalimentacioButtonGroup.setSelected(meetRadioButton.getModel(), true);
                break;
            case "Recursos MOODLE":
                retroalimentacioButtonGroup.setSelected(recursosMoodleRadioButton.getModel(), true);
                break;
            case "Via Correo Institucional":
                retroalimentacioButtonGroup.setSelected(viaEmailRadioButton.getModel(), true);
                break;
        }

        evaluacionButtonGroup.clearSelection();
        switch (fv.getEvaluacion()) {
            case "Primer parcial":
                evaluacionButtonGroup.setSelected(parcial1RadioButton.getModel(), true);
                break;
            case "Segundo parcial":
                evaluacionButtonGroup.setSelected(parcial2RadioButton.getModel(), true);
                break;
            case "Tercer parcial":
                evaluacionButtonGroup.setSelected(parcial3RadioButton.getModel(), true);
                break;
            case "Extraordinario":
                evaluacionButtonGroup.setSelected(extrasRadioButton.getModel(), true);
                break;
        }
    }//GEN-LAST:event_materiaChanged

    private void eliminarMateriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMateriaButtonActionPerformed

        if (!materiasRegistradasList.isSelectionEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "La materia seleccionada ser� eliminada. �Esta seguro de ejecutar esta accion?",
                    "Elimirar materia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                String selectedMateria = materiasRegistradasList.getSelectedValue();

                formValuesDAO.deleteFormValuesByNombre(selectedMateria);
                setMateriasListUp();
            } else {
                System.out.println("CANCELANDO ...");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Para ejecutar esta accion debe seleccionar una materia primero.");
        }
    }//GEN-LAST:event_eliminarMateriaButtonActionPerformed

    private void entradaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaButtonActionPerformed

    }//GEN-LAST:event_entradaButtonActionPerformed

    private void salidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaButtonActionPerformed
        
        String selectedMateria = materiasRegistradasList.getSelectedValue();
        FormValues fv = formValuesDAO.getFormValuesByNombreMateria(selectedMateria);
        BotAsistencia bot = new BotAsistencia(fv);
        
        bot.p0();
        bot.p1();
        bot.p2();
        bot.p3();
        bot.p4();
        /*/
        bot.p5();
        //*/
        
    }//GEN-LAST:event_salidaButtonActionPerformed

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bot de Asistencias TEST");

        frame.setContentPane(new HomePanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private String getSelectedItemTextFromButtonGroup(ButtonGroup bg) {
        Enumeration<AbstractButton> bgElements = bg.getElements();
        AbstractButton btnSelected = null;

        while (bgElements.hasMoreElements()) {
            AbstractButton btn = bgElements.nextElement();

            if (btn.isSelected()) {
                btnSelected = btn;
                break;
            }
        }

        if (btnSelected != null) {
            return btnSelected.getText();
        }

        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarMateriaButton;
    private javax.swing.JRadioButton correoInstRadioButton;
    private javax.swing.JTextArea descripcionActArea;
    private javax.swing.JRadioButton educappRadioButton;
    private javax.swing.JButton eliminarMateriaButton;
    private javax.swing.JButton entradaButton;
    private javax.swing.ButtonGroup evaluacionButtonGroup;
    private javax.swing.JRadioButton extrasRadioButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> materiasRegistradasList;
    private javax.swing.JTextField meetLinkField;
    private javax.swing.JRadioButton meetRadioButton;
    private javax.swing.JRadioButton moodleRadioButton;
    private javax.swing.JTextArea otraActDecripcionArea;
    private javax.swing.JRadioButton parcial1RadioButton;
    private javax.swing.JRadioButton parcial2RadioButton;
    private javax.swing.JRadioButton parcial3RadioButton;
    private javax.swing.ButtonGroup recursosButtonGroup;
    private javax.swing.JRadioButton recursosMoodleRadioButton;
    private javax.swing.ButtonGroup retroalimentacioButtonGroup;
    private javax.swing.JButton salidaButton;
    private javax.swing.JRadioButton viaEmailRadioButton;
    // End of variables declaration//GEN-END:variables
}
