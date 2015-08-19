package ruleFilterApplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Filter {
	static Logger logger = Logger.getLogger("Filter");
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		new SAXParser().readXML(args[0]);

	}

}
