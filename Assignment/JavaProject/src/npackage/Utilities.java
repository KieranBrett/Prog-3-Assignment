package npackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import npackage.Stat;

public class Utilities {

	public static void load(ArrayList<Stat> Statistics) {
		String stat;
		String country;
		int totalCases;
		String line;
		int newCases;
		int totalDeaths;
		int newDeaths;
		int totalRecovered;
		int activeCases;
		int seriousCritical;
		int totalCasesPerMil;
		int deathsPerMil;
		int totalTests;
		int totalTestsPerMil;
		int totalPop;
		try {
			BufferedReader in = new BufferedReader(new FileReader("stats.csv"));
			while ((line = in.readLine())!= null) {
				
				String[] fields = line.split(",");
				
				stat = fields[0];
				country = fields[1];
				totalCases = Integer.parseInt(fields[2]);
				newCases = Integer.parseInt(fields[3]);
				totalDeaths = Integer.parseInt(fields[4]);
				newDeaths = Integer.parseInt(fields[5]);
				totalRecovered = Integer.parseInt(fields[6]);
				activeCases = Integer.parseInt(fields[7]);
				seriousCritical = Integer.parseInt(fields[8]);
				totalCasesPerMil = Integer.parseInt(fields[9]);
				deathsPerMil = Integer.parseInt(fields[10]);
				totalTests = Integer.parseInt(fields[11]);
				totalTestsPerMil = Integer.parseInt(fields[12]);
				totalPop = Integer.parseInt(fields[13]);
				
				Statistics.add(new Stat(stat,country,totalCases,newCases,totalDeaths,newDeaths,totalRecovered,activeCases,seriousCritical,totalCasesPerMil,deathsPerMil,totalTests,totalTestsPerMil,totalPop));				
			}
		}
		catch(IOException e) {
			System.out.println("File missing");
		}
		
		Collections.sort(Statistics, new CaseTotalCompare());
	}
	
	public static int calculateAverage(ArrayList<Stat> Statistics, eOrder select) {
		int runningTotal = 0;
		for(int i = 0; i < 215; i++) {
			
			switch (select) {
			case TOTAL_DEATHS:
				runningTotal += Statistics.get(i).getTotalDeaths();
				break;
				
			case TOTAL_CASES:
				runningTotal += Statistics.get(i).getTotalCases();
				break;
				
			case TOTAL_POPULATION:
				runningTotal += Statistics.get(i).getTotalPop();
				break;
			}
			
		}
		
		return runningTotal / 215;
	}
	
	public static Stat Search(ArrayList<Stat> statistics, String name) {
		Stat match = null;
		boolean matched = false;
		
		for(int i = 0; i < 215; i++) {
			if(statistics.get(i).getCountry().toLowerCase().contains(name.toLowerCase())) {
				
				match = statistics.get(i);
				matched = true;
			}
		}
		
		
		if(!matched){
			JOptionPane.showMessageDialog(null, "No match found", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return match;	
	}
}

