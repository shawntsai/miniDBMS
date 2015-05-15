package manageDatabase.query;
import java.util.*;

import manageDatabase.expression.Condition;
/**
 * Select Inherit Query<br>
 * Realized while parsing SQL query.<br>
 * Contains:  
 * 
 * @see Query DBExecutor
 * 
 */

public class Select extends Query{
	
	/**
	 * Columns to be select<br>
	 * for first table
	 */
	private ArrayList<String> attrList;
	
	/**
	 * Columns to be select<br>
	 * for second table
	 */
	private ArrayList<String> attrList2;
	
	/**
	 * target table to search<br>
	 * tableNames[0] first<br>
	 * tableNames[1] second<br>
	 */
	
	/**
	 * name of the table
	 */
	private ArrayList<String> tableNames; 
	
	/**
	 * Conditions specified with "WHERE" command
	 */
	private Condition cond;
	
	/**
	 * 
	 */
	private boolean isNormalUser = false;

	/**
	 * mode 1 is  Count,  2 is Sum
	 */
	private Aggregation aggregateMode; 
	
	public static enum Aggregation{
		COUNT, SUM, NON
	}
	
	/**
	 * alias hash table<br>
	 * key: alias<br>
	 * value: table name<br>
	 */
	private Hashtable<String,String> alias;

	/**
	 * <pre>
	 * Constructor with select conditions
	 * 2 table 2 attrlist
	 * 1 table 1 attrlist
	 * with condition or not
	 * </pre>
	 * @param attrList
	 * @param attrList2
	 * @param tableNames
	 * @param cond
	 */
	public Select(
			ArrayList<String> attrList,
			ArrayList<String >attrList2,
			ArrayList<String> tableNames,
			Condition cond,
			Hashtable<String,String>alias) 
	{
		this.queryName = "SELECT";
		this.tableNames = tableNames;
		this.attrList = attrList;
		this.attrList2 = attrList2;
		this.cond = cond;
		this.alias = alias;
		this.aggregateMode = Aggregation.NON;
	}

	/**
	 * <pre>
	 * Constructor with select "*" mark
	 * print two tables all or one tables all
	 * and with condition or not
	 * </pre>
	 * @param tableNames
	 * @param cond
	 * @param selectAll
	 * @param aggregateMode
	 */
	public Select(
			ArrayList<String> tableNames, 
			Condition cond, 
			int aggregateMode)
	{
		this.queryName = "SELECT";
		this.tableNames = tableNames;
		this.cond = cond;
	}


	/**
	 * COUNT aggregate
	 * @param attrList
	 * @param tableNames
	 * @param cond
	 * @param aggregateMode
	 */
	public Select( 
			ArrayList<String> attrList, 
			ArrayList<String> tableNames,
			Condition cond, 
			Aggregation aggregateMode)
	{
		
		this.queryName = "SELECT";
		this.tableNames = tableNames;
		this.attrList = attrList;
		this.attrList2 = null;
		this.cond = cond;
		this.alias = null;
		this.aggregateMode = aggregateMode;
		
	}

	/**
	 * getter of tables to be selected
	 */
	public ArrayList<String> getTableNames(){
		return this.tableNames;
	}

	
	/**
	 * getter of columns to be selected
	 */
	public ArrayList<String> getAttrStrList(){
		return this.attrList;
	}
	/**
	 * getter of columns to be selected
	 */
	public ArrayList<String> getAttrStrList2(){
		return this.attrList2;
	}
	
	
	/**
	 * getter of select conditions
	 */
	public Condition getCondition(){
		return this.cond;
	}

	
	/**
	 * ??????????????? 
	 */
	public void setNormalUser(){
		this.isNormalUser = true;
	}

	
	/**
	 * ???????????????
	 */
	public boolean isNormalUser(){
		return this.isNormalUser;
	}


	public Aggregation getAggregateMode() {
		return aggregateMode;
	}


	public void setAggregateMode(Aggregation aggregateMode) {
		this.aggregateMode = aggregateMode;
	}


	public Hashtable<String,String> getAlias() {
		return alias;
	}


	public void setAlias(Hashtable<String,String> alias) {
		this.alias = alias;
	}

}
