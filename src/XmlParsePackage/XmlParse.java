package XmlParsePackage;

import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.ArrayList;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;  
import java.util.Map;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

import RDFToJSON.RDFToJSON;

public class XmlParse {
   
	public static void main(String[] args) {
		
		RDFToJSON rdfToJson = new RDFToJSON();
		String vocabularyName = null;
		String uri = null;
		
		//read item from config.csv and transmit to json
		try { 
            BufferedReader reader = new BufferedReader(new FileReader("config.csv"));
            reader.readLine();
            String line = null; 
            while( ( line = reader.readLine() ) != null ){ 
                String item[] = line.split(",");
                
                vocabularyName  = item[0];
                uri = item[1];
               
        		Model model = rdfToJson.createModelforUrl(uri);
        		rdfToJson.createIndexJson(model, vocabularyName);
        		rdfToJson.convertRDFToJson(model, vocabularyName);
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		rdfToJson.writeJson();

		
	}
}
