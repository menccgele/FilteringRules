package xml;

/*
 * XML Type Weight = XMLtw
 */
public class XMLtw {

	private String type;
	private int weight;

	XMLtw(String type, int weight) {
		if (type.equals("child") || type.equals("sub") || type.equals("root") && weight > 0) {
			this.type = type;
			this.weight = weight;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type.equals("child") || type.equals("sub") || type.equals("root"))
			this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0)
			this.weight = weight;
	}

	public String toString() {
		return type + " " + weight;
	}

}
