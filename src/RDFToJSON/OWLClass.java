//package RDFToJSON;
//
//public class OWLClass {
//	private String strName;
//	private String strLabel;
//	private String strComment;
//	private String strequivalentClass;
//	private String strisDefinedBy;
//	private String strSubClassOf;
//	private String strDisjointWith;
//
////	private ArrayList<OWLProperty> extractRDFProperty(Model model){
////	
////    String rdf = model.getNsPrefixURI("rdf");
////    Property type = model.createProperty(rdf + "type");
////    String rdfs = model.getNsPrefixURI("rdfs");
////    Resource rdfsProperty = model.createResource(rdf + "Property");
////    Property rdfsDomain = model.createProperty(rdfs + "domain");
////    
////	ArrayList<OWLProperty> array = new ArrayList();
////	
////    Iterator<Resource> itProperty = model.listResourcesWithProperty(type, rdfsProperty);
////
////	while( itProperty.hasNext() ){
////		OWLProperty OWLPropertyItem = new OWLProperty();
////		Resource PropertyResource = itProperty.next();
////		String str = PropertyResource.getLocalName();
////		String strVocabName = model.getNsURIPrefix(PropertyResource.getNameSpace());
////		//System.out.println(strVocabName + ":" + str);
////		Statement st = model.getProperty(PropertyResource, rdfsDomain);
////		if( st != null )
////		{
////			String str1 = st.getSubject().getLocalName();
////			//System.out.println(str1);
////		}
////		
////		array.add(OWLPropertyItem);
////	}
////	
////	return array;
////}
////
////private ArrayList<OWLClass> extractRDFClass(Model model){
////	ArrayList<OWLClass> array = new ArrayList();
////	String rdf = model.getNsPrefixURI("rdf");
////	String owl = model.getNsPrefixURI("owl");
////	Property type = model.createProperty(rdf + "type");
////    String rdfs = model.getNsPrefixURI("rdfs");
////    
////    Resource rdfsClass = model.createResource(rdfs + "Class");
////    Property rdfsLabel = model.createProperty(rdfs + "label");
////    Property rdfAbout = model.createProperty(rdf + "about");
////    Property rdfsComment = model.createProperty(rdfs + "comment");
////    Property owlEquivalentClass = model.createProperty(owl + "equivalentClass");
////    Property rdfsisDefinedBy = model.createProperty(rdfs + "isDefinedBy");
////    Property rdfssubClassOf = model.createProperty(rdfs + "subClassOf");
////    Property owldisjointWith = model.createProperty(owl + "disjointWith");
////    
////    Iterator<Resource> itClass = model.listResourcesWithProperty(type, rdfsClass);
////    
////	while( itClass.hasNext() ){
////		OWLClass OWLClassItem = new OWLClass();
////		Resource classResource = itClass.next();
////		
////		Statement stLabel = model.getProperty(classResource, rdfsLabel);
////		if( null != stLabel )
////		{
////			String str = stLabel.getObject().toString();
////			OWLClassItem.setStrLabel(str);
////		}
////		
////		String strName = rdfsClass.toString();
////		OWLClassItem.setStrName(strName);
////		
////		Statement stComment = model.getProperty(classResource, rdfsComment);
////		if( null != stComment )
////		{
////			String str = stComment.getObject().toString();
////			OWLClassItem.setStrComment(str);
////		}
////		
////		Statement stEquivalentClass = model.getProperty(classResource, owlEquivalentClass);
////		if( null != stEquivalentClass )
////		{
////			String str = stEquivalentClass.getObject().toString();
////			OWLClassItem.setStrequivalentClass(str);
////		}
////		
////		Statement stisDefinedBy = model.getProperty(classResource, rdfsisDefinedBy);
////		if( null != stisDefinedBy )
////		{
////			String str = stisDefinedBy.getObject().toString();
////			OWLClassItem.setStrisDefinedBy(str);
////		}
////		
////		Statement stsubClassOf = model.getProperty(classResource, rdfssubClassOf);
////		if( null != stsubClassOf )
////		{
////			String str = stsubClassOf.getObject().toString();
////			OWLClassItem.setStrSubClassOf(str);
////		}
////		
////		Statement stdisjointWith = model.getProperty(classResource, owldisjointWith);
////		if( null != stdisjointWith )
////		{
////			String str = stdisjointWith.getObject().toString();
////			OWLClassItem.setStrDisjointWith(str);
////		}
////		
////		array.add(OWLClassItem);
////	}
////	
////	return array;
////}
////
////private void convertToJson(ArrayList<OWLProperty> arrClass, ArrayList<OWLClass> arrProperty){
////	
////}
//	public String getStrName() {
//		return strName;
//	}
//
//	public void setStrName(String strName) {
//		this.strName = strName;
//	}
//
//	public String getStrLabel() {
//		return strLabel;
//	}
//
//	public void setStrLabel(String strLabel) {
//		this.strLabel = strLabel;
//	}
//
//	public String getStrComment() {
//		return strComment;
//	}
//
//	public void setStrComment(String strComment) {
//		this.strComment = strComment;
//	}
//
//	public String getStrequivalentClass() {
//		return strequivalentClass;
//	}
//
//	public void setStrequivalentClass(String strequivalentClass) {
//		this.strequivalentClass = strequivalentClass;
//	}
//
//	public String getStrisDefinedBy() {
//		return strisDefinedBy;
//	}
//
//	public void setStrisDefinedBy(String strisDefinedBy) {
//		this.strisDefinedBy = strisDefinedBy;
//	}
//
//	public String getStrSubClassOf() {
//		return strSubClassOf;
//	}
//
//	public void setStrSubClassOf(String strSubClassOf) {
//		this.strSubClassOf = strSubClassOf;
//	}
//
//	public String getStrDisjointWith() {
//		return strDisjointWith;
//	}
//
//	public void setStrDisjointWith(String strDisjointWith) {
//		this.strDisjointWith = strDisjointWith;
//	}
//	
//}
