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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Joel
 */
public class XMLDataBase {
    
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private DOMImplementation implementation;
    private Document document;
    
    private String rootElementStr;
    private String filePath;
        
    public XMLDataBase() {
        filePath = "XMLDataBase.xml";
        rootElementStr = "form-values";
        
        try {
            factory = DocumentBuilderFactory.newDefaultInstance();
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al crear FACTORY y BUILDER: " + ex.getMessage());
        }
    }
        
    public boolean createXMLDBFile() {
        implementation = builder.getDOMImplementation();
        
        document = implementation.createDocument(null, rootElementStr, null);
        document.setXmlVersion("1.0");
        
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File(filePath));
        
        try {
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al crear XMLDataBase: " + ex.getMessage());
            return false;
        } catch (TransformerException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al crear XMLDataBase: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean openXMLDBFile() {
        try {
            
            document = builder.parse(new File(filePath));
            
        } catch (SAXException | IOException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al abrir XMLDataBase: " + ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean commitChanges(Document document) {
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File(filePath));
        
        try {
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al realizar cambios en XMLDataBase: " + ex.getMessage());
            return false;
        } catch (TransformerException ex) {
            //Logger.getLogger(XMLDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al realizar cambios en XMLDataBase: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
    public void createXMLDBFileIfNotExists(){
        File xmldbfile = new File(filePath);
        
        if (!xmldbfile.exists()) {
            createXMLDBFile();
        }
    }

    public Document getDocument() {
        return document;
    }
}