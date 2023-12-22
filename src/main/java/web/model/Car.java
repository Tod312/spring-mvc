package web.model;

import java.time.LocalDate;

public class Car {
	private Integer series;
	private String name;
	private LocalDate date;
	
	public Car() {}

	public Car(Integer series, String name, LocalDate date) {
		this.series = series;
		this.name = name;
		this.date = date;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Car [version=" + series + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
