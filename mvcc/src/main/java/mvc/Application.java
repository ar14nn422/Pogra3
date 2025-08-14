package mvc;

import mvc.presentation.abaco.Model;
import mvc.presentation.abaco.View;
import mvc.presentation.abaco.Controller;
import javax.swing.*;
import java.awt.*;

public class Application {  
    public static void main(String[] args) {
        try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        JFrame window = new JFrame();
        window.setSize(500,200);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Abaco MVC");
        window.setContentPane(view.getPanel());
        window.setVisible(true);
    }

    public static final Color BACKGROUND_ERROR = new Color(255, 102, 102);
}
