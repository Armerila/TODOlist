import java.text.ParseException;
import org.junit.Test;


public class Tasktest {

	@Test
    public void ttest() throws ParseException 
    {
    	Task ttask = new Task();
    	ttask.setTaskDef("Blablaaa");
    	ttask.setDueDate("12/12/2018");
    	System.out.println(ttask.getTaskDef().toString());
    	System.out.println(ttask.getDueDate().toString());
    	System.out.println(ttask.isComplete());
    	
    	Task ttask2 = new Task("blaa", "12/12/2017", true, "high");
    	System.out.println(ttask2.toString());	
    }
}
