package personas.presentation.personas;

import personas.presentation.Highlighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    private JPanel panel;
    private JTextField idFld;
    private JTextField nombreFld;
    private JRadioButton sexoFldMasc;
    private JRadioButton sexoFldFem;
    private JComboBox estadoFld;
    private JCheckBox pasatiempoFldMusica;
    private JCheckBox pasatiempoFldCine;
    private JCheckBox pasatiempoFldDeporte;
    private JCheckBox pasatiempoFldVideoJuegos;
    private JCheckBox pasatiempoFldCocina;
    private JCheckBox pasatiempoFldOtro;
    private JTextField pasatiempoFldOtroDescripcion;
    private JButton guardarFld;
    private JButton cancelarFld;

    public View() {

        guardarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel,
               "Datos a Guardar:\n" +
                        "ID: " + idFld.getText() + "\n" +
                        "Nombre: " + nombreFld.getText() + "\n" +
                        "Sexo: " + (sexoFldMasc.isSelected() ? "M" : sexoFldFem.isSelected() ? "F" : "O") + "\n" +
                        "Estado Civil: " + (String) estadoFld.getSelectedItem()
                        + "\n" +
                        "Pasatiempos: " +
                        (pasatiempoFldMusica.isSelected() ? " Música" : "") +
                        (pasatiempoFldCine.isSelected() ? " Cine" : "") +
                        (pasatiempoFldDeporte.isSelected() ? " Deporte" : "") +
                        (pasatiempoFldVideoJuegos.isSelected() ? " Videojuegos" : "") +
                        (pasatiempoFldCocina.isSelected() ? " Cocina" : "") +
                        (pasatiempoFldOtro.isSelected() ? " Otro: " + pasatiempoFldOtroDescripcion.getText() : "")

                );
            }
        });

        pasatiempoFldOtro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (pasatiempoFldOtro.isSelected()) {
                    pasatiempoFldOtroDescripcion.setEnabled(true);
                } else {
                    pasatiempoFldOtroDescripcion.setEnabled(false);
                    pasatiempoFldOtroDescripcion.setText("");
                }
            }
        });

        Highlighter highlighter = new Highlighter(Color.green);
        idFld.addMouseListener(highlighter);
        nombreFld.addMouseListener(highlighter);
        sexoFldMasc.addMouseListener(highlighter);
        sexoFldFem.addMouseListener(highlighter);
        estadoFld.addMouseListener(highlighter);
        pasatiempoFldMusica.addMouseListener(highlighter);
        pasatiempoFldCine.addMouseListener(highlighter);
        pasatiempoFldDeporte.addMouseListener(highlighter);
        pasatiempoFldVideoJuegos.addMouseListener(highlighter);
        pasatiempoFldCocina.addMouseListener(highlighter);
        pasatiempoFldOtro.addMouseListener(highlighter);
        pasatiempoFldOtroDescripcion.addMouseListener(highlighter);


        cancelarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idFld.setText("");
                nombreFld.setText("");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    //-------- MVC ---------
    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.CURRENT:
                model.setCurrent(model.getCurrent());
                break;
        }
    }

}
