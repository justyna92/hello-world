package pl.springboot.helloworld;

public class DayOfYear {
	
	private int day;
	private String ordinalNumberSuffix;
	private String month;
	private int year;
	private String dayName;
	private int numberDayOfYear;
	private int numberOfDaysToTheEndOfYear;
	
	public DayOfYear(){
		this.day = 0;
		this.ordinalNumberSuffix = "none";
		this.month = "none";
		this.year = 0;
		this.numberDayOfYear = 0;
		this.numberOfDaysToTheEndOfYear = 0;
		this.dayName = "none";
	}
	public DayOfYear(int day, String ordinalNumberSuffix, String month, int year, int numberDayInYear, int numberOfDayToTheEndOfYear, String dayName) {
		super();
		this.day = day;
		this.ordinalNumberSuffix = ordinalNumberSuffix;
		this.month = month;
		this.year = year;
		this.numberDayOfYear = numberDayInYear;
		this.numberOfDaysToTheEndOfYear = numberOfDayToTheEndOfYear;
		this.dayName = dayName;
	}
	public String getOrdinalNumberSuffix() {
		return ordinalNumberSuffix;
	}
	public void setOrdinalNumberSuffix(String ordinalNumberSuffix) {
		this.ordinalNumberSuffix = ordinalNumberSuffix;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumberDayOfYear() {
		return numberDayOfYear;
	}
	public void setNumberDayOfYear(int numberDayInYear) {
		this.numberDayOfYear = numberDayInYear;
	}
	public int getNumberOfDaysToTheEndOfYear() {
		return numberOfDaysToTheEndOfYear;
	}
	public void setNumberOfDaysToTheEndOfYear(int numberOfDayToTheEndOfYear) {
		this.numberOfDaysToTheEndOfYear = numberOfDayToTheEndOfYear;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
}
