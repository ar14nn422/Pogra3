package org.example.data;

import org.example.logic.Paciente;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestorDatosPacientes {
    private File archivo=new File("pacientes.xml");


    public void guardar(List<Paciente> pacientes){
        try{
            JAXBContext ctx=JAXBContext.newInstance(ListaPacientes.class);
            Marshaller m=ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(new ListaPacientes(pacientes), archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> cargar(){
        if(archivo.exists()){
            return new ArrayList<>();
        }
        try{
            JAXBContext ctx=JAXBContext.newInstance(ListaPacientes.class);
            Unmarshaller u=ctx.createUnmarshaller();
            return ((ListaPacientes) u.unmarshal(archivo)).getPacientes();
        }catch(Exception e){
            return new ArrayList<>();

        }
    }
}
