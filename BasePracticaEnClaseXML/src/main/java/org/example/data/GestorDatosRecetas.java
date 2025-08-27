package org.example.data;

import org.example.logic.Paciente;
import org.example.logic.Receta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestorDatosRecetas {
    private File archivo=new File("recetas.xml");

    public void guardar(List<Receta> recetas){
        try{
            JAXBContext ctx=JAXBContext.newInstance(ListaRecetas.class);
            Marshaller m=ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(new ListaRecetas(recetas), archivo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Receta> cargar(){
        if(!archivo.exists()){
            return new ArrayList<>();
        }
        try{
            JAXBContext ctx=JAXBContext.newInstance(ListaRecetas.class);
            Unmarshaller u=ctx.createUnmarshaller();
            return ((ListaRecetas) u.unmarshal(archivo)).getRecetas();
        }catch(Exception e){
            return new ArrayList<>();

        }
    }
}
