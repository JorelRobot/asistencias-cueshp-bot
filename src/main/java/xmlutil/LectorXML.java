/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlutil;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Joel
 */
public abstract class LectorXML {
    
    protected String nombre_archivo;
    protected String ruta_archivo;

    protected DocumentBuilderFactory factory;
    protected DocumentBuilder builder;
    protected Document document;
    
    
    public LectorXML(String nombre_archivo, String ruta_archivo) {
        this.nombre_archivo = nombre_archivo;
        this.ruta_archivo = ruta_archivo;
    }
    
    protected boolean loadXMLFile() {
        
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            
            document = builder.parse(new File(ruta_archivo + nombre_archivo));
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            //Logger.getLogger(LectorXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    /**
     * @return la informacion estructurada del XML a un arreglo de objetos
     */
    //abstract public List dataToList();
}
