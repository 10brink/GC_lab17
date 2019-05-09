import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	// method to read list from file

	public static ArrayList<Country> readFromFile(String fileName) {
		// String fileName = "countries.txt";
		Path filePath = Paths.get(fileName);

		ArrayList<Country> countryList = new ArrayList<Country>();

		File f = filePath.toFile();
		BufferedReader br = null;

		try {


			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();

			while (line != null) {
				// System.out.println(line);
				String[] words = line.split(",");


				String name = words[0];
				// System.out.println(name);
				// System.out.println(words[1]);
				Country newCountry = new Country(name, Integer.parseInt(words[1]));

				countryList.add(newCountry);
				line = br.readLine();

			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no file yet");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("something happened");
		}

		return countryList;
	}

	// method to write list to file
	// if file doesn't exist, create it.
	public static void writeToFile(Country a, String fileName) {
		// String fileName = "countries.txt";
		Path path = Paths.get(fileName);

		File file = path.toFile();

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("file created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("something went wrong");
			}
		}
//		 else {
//			System.out.println("that file already exists");
//		}

		PrintWriter output = null;

		try {
			// the FileOutputStream takes 2 params in the constructor
			// the second param is optional and if not included assumed false -- so it will
			// overwrite the file
			// if true is used, it will add additional data to the end of the file (append)
			output = new PrintWriter(new FileOutputStream(file, true));

			// this was needed to process the ArrayList we are taking in as a parameter
			String adding = (String) (a.getName() + "," + a.getPopulation());
			output.println(adding);
		} catch (FileNotFoundException e) {
			System.out.println("Yoooo, I don't know what's going on -- contact someone!");
		} finally {

			output.close();
		}
	}

}
