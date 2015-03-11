package RDFToJSON;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;  
import org.json.JSONException;  
import org.json.JSONObject; 

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;


public class RDFToJSON {
	
	JSONArray jsonArrRoot = new JSONArray();
	
	public RDFToJSON(){
		
	}
	
	// create and read RDF/XML
	public Model createModelforUrl(String strUrl) {
        Model model = ModelFactory.createDefaultModel();
        
        //read file
        String fileExtension = getFileExtension(strUrl);
        model.read(strUrl, fileExtension);
        
        return model;
	}
	
	// create an index file contain basic info about class or property for search.
	public void createIndexJson(Model model, String strVocabName){
		
        String rdf = model.getNsPrefixURI("rdf");
        Property type = model.createProperty(rdf + "type");
        String rdfs = model.getNsPrefixURI("rdfs");
        String owl = model.getNsPrefixURI("owl");
        if( null == owl){
        	owl = "http://www.w3.org/2002/07/owl#";
        }
        Resource rdfsClass = model.createResource(rdfs + "Class");
        Resource rdfsProperty = model.createResource(rdf + "Property");
        Resource owlannoProperty = model.createResource(owl + "AnnotationProperty");
        Resource owlobjProperty = model.createResource(owl + "ObjectProperty");
        
        
        Iterator<Resource> itClass = model.listResourcesWithProperty(type, rdfsClass);
        
		while( itClass.hasNext() ){
			Resource classResource = itClass.next();
			String str = classResource.getLocalName();
			JSONObject jsonObj = new JSONObject();
			
			try {
				jsonObj.put("name", str);
				jsonObj.put("uri", classResource.toString());
				jsonObj.put("vocabulary", strVocabName);
				jsonObj.put("type", "class");
				jsonArrRoot.put(jsonObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
        Iterator<Resource> itProperty = model.listResourcesWithProperty(type, rdfsProperty);

		while( itProperty.hasNext() ){
			Resource PropertyResource = itProperty.next();
			String str = PropertyResource.getLocalName();
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("name", str);
				jsonObj.put("uri", PropertyResource.toString());
				jsonObj.put("vocabulary", strVocabName);
				jsonObj.put("type", "Property");
				jsonArrRoot.put(jsonObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        Iterator<Resource> itannoOwlProperty = model.listResourcesWithProperty(type, owlannoProperty);

		while( itannoOwlProperty.hasNext() ){
			Resource PropertyResource = itannoOwlProperty.next();
			String str = PropertyResource.getLocalName();
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("name", str);
				jsonObj.put("uri", PropertyResource.toString());
				jsonObj.put("vocabulary", strVocabName);
				jsonObj.put("type", "Property");
				jsonArrRoot.put(jsonObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        Iterator<Resource> itobjOwlProperty = model.listResourcesWithProperty(type, owlobjProperty);

		while( itobjOwlProperty.hasNext() ){
			Resource PropertyResource = itobjOwlProperty.next();
			String str = PropertyResource.getLocalName();
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("name", str);
				jsonObj.put("uri", PropertyResource.toString());
				jsonObj.put("vocabulary", strVocabName);
				jsonObj.put("type", "Property");
				jsonArrRoot.put(jsonObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void writeJson(){
		try {
			File file = new File("index.json");
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true))); 
		    out.write(jsonArrRoot.toString());
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// create json_LD file for all the vocabulary.
	public void convertRDFToJson(Model model, String filename){
		//write file
		try {
			model.write(new FileOutputStream(filename + ".json"), "JSON-LD");
		} catch (IOException e) {
		}
	}
	
	// get file extension
	private String getFileExtension(String fileName){
	        Map<String, String> extentionmap = new HashMap<String, String>();
		
	    	extentionmap.put("rdf", "RDF/XML");
	    	extentionmap.put("ttl", "TURTLE");
	    	extentionmap.put("n3", "N3");
	    	extentionmap.put("nt", "NTRIPLES");
	    
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		
		return extentionmap.get(extension);
	}
}
