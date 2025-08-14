package personas.presentation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View {
    Highlighter highlighter=new Highlighter(Color.green);
    private ButtonGroup grupoSexos;


    private JTextField id;
    private JTextField nombre;
    private JRadioButton sexoMasculino;
    private JRadioButton sexoFemenino;
    private JComboBox estadoCivil;
    private JPanel PanelPrincipal;
    private JCheckBox músicaCheckBox;
    private JCheckBox videoJuegosCheckBox;
    private JCheckBox cineCheckBox;
    private JCheckBox cocinaCheckBox;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JCheckBox deporteCheckBox;
    private JCheckBox otroCheckBox;
    private JTextField otro;



    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public View() {
        id.addMouseListener(highlighter);
        nombre.addMouseListener(highlighter);
        sexoMasculino.addMouseListener(highlighter);
        sexoFemenino.addMouseListener(highlighter);
        estadoCivil.addMouseListener(highlighter);
        músicaCheckBox.addMouseListener(highlighter);
        videoJuegosCheckBox.addMouseListener(highlighter);
        cineCheckBox.addMouseListener(highlighter);
        cocinaCheckBox.addMouseListener(highlighter);
        deporteCheckBox.addMouseListener(highlighter);
        otroCheckBox.addMouseListener(highlighter);
        otro.addMouseListener(highlighter);
        grupoSexos = new ButtonGroup();
        grupoSexos.add(sexoFemenino);
        grupoSexos.add(sexoMasculino);




        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sexo = "";
                if (sexoFemenino.isSelected()) {
                    sexo = "Femenino";
                } else if (sexoMasculino.isSelected()) {
                    sexo = "Masculino";
                } else {
                    sexo = "No especificado";
                }

                String estado = estadoCivil.getSelectedItem().toString();

                String pasatiempos = "";
                if (músicaCheckBox.isSelected()) pasatiempos += "Música, ";
                if (videoJuegosCheckBox.isSelected()) pasatiempos += "Videojuegos, ";
                if (cineCheckBox.isSelected()) pasatiempos += "Cine, ";
                if (cocinaCheckBox.isSelected()) pasatiempos += "Cocina, ";
                if (deporteCheckBox.isSelected()) pasatiempos += "Deporte, ";
                if (otroCheckBox.isSelected()) pasatiempos += "Otro (" + otro.getText() + "), ";

                if (pasatiempos.endsWith(", ")) {
                    pasatiempos = pasatiempos.substring(0, pasatiempos.length() - 2);
                }
                JOptionPane.showMessageDialog(null,
                "ID:"+id.getText()+"\n"+
            "NOMBRE:"+nombre.getText()+"\n"+
                        "ESTADO:"+estado+"\n"+
                        "SEXO:"+sexo+"\n"+
                        "PASATIEMPOS:"+pasatiempos+"\n");


            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               grupoSexos.clearSelection();

                nombre.setText("");
                id.setText("");
                estadoCivil.setSelectedIndex(0);
                videoJuegosCheckBox.setSelected(false);
                músicaCheckBox.setSelected(false);
                cineCheckBox.setSelected(false);
                cocinaCheckBox.setSelected(false);
                deporteCheckBox.setSelected(false);
                otroCheckBox.setSelected(false);
                otro.setText("");

            }
        });
        nombre.addKeyListener(new KeyAdapter() {//para que no hayan numeros en el textfield del nombre
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != '\b') {
                    e.consume(); // Ignora el carácter
                }
            }
        });
    }
}


