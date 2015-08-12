package xml;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Reads the XML file line-by-line for better argument manipulation.
 */
public class Handler extends DefaultHandler {

	/*
	 * HashMap is used because the key (name of the rule)
	 * and the value ( type & weight eg. child/sub/root & 23/56/99 )
	 * are the only needed arguments to be processed.
	 * 
	 * Key (name of the rule) is unique.
	 * Value (Object: XMLtw) is consistent of type (eg. child/sub/root) and weight (eg 20/45/99).
	 */
	HashMap<String, XMLtw> xml = new HashMap<String, XMLtw>();

	/*
	 * startElement method is where the XML is read line-by-line.
	 * attributes.getValue("name/type/weight") is the rule attribute.
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("rule")) {
			if (!xml.containsKey(attributes.getValue("name"))) { // If there is no key with 'name', we create new.
				xml.put(attributes.getValue("name"),
						new XMLtw(attributes.getValue("type"), Integer.parseInt(attributes.getValue("weight"))));
			} else { // If there is already key with 'name' it compares 'type' and 'weight'
				int att = StringToNumber(attributes.getValue("type"));
				int xmlType = StringToNumber(xml.get(attributes.getValue("name")).getType());

				if (att == xmlType) { // if 'type' is equal we are comparing the weight
					if (Integer.parseInt(attributes.getValue("weight")) > xml.get(attributes.getValue("name"))
							.getWeight()) {
						xml.get(attributes.getValue("name")).setWeight(Integer.parseInt(attributes.getValue("weight")));
					}
				} else if (att < xmlType) { // If 'type' of the newly found argument is "bigger" then the element we already have (eg. child>sub>root).
					xml.replace(attributes.getValue("name"), xml.get(attributes.getValue("name")),
							new XMLtw(attributes.getValue("type"), Integer.parseInt(attributes.getValue("weight"))));
				}

			}
		}

	}
/*
 * For easier comparison, `type` (eg. child/sub/root) is converted in number.
 * We can see if child<sub or sub>root or they are equal.
 */
	private int StringToNumber(String s) {
		int x = 0;
		if (s.equals("child"))
			x = 1;
		else if (s.equals("sub"))
			x = 2;
		else
			x = 3;
		return x;
	}

	public void printXML() {
		for (String s : xml.keySet()) {
			System.out.println(s + " " + xml.get(s).toString());
		}
	}
	
	/*
	 * If Martin is already laughing at Marko`s comments
	 */
	public int ifMartinIsLaughing(){
		return 0; //A single fuck was not given that day.
	}
}
