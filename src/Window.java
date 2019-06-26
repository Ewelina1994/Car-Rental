import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Window extends JFrame implements ActionListener
{
	ListCars listCars=new ListCars();
	List<Car> listCarAvailable=new ArrayList<Car>();
	List<Client> listClient=new ArrayList<Client>();
	int howMuchCleint=0;
	
	Layout layout=new Layout();
	JCheckBox []tabCheckBox;
	JPanel panel=new JPanel();
	
	//do wpisywania do pliku xml
	private String role1 = null;
	private String role2 = null;
	private String role3 = null;
	private String role4 = null;
	private ArrayList<String> rolev;
	
	public Window()
	{
		super("Rent Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setJMenuBar(layout.menuBar);//tak jak add , dodaje na ekran
		 c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 0;
	        c.gridy = 0;
	        add(layout,c);

	        int ile=availablelistCar();
	        System.out.print("\nIle samochodów jest wolnych"+ile);
	        int ileListaSam=listCarAvailable.size();
	        System.out.print("\nIle samochodów jest w liscie wolnych"+ileListaSam);
	        tabCheckBox=new JCheckBox[listCarAvailable.size()];
	        
	        //dodanie etykiety "wybierz auto"
	        c.gridx = 1;
	        c.gridy = 0;
        	add(new JLabel("Zaznacz jakie auto chcesz wynaj¹æ"), c);
        	//dodanie checkbox 
        	//wyswietlaj¹ siê tylko te checkboxy-auta tylko te które nie s¹ wynajête
	        for(int i=0; i<tabCheckBox.length; i++)
	        {
	        	c.gridx = 1;
		        c.gridy = i+1;
	        	tabCheckBox[i]=new JCheckBox(listCarAvailable.get(i).marka+listCarAvailable.get(i).model);
	        	add(tabCheckBox[i], c);
	        	tabCheckBox[i].addActionListener(this);
	        }
	        
	        
		
		setVisible(true);
		
		layout.reservation.addActionListener(this);	
		layout.newReservation.addActionListener(this);	
		
	}
	public Window(List<Car> listCarAvailable2)
	{
		super("Rent Car");
		this.listCarAvailable=listCarAvailable2;

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400, 600);
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			setJMenuBar(layout.menuBar);//tak jak add , dodaje na ekran
			 c.fill = GridBagConstraints.HORIZONTAL;
		        c.gridx = 0;
		        c.gridy = 0;
		        add(layout,c);

		        int ileListaSam=listCarAvailable.size();
		        System.out.print("\nIle samochodów jest w liscie wolnych"+ileListaSam);
		        tabCheckBox=new JCheckBox[listCarAvailable.size()];
		        
		        //dodanie etykiety "wybierz auto"
		        c.gridx = 1;
		        c.gridy = 0;
	        	add(new JLabel("Zaznacz jakie auto chcesz wynaj¹æ"), c);
	        	//dodanie checkbox 
	        	//wyswietlaj¹ siê tylko te checkboxy-auta tylko te które nie s¹ wynajête
		        for(int i=0; i<tabCheckBox.length; i++)
		        {
		        	c.gridx = 1;
			        c.gridy = i+1;
		        	tabCheckBox[i]=new JCheckBox(listCarAvailable.get(i).marka+listCarAvailable.get(i).model);
		        	add(tabCheckBox[i], c);
		        	tabCheckBox[i].addActionListener(this);
		        }
		        
		        
			
			setVisible(true);
			
			layout.reservation.addActionListener(this);	
			layout.newReservation.addActionListener(this);	
	}
	
	//dodanie do listy dostepnych samochodw te które nie s¹ wynajete
	public int availablelistCar()
	{
		int i=0;
		for(Car c: listCars.listCar)
		{
			if(c.isRent==false)
			{
				listCarAvailable.add(c);
				i++;
			}	
		}
		
		return i;
	}
	
	public int addClient()
	{
		String firstName=layout.firstName.getText();
		String lastName=layout.lastName.getText();
	
		//String txtData=new SimpleDateFormat("dd/mm/yyyy").format(layout.data);
		
		listClient.add(new Client(howMuchCleint, firstName, lastName, layout.data));
		
		howMuchCleint++;
		return howMuchCleint;
	}
	
	public void showClients()
	{
		for(Client c:listClient)
		{
		System.out.print("\nCllient nr: "+c.id+" "+c.firstName+" "+c.lastName+", brithday: "+c.brithday+"\n");
		}
	}
	public void saveToXML(String xml) {
	    Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement("roles");

	        // create data elements and place them under root
	        e = dom.createElement("role1");
	        e.appendChild(dom.createTextNode(role1));
	        rootEle.appendChild(e);

	        e = dom.createElement("role2");
	        e.appendChild(dom.createTextNode(role2));
	        rootEle.appendChild(e);

	        e = dom.createElement("role3");
	        e.appendChild(dom.createTextNode(role3));
	        rootEle.appendChild(e);

	        e = dom.createElement("role4");
	        e.appendChild(dom.createTextNode(role4));
	        rootEle.appendChild(e);

	        dom.appendChild(rootEle);

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(xml)));

	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	private String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();
		if(o==layout.reservation)
		{
			for(int i=0; i<tabCheckBox.length; i++)
			{
				//sprawdzic czy checkbox czy jest zaznaczony
				if(tabCheckBox[i].isSelected()==true)//gdy zaznaczone
				{
					//ustawienie samochodu na zajety
					listCars.listCar.get(i).setHired();
					System.out.print("\nauto wynajete to: "+listCars.listCar.get(i).marka+", o statusie: "+listCars.listCar.get(i).isRent);
					listCarAvailable.remove(i);
				}
			}
			addClient();
			showClients();
		}
		
		if(o==layout.newReservation)
		{
			/*layout.firstName.setText("");
			layout.lastName.setText("");*/
			Window newWindow=new Window(listCarAvailable);
		}
		
	}
}
