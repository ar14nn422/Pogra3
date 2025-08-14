package mvc.presentation.abaco;

import mvc.presentation.AbstractModel;

import java.beans.PropertyChangeListener;

public class Model extends AbstractModel {
    int valor;
    int anterior;

    public static final String VALOR = "valor";

    public Model() {
        valor=0;
        anterior=0;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(VALOR);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.anterior = valor;//GUARDAR EL VALOR ANTES DE CAMBIAR
        this.valor = valor;
        firePropertyChange(VALOR);
    }

    public int getAnterior() {
        return anterior;
    }

    public void setAnterior(int anterior) {
        this.anterior = anterior;
    }
}
