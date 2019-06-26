import java.sql.Date;

import javax.xml.crypto.Data;

import com.toedter.calendar.JCalendar;

public class Client 
{
	int id;
	String firstName;
	String lastName;
	JCalendar brithday;
	
	public Client()
	{
		
	}
	public Client(int id, String firstName, String lastName, JCalendar brithday)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.brithday=brithday;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public String getLasttName()
	{
		return lastName;
	}
	public JCalendar getData()
	{
		return brithday;
	}
	
}
