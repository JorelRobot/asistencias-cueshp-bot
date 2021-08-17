/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.FormValues;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import xmlutil.XMLDataBase;

/**
 *
 * @author Joel
 */
public class FormValuesDAO {

    private XMLDataBase dataBase;

    public FormValuesDAO() {
        dataBase = new XMLDataBase();
    }

    public List<FormValues> getAllMaterias() {
        List<FormValues> materias = null;

        if (dataBase.openXMLDBFile()) {

            Document document = dataBase.getDocument();
            materias = new ArrayList<>();

            NodeList query = document.getElementsByTagName("materia");

            if (query.getLength() > 0) {

                for (int i = 0; i < query.getLength(); i++) {
                    FormValues values = new FormValues();
                    Node item = query.item(i);
                    NodeList childNodes = item.getChildNodes();

                    //value.setMateria(item.getAttributes().getNamedItem("nombre").getTextContent());
                    values.setMateria(item.getAttributes().getNamedItem("id").getTextContent());
                    values.setSemestre(Integer.parseInt(item.getAttributes().getNamedItem("semestre").getTextContent()));

                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);

                        switch (childNode.getNodeName()) {
                            case "videoconferencia":
                                values.setVideoconferencia(childNode.getTextContent());
                                break;
                            case "actividad":
                                values.setActividad(childNode.getTextContent());
                                break;
                            case "recurso":
                                values.setRecurso(childNode.getTextContent());
                                break;
                            case "retroalimentacion":
                                values.setRetroalimentacion(childNode.getTextContent());
                                break;
                            case "evaluacion":
                                values.setEvaluacion(childNode.getTextContent());
                                break;
                            case "otra-actividad":
                                values.setOtra_actividad(childNode.getTextContent());
                                break;
                        }
                    }

                    materias.add(values);
                }
            }
        }

        return materias;
    }

    public FormValues getFormValuesByNombreMateria(String nombre) {
        FormValues values = null;

        if (dataBase.openXMLDBFile()) {
            Document document = dataBase.getDocument();
            
            Node query = getMateriaNodeByID(nombre);
            //Element query = document.getElementById(nombre);

            if (query != null) {
                values = new FormValues();
                NodeList childNodes = query.getChildNodes();

                //values.setMateria(query.getAttribute("nombre"));
                values.setMateria(query.getAttributes().getNamedItem("id").getTextContent());
                values.setSemestre(Integer.parseInt(query.getAttributes().getNamedItem("semestre").getTextContent()));

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                    switch (childNode.getNodeName()) {
                        case "videoconferencia":
                            values.setVideoconferencia(childNode.getTextContent());
                            break;
                        case "actividad":
                            values.setActividad(childNode.getTextContent());
                            break;
                        case "recurso":
                            values.setRecurso(childNode.getTextContent());
                            break;
                        case "retroalimentacion":
                            values.setRetroalimentacion(childNode.getTextContent());
                            break;
                        case "evaluacion":
                            values.setEvaluacion(childNode.getTextContent());
                            break;
                        case "otra-actividad":
                            values.setOtra_actividad(childNode.getTextContent());
                            break;
                    }
                }
            }
        }

        return values;
    }

    public void createFormValuesTemplate(String nombreMateria, String semestreMateria) {

        if (dataBase.openXMLDBFile()) {
            Document document = dataBase.getDocument();

            Element materia = document.createElement("materia");

            materia.setAttribute("id", nombreMateria);
            //materia.setIdAttribute("id", true);
            materia.setAttribute("semestre", semestreMateria);

            Element videoconferencia = document.createElement("videoconferencia");
            materia.appendChild(videoconferencia);

            Element actividad = document.createElement("actividad");
            materia.appendChild(actividad);

            Element recurso = document.createElement("recurso");
            materia.appendChild(recurso);

            Element retroalimentacion = document.createElement("retroalimentacion");
            materia.appendChild(retroalimentacion);

            Element evaluacion = document.createElement("evaluacion");
            materia.appendChild(evaluacion);

            Element otraActividad = document.createElement("otra-actividad");
            materia.appendChild(otraActividad);

            document.getDocumentElement().appendChild(materia);

            dataBase.commitChanges(document);
        }
    }

    public void deleteFormValuesByNombre(String nombreMateria) {

        if (dataBase.openXMLDBFile()) {
            Document document = dataBase.getDocument();
            
            Node query = null;
            NodeList materias = document.getElementsByTagName("materia");

            if (materias != null) {
                
                for (int i = 0; i < materias.getLength(); i++) {
                    NamedNodeMap materiaAttributes = materias.item(i).getAttributes();
                    if (materiaAttributes.getNamedItem("id").getTextContent().equals(nombreMateria)) {
                        query = materias.item(i);
                        break;
                    }
                }
            }
            //Element query = document.getElementById(nombreMateria);

            if (query != null) {
                
                Node parent = query.getParentNode();
                NodeList childNodes = query.getChildNodes();
                
                while (childNodes.getLength() != 0) {
                    System.out.println(childNodes.getLength());
                    query.removeChild(childNodes.item(0));
                }
                
                parent.removeChild(query);
                dataBase.commitChanges(document);
            }
        }
    }

    public void editFormValues(FormValues values) {
        if (dataBase.openXMLDBFile()) {
            Document document = dataBase.getDocument();

            Element materia = document.getElementById(values.getMateria());

            NodeList childNodes = materia.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                Text text = null;

                switch (childNode.getNodeName()) {
                    case "videoconferencia":
                        text = document.createTextNode(values.getVideoconferencia());
                        break;
                    case "actividad":
                        text = document.createTextNode(values.getActividad());
                        break;
                    case "recurso":
                        text = document.createTextNode(values.getRecurso());
                        break;
                    case "retroalimentacion":
                        text = document.createTextNode(values.getRetroalimentacion());
                        break;
                    case "evaluacion":
                        text = document.createTextNode(values.getEvaluacion());
                        break;
                    case "otra-actividad":
                        text = document.createTextNode(values.getOtra_actividad());
                        break;
                }

                childNode.appendChild(text);
            }
            dataBase.commitChanges(document);
        }
    }

    public boolean existsMateria(String nombreMateria) {
        if (dataBase.openXMLDBFile()) {
            return getMateriaNodeByID(nombreMateria) != null;
        }
        return false;
    }
    
    private Node getMateriaNodeByID(String idMateria) {
        
        if (dataBase.openXMLDBFile()) {
            Document document = dataBase.getDocument();

            NodeList materias = document.getElementsByTagName("materia");

            if (materias != null) {
                
                for (int i = 0; i < materias.getLength(); i++) {
                    NamedNodeMap materiaAttributes = materias.item(i).getAttributes();
                    if (materiaAttributes.getNamedItem("id").getTextContent().equals(idMateria)) {
                        return materias.item(i);
                    }
                }
            }
        }
        
        return null;
    }

    public void checkXMLDataBase() {
        dataBase.createXMLDBFileIfNotExists();
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        FormValuesDAO formValuesDAO = new FormValuesDAO();
        String materia;

        while (true) {
            System.out.println("Ingresa el nombre de la materia: ");
            materia = lector.nextLine();

            if (!formValuesDAO.existsMateria(materia)) {
                System.out.println("LA MATERIA NO EXISTE!!!");
            } else {
                System.out.println("LA MATERIA EXISTE!!!");
            }
        }
    }
}
