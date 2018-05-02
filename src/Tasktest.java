import java.text.ParseException;
import org.junit.Test;


public class Tasktest extends TaskMain {

	@Test
    public void ttest() throws ParseException 
    {
    	Task ttask = new Task();
    	ttask.setTaskDef("DoSomething");
    	ttask.setDueDate("12/12/2018");
    	System.out.println(ttask.getTaskDef().toString());
    	System.out.println(ttask.getDueDate().toString());
    	System.out.println(ttask.isComplete());
    	
    	Task ttask2 = new Task("DoSomethingElse", "High", ("12/12/2017"), true);
    	System.out.println(ttask2.toString());
    	
    	tasks.add(ttask);
    	tasks.add(ttask2);
    	
    	System.out.println(tasks.get(1).toString());
    	System.out.println(tasks.get(0).toString());
    }
}
