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
	
	public Task(String taskDef, String date, boolean isComplete, String p) throws ParseException
	{
		this.taskDef = taskDef;
		Task.dueDate = parser.parse(date);
		this.isComplete = isComplete;
		this.priority = Priority.valueOf(p.toUpperCase());
	}
	
	public String toString() 
	{
		return taskDef + " -"+priority+"- " +" "+dueDate +" "+isComplete;
	}

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
