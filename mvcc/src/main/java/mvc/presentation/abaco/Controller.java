package mvc.presentation.abaco;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void sumar(){
        model.setValor(
                model.getValor() + 2);
    }

    public void multiplicar(){

        model.setValor(model.getValor() * 3);
    }

    public void reset(){
        model.setValor(0);
    }

    public void undo(){
        model.setValor(model.getAnterior());
    }
}
