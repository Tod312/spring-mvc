package web.dao;

import java.util.List;

import web.model.Car;

public interface CarDao{
	List<Car> getByCount(int count);
	
	List<Car> getAll();
}
