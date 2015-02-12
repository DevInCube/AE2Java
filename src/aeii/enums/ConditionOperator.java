package aeii.enums;

public class ConditionOperator {
	
	public final static int LESS_THAN_EQUALS = 0;
	public final static int LESS_THAN = 1;
	public final static int BIGGER_THAN_EQUALS = 2;
	public final static int BIGGER_THAN = 3;
	public final static int NOT_EQUALS = 4;
	public final static int EQUALS = 5;
	
	public static int getOperatorId(String value){
		if(value.equals("<=")) return LESS_THAN_EQUALS;
		if(value.equals("<")) return LESS_THAN;
		if(value.equals(">=")) return BIGGER_THAN_EQUALS;
		if(value.equals(">")) return BIGGER_THAN;
		if(value.equals("!=")) return NOT_EQUALS;
		if(value.equals("==")) return EQUALS;
		else return -1;
	}
	
	

}
