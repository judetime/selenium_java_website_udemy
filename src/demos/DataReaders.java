package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readCSV();

	}
	
	public static void readCSV()
	{
		String filename = "C:\\selenium_help_materials\\UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		//Iterating through the list
		for (String[] record : records)
		{
			for (String field : record)
			{
				System.out.println(field);
			}
		}
	}

}
