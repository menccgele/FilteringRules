package ruleFilterApplication;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;

public class HashMapRuleFilter {
	/*
	 * HashMap is used because the key (name of the rule) and the value ( type &
	 * weight eg. child/sub/root & 23/56/99 ) are the only needed arguments to
	 * be processed.
	 * 
	 * Key (name of the rule) is unique. Value (Object: XMLtw) is consistent of
	 * type (eg. child/sub/root) and weight (eg 20/45/99).
	 */
	Logger logger = Logger.getLogger("SAXParser");
	HashMap<String, Rule> xml = new HashMap<String, Rule>();
	RuleType type;

	public void ruleAttributes(Attributes attributes) {
		type = RuleType.valueOf(attributes.getValue("type").toUpperCase());
		if (!xml.containsKey(attributes.getValue(
				"name"))) { /* If there is no key with 'name', we create new. */
			add(attributes);
		} else { /*
					 * If there is already key with 'name' it compares 'type'
					 * and 'weight'
					 */
			if (type.getRuleTypeNumber() == xml.get(attributes.getValue("name")).getType()
					.getRuleTypeNumber()) { /*
											 * if 'type' is equal we are
											 * comparing the weight
											 */
				if (Integer.parseInt(attributes.getValue("weight")) > xml.get(attributes.getValue("name"))
						.getWeight()) {
					change(attributes);
				}
			} else if (type.getRuleTypeNumber() < xml.get(attributes.getValue("name")).getType()
					.getRuleTypeNumber()) { /*
											 * If 'type' of the newly found
											 * argument is "bigger" then the
											 * element we already have (eg.
											 * child>sub>root).
											 */
				change(attributes);
			}

		}
	}

	/*
	 * Creates new HashMap element
	 */
	private void add(Attributes attributes) {
		xml.put(attributes.getValue("name"), new Rule(type, Integer.parseInt(attributes.getValue("weight"))));
	}

	/*
	 * Change the element that is already in the HashMap with the newly found.
	 */
	private void change(Attributes attributes) {
		xml.replace(attributes.getValue("name"), xml.get(attributes.getValue("name")),
				new Rule(type, Integer.parseInt(attributes.getValue("weight"))));
	}

	public void printXML() {
		for (String s : xml.keySet()) {
			logger.info(s + " " + xml.get(s).toString());
		}
	}
}
