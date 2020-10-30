package assegnamento2;

import java.util.Random;

public class Wine {
	
	private int id;
	
	private String name;
	private String producer; 
	private int year;
	private String technicalNotes;
	private String grapeType;
	private int number;
	
	public Wine()
	{
		
	}
	
	
	
	public Wine(String name, String producer, int year, String technicalNotes, String grapeType, int number) {
		Random r = new Random();
		id = r.nextInt();
		this.name = name;
		this.producer = producer;
		this.year = year;
		this.technicalNotes = technicalNotes;
		this.grapeType = grapeType;
		this.number = number;
	}



	public String getName() 
	{
		return name;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getProducer() 
	{
		return producer;
	}
	
	public void setProducer(String producer)
	{
		this.producer = producer;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public String getTechnicalNotes() 
	{
		return technicalNotes;
	}
	
	public void setTechnicalNotes(String technicalNotes) 
	{
		this.technicalNotes = technicalNotes;
	}
	
	public String getGrapeType() 
	{
		return grapeType;
	}
	
	public void setGrapeType(String grapeType)
	{
		this.grapeType = grapeType;
	}
	
	public int getNumber() 
	{
		return number;
	}
	
	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	
}
