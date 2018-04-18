import java.text.*;
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
	private Priority priority; 
	private static Date dueDate;
	private boolean isComplete;

	public Task()
	{
		taskDef = null;
		priority = Priority.HIGH;
		dueDate = null;
		isComplete = false;
	}
	
	
	/**
	 * Task constructor
	 * 
	 * @param taskDef		Written string description of task
	 * @param p				Priority (HIGH, MEDIUM, LOW)
	 * @param date			Due date of the task
	 * @param isComplete	Task completed/not completed
	 * 
	 */
	public Task(String taskDef, String p, String date, boolean isComplete) throws ParseException
	{
		this.taskDef = taskDef;
		this.priority = Priority.valueOf(p.toUpperCase());
		Task.dueDate = parser.parse(date);
		this.isComplete = isComplete;

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
	
	/**
	 * List of Task -objects.
	 */
    public static ArrayList<Task> Tasks = new ArrayList<>();
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
}
