package personas.presentation.personas;
import personas.AbstractModel;
import personas.logic.Persona;

import java.beans.PropertyChangeListener;

public class Model extends AbstractModel {
    Persona current;


    public static final String CURRENT = "current";

    public Model() {
        current=new Persona("111","Juan Perez",'M', "Soltero");

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }

    public String getCurrent() {
        return CURRENT;
    }

    public void setCurrent(Persona current) {
        this.current= current;
        firePropertyChange(CURRENT);
    }


}
