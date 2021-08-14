/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlutil;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.FormValues;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Joel
 */
public class XMLDBManager {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private DOMImplementation implementation;
    private Document document;
    private Element root_element;
    private File xmlbdFile;

    public XMLDBManager() {

        try {
            initAttributes();
        } catch (ParserConfigurationException ex) {
            //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al inicializar XMLDBManager: " + ex.getMessage());
        }
    }

    private void initAttributes() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newDefaultInstance();
        builder = factory.newDocumentBuilder();
        implementation = builder.getDOMImplementation();

        xmlbdFile = new File("materiasFormValues.xml");
    }

    public void createXMLDBFile() {

        document = implementation.createDocument(null, "formvalues", null);
        document.setXmlVersion("1.0");

        Source source = new DOMSource(document);
        Result result = new StreamResult(xmlbdFile);

        Transformer transformer = null;

        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al generar XMLDBManager: " + ex.getMessage());
        } catch (TransformerException ex) {
            //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al generar XMLDBManager: " + ex.getMessage());
        }
    }

    public void agregarFormValue(FormValues value) {

        try {
            document = builder.parse(xmlbdFile);
            document.getDocumentElement().normalize();
            
            root_element = document.getDocumentElement();
            
            Element container = document.createElement("value");

            Element materia = document.createElement("materia");
            Text text = document.createTextNode(value.getMateria());
            materia.appendChild(text);
            container.appendChild(materia);

            Element semestre = document.createElement("semestre");
            text = document.createTextNode(String.valueOf(value.getSemestre()));
            semestre.appendChild(text);
            container.appendChild(semestre);

            Element videoconferencia = document.createElement("videoconferencia");
            text = document.createTextNode(value.getVideoconferencia());
            videoconferencia.appendChild(text);
            container.appendChild(videoconferencia);

            Element actividad = document.createElement("actividad");
            text = document.createTextNode(value.getActividad());
            actividad.appendChild(text);
            container.appendChild(actividad);

            Element recurso = document.createElement("recurso");
            text = document.createTextNode(value.getRecurso());
            recurso.appendChild(text);
            container.appendChild(recurso);

            Element retroalimentacion = document.createElement("retroalimentacion");
            text = document.createTextNode(value.getRetroalimentacion());
            retroalimentacion.appendChild(text);
            container.appendChild(retroalimentacion);

            Element evaluacion = document.createElement("evaluacion");
            text = document.createTextNode(value.getEvaluacion());
            evaluacion.appendChild(text);
            container.appendChild(evaluacion);

            Element otra_actividad = document.createElement("otra-actividad");
            text = document.createTextNode(value.getOtra_actividad());
            otra_actividad.appendChild(text);
            container.appendChild(otra_actividad);

            document.getDocumentElement().appendChild(container);

            Source source = new DOMSource(document);
            Result result = new StreamResult(xmlbdFile);

            Transformer transformer = null;

            try {
                transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            } catch (TransformerConfigurationException ex) {
                //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion al generar XMLDBManager: " + ex.getMessage());
            } catch (TransformerException ex) {
                //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Excepcion al generar XMLDBManager: " + ex.getMessage());
            }

        } catch (SAXException | IOException ex) {
            //Logger.getLogger(XMLDBManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al agregar FormValues: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        FormValues value = new FormValues();
        value.setMateria("Comprension de la ciencia");
        value.setSemestre(1);
        value.setVideoconferencia("http://meet.google.com");
        value.setActividad("Una actividad chida");
        value.setRecurso("MOODLE");
        value.setRetroalimentacion("Videoconferencia");
        value.setEvaluacion("Parcial 1");
        value.setOtra_actividad("Otra actividad chida");

        XMLDBManager manager = new XMLDBManager();
        //manager.createXMLDBFile();
        manager.agregarFormValue(value);
        manager.agregarFormValue(value);
    }
}
