/**
 * @author rollins
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TemperatureDataRetriever {

	private static final String COMMA_DELIMITER = ";";
//	public final int ANZAHL_DATENSAETZE = 366, ANZAHL_SPALTEN = 2; // so von uns vorgegeben
	private Path file = null;
	private List<String[]> records ;

	public List<String[]> getRecords() {
		return records;
	}

	public TemperatureDataRetriever(String filename) {
		super();
		this.file = Paths.get(filename);

		retrieve();
	}

	// Temperatur ist in der CSV-Datei eine ganze Zahl
	int getTemperatureInLine(int lineNumber) {
		return Integer.parseInt(records.get(lineNumber)[1]);
	}

	void retrieve() {
		records = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(file);
			for (String line : lines) {
				if (line != null) {

					records.add(line.split(COMMA_DELIMITER));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("CSV-file does not exist.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Record does not exist.");
			e.printStackTrace();
		}

	}

	public void printData() {

		for (String[] stringList : records) {
			for (String s : stringList)
				System.out.print(s + "; ");
			System.out.println();
		}
	}
}
