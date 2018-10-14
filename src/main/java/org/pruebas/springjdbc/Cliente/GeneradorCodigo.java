package org.pruebas.springjdbc.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.tools.JavaFileObject;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.pruebas.springjdbc.model.Atributo;

public class GeneradorCodigo {

    public void generarCodigo(){
        //StringBuilder builder = new StringBuilder();

        VelocityEngine motorVelocity = new VelocityEngine();
        motorVelocity.addProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "./src/main/resources/template");
        motorVelocity.init();


		/*VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("packageName", "org.generar.codigo");
		velocityContext.put("className", "Greeter");
		velocityContext.put("methodName", "hello");
		velocityContext.put("names", "Nombres");

		Template template = motorVelocity.getTemplate("saludos.vm");

		StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
		System.out.println(writer);*/

        Atributo campoUno = new Atributo();
        campoUno.setTipoCampo("VARCHAR2");
        campoUno.setNombreCampo("DescripcionLarga");

        Atributo campoDos = new Atributo();
        campoDos.setTipoCampo("NUMBER");
        campoDos.setNombreCampo("IdCentro");

        ArrayList<Atributo> listaAtributos = new  ArrayList<Atributo>();
        listaAtributos.add(campoUno);
        listaAtributos.add(campoDos);


        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("packageName", "org.generar.codigo");
        velocityContext.put("className", "Greeter");
        velocityContext.put("methodName", "hello");
        velocityContext.put("names", "Nombres");
        velocityContext.put("listaCampos", listaAtributos);

        //Template template = motorVelocity.getTemplate("saludos.vm");
        Template template = motorVelocity.getTemplate("entidad.vm");

        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        System.out.println(writer);


        try{
            //JavaFileObject objetoJava = JavaFileObjects.

            //Path path = Paths.get("d:/output.java");

            //if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS))
            //	Files.createFile(path);

            FileWriter fw = new FileWriter("E:/output.java");

            fw.write(writer.toString());
            fw.close();

			/*//Use try-with-resource to get auto-closeable writer instance
			try (BufferedWriter writerB = Files.newBufferedWriter(path))
			{
			    writerB.write("Hello World !!");
			}*/

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
