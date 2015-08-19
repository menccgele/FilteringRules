package ruleFilterApplication;

import javax.swing.border.EmptyBorder;

/*
 * XML Type Weight = XMLtw
 */
public class Rule {

	private RuleType type;
	private int weight;

	Rule(RuleType type, int weight) {
			this.type = type;
			this.weight = weight;
	}

	public RuleType getType() {
		return type;
	}

	public void setType(RuleType type) {
			this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0)
			this.weight = weight;
		else
			throw new IllegalArgumentException("Weight must be positive integer. :"+weight);
	}

	public String toString() {
		return type + " " + weight;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Rule)) return false;
		Rule r = (Rule) o;
		if(this.type!=r.type) return false;
		if(this.weight!=r.weight) return false;
		return true;
	}
	public int hashCode(){
		return weight * type.hashCode();
	}

}
