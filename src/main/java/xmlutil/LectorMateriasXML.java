/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlutil;

import java.util.ArrayList;
import java.util.List;
import model.Materia;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Joel
 */
public class LectorMateriasXML extends LectorXML {
    
    public LectorMateriasXML(String nombre_archivo) {
        super(nombre_archivo, "");
    }
    
    public List<Materia> getMateriasBySemestre(int semestre){
        
        List<Materia> materias = new ArrayList<>();
        
        if (loadXMLFile()) {
            NodeList all_materias = document.getElementsByTagName("materia");
            List<Node> materias_filtradas = new ArrayList<>();
                    
            for (int i = 0; i < all_materias.getLength(); i++){
                Node materia = all_materias.item(i);
                String nombre_materia = materia.getTextContent();
                int semestre_materia = Integer.parseInt(materia.getAttributes().getNamedItem("semestre").getTextContent());
                                
                if (semestre_materia == semestre){
                    materias.add(new Materia(nombre_materia, semestre_materia));
                }
            }
        } else {
            return null;
        }
        
        return materias;
    }
    
    public static void main(String[] args) {
        LectorMateriasXML lector = new LectorMateriasXML("materias.xml");
        
        System.out.println(lector.getMateriasBySemestre(1).toString());
    }
}
