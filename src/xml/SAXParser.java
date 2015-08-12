package xml;

import javax.xml.parsers.SAXParserFactory;

public class SAXParser {
	
	public void readXML(){

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
		    Handler h = new Handler();
			saxParser.parse("c:\\file.xml", h);
			h.printXML();
		       
		     } catch (Exception e) {
		       e.printStackTrace();
		     }
	}

}
