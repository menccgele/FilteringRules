package ruleFilterApplication;

import java.io.FileNotFoundException;

import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;


/*
 * Creates SAXParser that chains with SAXParserFactory to read XML documents.
 * SAXParserFactory is used for reading XML files larger then 100MB.
 */
public class SAXParser {
	Logger logger = Logger.getLogger("SAXParser");
	

	public void readXML(String s) {
		try {
			/*
			 * Klasata SAXParserFactory frla mnogu exceptions:
			 * FactoryConfigurationError, SAXException,
			 * SAXNotRecognizedException, SAXNotSupportedException,
			 * NullPointerException, UnsupportedOperationException.
			 * 
			 * Treba da gi hendlam site ili samo tie sto ocigledno bi mozele da
			 * se slucat, a drugite da odat vo Exception?
			 */
			SAXParserFactory factory = SAXParserFactory.newInstance();
			/*
			 * Isto i ovaa klasa: UnsupportedOperationException,
			 * IllegalArgumentException, SAXException, IOException,
			 * SAXNotRecognizedException, SAXNotSupportedException
			 */
			javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
			RuleFilteringHandler h = new RuleFilteringHandler();
			saxParser.parse(s, h);
			h.xmlo.printXML();
		} catch (FileNotFoundException f) {
			logger.info("File not found, please check your path u lil shit.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
