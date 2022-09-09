
public class MainTemperaturCSV {

	public static void main(String[] args) {
		/*
		 * Die Datei TemperaturenJJJJ.csv muss im Projektverzeichnis liegen (nicht im
		 * src oder im bin)
		 */

		// Das Objekt, welches die Daten aus der CSV-Datei ausliest
		TemperatureDataRetriever tdr = new TemperatureDataRetriever("Temperaturen.csv");
		
		int sum=0;
		double average=0;

		for(int i =0; i < tdr.getRecords().size(); i++) {
			sum = sum + tdr.getTemperatureInLine(i);
		}
		average =  sum / (double)tdr.getRecords().size();
		
		System.out.println("Durchschnitt: "  + average);
	}

}
