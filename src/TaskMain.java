import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class TaskMain extends Task {

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		JTable table = new JTable(); 
	         
		Object[] columns = {"Task definition","Priority","Due date","Completed"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);
		
		JLabel defLab = new JLabel("Task definition:");
		JLabel prioLab = new JLabel("Priority (High, Medium, Low):");
		JLabel dueLab = new JLabel("Due date:");
		JLabel compLab = new JLabel("Completed:");
		
		JTextField def = new JTextField();
		JTextField prior = new JTextField();
		JTextField dDate = new JTextField();
		JTextField done = new JTextField();
		
		
		JButton add = new JButton("Add");
		JButton delete = new JButton("Delete");
		JButton update = new JButton("Update");     

		// because layouts are too hard
		defLab.setBounds(20, 230, 200, 25);;
		prioLab.setBounds(20, 280, 200, 25);;
		dueLab.setBounds(20, 330, 200, 25);;
		compLab.setBounds(20, 380, 200, 25);;
		
		def.setBounds(20, 250, 200, 25);
		prior.setBounds(20, 300, 100, 25);
		dDate.setBounds(20, 350, 100, 25);
		done.setBounds(20, 400, 100, 25);
	         
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
		frame.add(compLab);
		frame.add(pane);
		frame.add(def);
		frame.add(prior);
		frame.add(dDate);
		frame.add(done);

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
				row[1] = prior.getText();
				row[2] = dDate.getText();
				row[3] = done.getText();
				
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
				prior.setText(model.getValueAt(i, 1).toString());
				dDate.setText(model.getValueAt(i, 2).toString());
				done.setText(model.getValueAt(i, 3).toString());

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
	                    model.setValueAt(prior.getText(), i, 1);
	                    model.setValueAt(dDate.getText(), i, 2);
	                    model.setValueAt(done.getText(), i, 3);
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
		
	/*	JFrame frame = new JFrame();
		JTable table = new JTable();
		frame.setTitle ("To do list:");
		
		Object[] columns = {"Task definition", "Priority", "Due date", "Completed"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		table.setRowHeight(30);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setBackground(Color.white);
		table.setForeground(Color.white);
		
		
		//Label
		JLabel label = new JLabel();
		label.setText("Task definiton:");
		
		//Panel
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);
		frame.setLayout(null);
		frame.add(pane);
		
		//Buttons
		JButton add = new JButton("Add");
		JButton delete = new JButton ("Delete");
		JButton update = new JButton ("Update");
		add.setBounds(150, 220, 100 ,25);
		delete.setBounds(150, 220, 100 ,25);
		update.setBounds(150, 220, 100 ,25);
		
		//Input
		JTextField def = new JTextField(15);
		def.setBounds(20, 220, 100, 25);
		
		
		//Add
		frame.add(label);
		frame.add(def);
		frame.add(table);
		frame.add(add);
		frame.add(delete);
		frame.add(update);
		
		Object[] row = new Object[4];
		add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				row[0] = def.getText();
				
				model.addRow(row);
			}
			
		});
		
		frame.setSize(900, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	} */

}
