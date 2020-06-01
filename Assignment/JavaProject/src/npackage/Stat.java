package npackage;

import java.util.ArrayList;

public class Stat {

	 private String stat;
	 private String country;
	 private int totalCases;
	 private int newCases;
	 private int totalDeaths;
	 private int newDeaths;
	 private int totalRecovered;
	 private int activeCases;
	 private int seriousCritical;
	 private int totalCasesPerMil;
	 private int deathsPerMil;
	 private int totalTests;
	 private int totalTestsPerMil;
	 private int totalPop;
	
	 public Stat(String stat, String country, int totalCases, int newCases, int totalDeaths, int newDeaths,
			int totalRecovered, int activeCases, int seriousCritical, int totalCasesPerMil, int deathsPerMil,
			int totalTests, int totalTestsPerMil, int totalPop) {
		
		super();
		this.stat = stat;
		this.country = country;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
		this.totalRecovered = totalRecovered;
		this.activeCases = activeCases;
		this.seriousCritical = seriousCritical;
		this.totalCasesPerMil = totalCasesPerMil;
		this.deathsPerMil = deathsPerMil;
		this.totalTests = totalTests;
		this.totalTestsPerMil = totalTestsPerMil;
		this.totalPop = totalPop;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getNewCases() {
		return newCases;
	}

	public void setNewCases(int newCases) {
		this.newCases = newCases;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public int getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}

	public int getSeriousCritical() {
		return seriousCritical;
	}

	public void setSeriousCritical(int seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public int getTotalCasesPerMil() {
		return totalCasesPerMil;
	}

	public void setTotalCasesPerMil(int totalCasesPerMil) {
		this.totalCasesPerMil = totalCasesPerMil;
	}

	public int getDeathsPerMil() {
		return deathsPerMil;
	}

	public void setDeathsPerMil(int deathsPerMil) {
		this.deathsPerMil = deathsPerMil;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public int getTotalTestsPerMil() {
		return totalTestsPerMil;
	}

	public void setTotalTestsPerMil(int totalTestsPerMil) {
		this.totalTestsPerMil = totalTestsPerMil;
	}

	public int getTotalPop() {
		return totalPop;
	}

	public void setTotalPop(int totalPop) {
		this.totalPop = totalPop;
	}
}