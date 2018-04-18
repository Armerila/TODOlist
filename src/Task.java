import java.text.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Task-class and its attributes.
 */
public class Task 
{
	/**
	 * The CORRECT date format
	 */
	DateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
	
	enum Priority
	{
		HIGH, MEDIUM, LOW;
	} 
	private String taskDef;
	private static Date dueDate;
	private Priority priority; 
	private boolean isComplete;

	public Task()
	{
	}
	
	/**
	 * Task constructor
	 * 
	 * @param taskDef		Written string description of task
	 * @param date			Due date of the task
	 * @param isComplete	Task completed/not completed
	 * @param p				Priority (HIGH, MEDIUM, LOW)
	 */
	public Task(String taskDef, String date, boolean isComplete, String p) throws ParseException
	{
		this.taskDef = taskDef;
		Task.dueDate = parser.parse(date);
		this.isComplete = isComplete;
		this.priority = Priority.valueOf(p.toUpperCase());
	}
	/**
	 * Returns a string representation of a tasks values.
	 */
	public String toString() 
	{
		return taskDef + " -"+priority+"- " +" "+dueDate +" "+isComplete;
	}

	///////Get/Set////////
	
	public Priority getPriority() 
	{
		return priority;
	}

	public void setPriority(Priority priority) 
	{
		this.priority = priority;
	}

	public String getTaskDef() 
	{
		return taskDef;
	}

	public void setTaskDef(String taskDef) 
	{
		this.taskDef = taskDef;
	}

	public String getDueDate() 
	{
		return parser.format(dueDate);
	}

	public void setDueDate(String date) throws ParseException
	{
		dueDate = parser.parse(date);
	}

	public boolean isComplete() 
	{
		return isComplete;
	}

	public void setComplete(boolean isComplete) 
	{
		this.isComplete = isComplete;
	}
	
	
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
}
