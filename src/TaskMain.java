import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TaskMain {
	/**
	 * List of Task -objects.
	 */
    public static ArrayList<Task> tasks = new ArrayList<>();

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		JTable table = new JTable(); 
	         
		Object[] columns = {"Task definition","Priority","Due date","Completed"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
		
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);
		
		JLabel defLab = new JLabel("Task definition:");
		JLabel prioLab = new JLabel("Priority (High, Medium, Low):");
		JLabel dueLab = new JLabel("Due date (dd/mm/yyyy):");

		JTextField def = new JTextField();
		String[] priors = {"High","Medium","Low"};
		JComboBox<String> prior = new JComboBox<String>(priors);
		JTextField dDate = new JTextField();
		JCheckBox checkBox = new JCheckBox("Check to set task completed");
		checkBox.setSelected(true);
		
		//buttons
		JButton add = new JButton("Add");
		JButton delete = new JButton("Delete");
		JButton update = new JButton("Update");     

		// because layouts are too hard
		defLab.setBounds(20, 230, 200, 25);;
		prioLab.setBounds(20, 280, 200, 25);;
		dueLab.setBounds(20, 330, 200, 25);;

		def.setBounds(20, 250, 200, 25);
		prior.setBounds(20, 300, 100, 25);
		dDate.setBounds(20, 350, 100, 25);
		checkBox.setBounds(20, 400, 200, 25);
	         
		add.setBounds(300, 200, 80, 25);
		update.setBounds(400, 200, 80, 25);
		delete.setBounds(500, 200, 80, 25);
		
		// pane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		frame.setLayout(null);

		// add to frame
		frame.add(defLab);
		frame.add(prioLab);
		frame.add(dueLab);
		frame.add(pane);
		frame.add(def);
		frame.add(prior);
		frame.add(dDate);
		frame.add(checkBox);
		frame.add(add);
		frame.add(delete);
		frame.add(update);

		Object[] row = new Object[4];
			
		// add
		add.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				row[0] = def.getText();
				row[1] = prior.getSelectedItem().toString();
				row[2] = dDate.getText();
				if (checkBox.isSelected() == true)
					row[3] = ("Yes");
				else
				{
					row[3] = ("No");
					checkBox.setSelected(false);
				}
				try {
					/**
					 * Adds a new task with user input as parameters.
					 */
					tasks.add(new Task(def.getText(), prior.getSelectedItem().toString(), dDate.getText(), checkBox.isSelected()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				
				model.addRow(row);
			}
		});
	         
		// delete
		delete.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int i = table.getSelectedRow();
				if(i >= 0)
				{
					model.removeRow(i);
					/**
					 * Delete the task at selected rows index.
					 */
					tasks.remove(i);
				}
				else
				{
					System.out.println("Delete Error");
				}
			}
		});
	         

		table.addMouseListener(new MouseAdapter()
		{
			
			@Override
	         public void mouseClicked(MouseEvent e)
			{
				int i = table.getSelectedRow();
				def.setText(model.getValueAt(i, 0).toString());
				dDate.setText(model.getValueAt(i, 2).toString());

			}
		});
	         
			// update
			update.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
	                 int i = table.getSelectedRow();
	                 
	                 if(i >= 0) 
	                 {
	                    model.setValueAt(def.getText(), i, 0);
	                    model.setValueAt(prior.getSelectedItem(),i, 1);
	                    model.setValueAt(dDate.getText(), i, 2);
	    				if (checkBox.isSelected() == true)
	    					model.setValueAt("Yes", i, 3);
	    				else
	    				{
	    					model.setValueAt("No", i, 3);
	    					checkBox.setSelected(false);
	    				}
	    				/**
	    				 * Update the task on selected rows index with user input as parameters.
	    				 */
	    				try {
							tasks.set(i, new Task(def.getText(), prior.getSelectedItem().toString(), dDate.getText(), checkBox.isSelected()));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
	                 }
	                 else
	                 {
	                     System.out.println("Update Error");
	                 }
	             }
	         });
	         
	         frame.setSize(900,500);
	         frame.setLocationRelativeTo(null);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         frame.setVisible(true);
	         
	     }
}
