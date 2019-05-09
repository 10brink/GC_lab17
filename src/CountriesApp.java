import java.util.ArrayList;
import java.util.Scanner;

import co.grandcircus.Validator;

public class CountriesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String fileName = "countries.txt";
		System.out.print("welcome, ");
		int select;
		do {
			System.out.println("what would you like to do?");
			System.out.println(
					"1: display the list of countries \n" + "2: enter a country to add to the list \n" + "3: quit");

			select = Validator.getInt(scan, "", 1, 3);
		//if 1. read file countries.txt
		if (select == 1) {
				System.out.println("disply country list");
				ArrayList<Country> countryList = CountriesTextFile.readFromFile(fileName);
				
				for (Country s : countryList) {
					System.out.println(s);
				}
				// continue;
		}
		//if 2. ask for a country to add to the file
		if (select ==2) {
				System.out.println("add a country");
				String cName = Validator.getString(scan, "country name: ");
				// ask for country
				int pop = Validator.getInt(scan, "population: ");

				Country c = new Country(cName, pop);

				CountriesTextFile.writeToFile(c, fileName);
				// change method to accept string rather than list
				// break;
			}
		} while (select != 3);
		// 3. exit
		System.out.println("bye");
		
	}

}
