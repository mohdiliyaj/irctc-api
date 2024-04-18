package in.ashokit.binding;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Passenger {
	
	private String name;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;
	private String gender;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	private String fromStation;
	private String toStation;
	private String trainNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
}
