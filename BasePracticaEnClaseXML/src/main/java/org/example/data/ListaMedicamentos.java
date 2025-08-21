package org.example.data;

import org.example.logic.Medicamento;

import javax.lang.model.element.Name;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="ListaMedicamentos")
@XmlAccessorType(XmlAccessType.FIELD)//para acceder a los privados
public class ListaMedicamentos {
    @XmlElement(name="medicamento")
    private List<Medicamento> medicamentos;

    public ListaMedicamentos() {}
    public ListaMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}