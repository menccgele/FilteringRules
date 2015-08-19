package ruleFilterApplication;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Reads the XML file line-by-line for better argument manipulation.
 */
public class RuleFilteringHandler extends DefaultHandler {

	HashMapRuleFilter xmlo = new HashMapRuleFilter();

	/*
	 * startElement method is where the XML is read line-by-line.
	 * attributes.getValue("name/type/weight") is the rule attribute.
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("rule")) {
			xmlo.ruleAttributes(attributes);
		}

	}

}
