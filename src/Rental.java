
public class Rental 
{
	Car car;
	Client client;
	int iterator=0;
	
	public Rental(Car car, Client client)
	{
		this.car=car;
		this.client=client;
		
		iterator++;
	}

}
