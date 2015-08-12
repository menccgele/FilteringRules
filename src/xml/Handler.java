package xml;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
	
	HashMap<String, XMLtw> xml = new HashMap<String, XMLtw>();

	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
		if(qName.equals("rule")){
		if(!xml.containsKey(attributes.getValue("name"))){ // Ako ne postoi element so 'name' da kreira nov.
			xml.put(attributes.getValue("name"),new XMLtw(
					attributes.getValue("type"), 
					Integer.parseInt(attributes.getValue("weight"))));
		}
		else{ // ako postoi element so 'name'
			int att = StringToNumber(attributes.getValue("type"));
			int xmlType = StringToNumber(xml.get(attributes.getValue("name")).getType());
			
			if(att==xmlType){ // Ako 'type' e ist so elementot sto postoi
				if(Integer.parseInt(attributes.getValue("weight"))>xml.get(attributes.getValue("name")).getWeight()){ // Ako 'weight' na noviot element e po golem od elementot sto e veke vo HashMap
    				xml.get(attributes.getValue("name")).setWeight(Integer.parseInt(attributes.getValue("weight")));
				}
			}
			else if(att<xmlType){ // Ako 'type' na noviot element e po vazen od elementot veke sto e zacuvan
				xml.replace(
						attributes.getValue("name"), 
						xml.get(attributes.getValue("name")), 
						new XMLtw(attributes.getValue("type"),Integer.parseInt(attributes.getValue("weight"))));
			}
			
		}
		}
		
	}
	
	private int StringToNumber(String s) { // 'Type' da go pretvori vo brojka za po lesno sporeduvanje
		int x=0;
		if(s.equals("child"))
			x = 1;
		else if(s.equals("sub"))
			x = 2;
		else 
			x = 3;
		return x;
	}

	public void printXML(){
		for(String s:xml.keySet()){
			System.out.println(s+" "+xml.get(s).toString());
		}
	}
}
