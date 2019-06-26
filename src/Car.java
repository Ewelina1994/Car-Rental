
public class Car 
{
	String marka;
	String model;
	double rentalRadePerDay;
	boolean isRent=false;
	
	public Car(String marka, String model, double price)
	{
		this.marka=marka;
		this.model=model;
		rentalRadePerDay=price;
	}
	public void rent()
	{
		isRent=true;
	}
	public String getMarka()
	{
		return marka;
	}
	public String getModel()
	{
		return model;
	}
	public double getRentalRadePerDay()
	{
		return rentalRadePerDay;
	}
	public void setHired()//ustawia samochód na zajety
	{
		isRent=true;
	}
	public void setFree()
	{
		isRent=false;
	}
	

}
