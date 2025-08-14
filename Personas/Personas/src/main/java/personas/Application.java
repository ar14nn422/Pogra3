package personas;

import personas.presentation.View;

import javax.swing.*;

public class Application {  
    public static void main(String[] args) {
        try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        View view = new View();

        JFrame window = new JFrame();
        window.setSize(530,300);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Personas");
        window.setContentPane(view.getPanelPrincipal());
        window.setVisible(true);
    }
}
