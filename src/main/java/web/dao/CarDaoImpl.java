package web.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import web.model.Car;

public class CarDaoImpl implements CarDao{
	
	private final List<Car> carsStorage;
	
	@Autowired
	public CarDaoImpl(List<Car> carsStorage) {
		this.carsStorage = carsStorage;
	}
	
	@Override
	public List<Car> getByCount(int count) {
		return carsStorage.stream().limit(count).collect(Collectors.toList());
	}
	
	@Override
	public List<Car> getAll() {
		return carsStorage;
	}
	    
}
