/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.FormValues;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
                    FormValues value = new FormValues();
                    Node item = query.item(i);
                    NodeList childNodes = item.getChildNodes();

                    value.setMateria(item.getAttributes().getNamedItem("materia").getTextContent());
                    value.setSemestre(Integer.parseInt(item.getAttributes().getNamedItem("semestre").getTextContent()));

                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);

                        switch (item.getNodeName()) {
                            case "videoconferencia":
                                value.setVideoconferencia(item.getTextContent());
                                break;
                            case "actividad":
                                value.setActividad(item.getTextContent());
                                break;
                            case "recurso":
                                value.setRecurso(item.getTextContent());
                                break;
                            case "retroalimentacion":
                                value.setRetroalimentacion(item.getTextContent());
                                break;
                            case "evaluacion":
                                value.setEvaluacion(item.getTextContent());
                                break;
                            case "otra-actividad":
                                value.setOtra_actividad(item.getTextContent());
                                break;
                        }
                    }
                    
                    materias.add(value);
                }
            }
        }

        return materias;
    }
}
