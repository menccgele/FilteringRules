package ruleFilterApplication;

public enum RuleType {
	CHILD(1), SUB(2), ROOT(3);

	private final int ruleTypeNumber;

	private RuleType(int ruleTypeNumber) {
		this.ruleTypeNumber = ruleTypeNumber;
	}

	public int getRuleTypeNumber() {
		return ruleTypeNumber;
	}
}
