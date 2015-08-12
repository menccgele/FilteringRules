package xml;

import javax.xml.parsers.SAXParserFactory;

/*
 * Creates SAXParser that chains with SAXParserFactory to read XML documents.
 * SAXParserFactory is used for reading XML files larger then 100MB.
 */
public class SAXParser {

	public void readXML() {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
			Handler h = new Handler(); // This is the class that reads XML files.
			saxParser.parse("c:\\file.xml", h);
			h.printXML();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
