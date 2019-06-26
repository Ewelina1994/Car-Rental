import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class Layout extends JPanel
{
	JLabel hello;
	JLabel lbFirstName;
	JLabel lbLastName;
	JLabel lbdata;
	JLabel nul=new JLabel("");
	JLabel nul1=new JLabel("");
	JLabel nul2=new JLabel("");
	JLabel nul3=new JLabel("");
	
	JMenuBar menuBar;
	JMenu plik;
	JMenuItem nowy;
	
	JTextField firstName;
	JTextField lastName;
	JCalendar data;
	
	JButton reservation, newReservation;
	
	JPanel panel;
	GridBagConstraints c = new GridBagConstraints();
	public Layout()
	{
		super();
		setLayout(new GridBagLayout());
		menuBar=new JMenuBar();
		plik=new JMenu("Plik");
		nowy=new JMenuItem("Nowe zamówienie");
		
		plik.add(nowy);
		
		
		menuBar.add(plik);
		
		hello= new JLabel("Podaj swoje dane");
		lbFirstName= new JLabel("Podaj Imie");
		lbLastName= new JLabel("Podaj nazwisko");
		lbdata= new JLabel("Podaj swoj¹ datê urodzenia");
		
		firstName= new JTextField();
		lastName=new JTextField();
		data=new JCalendar();
		
		reservation=new JButton("Book");
		newReservation=new JButton("New reservation");
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
       
        c.gridx = 0;
        c.gridy = 0;
        add(hello,c);
        
        c.gridx = 0;
        c.gridy = 1;
        add(nul,c);
        c.gridx = 0;
        c.gridy = 2;
        add(nul1,c);
        c.gridx = 0;
        c.gridy = 3;
        add(nul2,c);
        c.gridx = 0;
        c.gridy = 4;
        add(nul2,c);
        
        c.gridx = 0;
        c.gridy = 5;
        add(lbFirstName,c);
        
        c.gridx = 0;
        c.gridy = 6;
        add(firstName,c);
        
        c.gridx = 0;
        c.gridy = 7;
        add(lbLastName,c);
        
        c.gridx = 0;
        c.gridy = 8;
        add(lastName,c);
        
        c.gridx = 0;
        c.gridy = 9;
        add(lbdata,c);
        
        c.gridx = 0;
        c.gridy = 10;
        add(data,c);
        
        c.gridx = 0;
        c.gridy = 11;
        add(reservation,c);
        
        //chce tu zrobic 2 pola przerwy
        
        c.gridx = 0;
        c.gridy = 12;
        add(newReservation,c);
        
        //add(panel);
		
		
		
		
	}

	

}
