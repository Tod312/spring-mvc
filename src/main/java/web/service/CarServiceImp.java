package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.CarDao;
import web.model.Car;

@Service
public class CarServiceImp implements CarService{
	
	private final CarDao carDaoImpl;
	
	@Autowired
	public CarServiceImp(CarDao carDaoImpl) {
		this.carDaoImpl = carDaoImpl;
	}
	
	public List<Car> getCars(Integer count){
		if(count == 5 || count > 5)
			return getAll();
		else
			return getByCount(count);
	}


	private List<Car> getByCount(Integer count) {
		if (count <= 0) {
			throw new IllegalArgumentException("The number must be greater than or equal to 1.");
		}else {
			return carDaoImpl.getByCount(count);
		}
	}
	
	
	private List<Car> getAll(){
		return carDaoImpl.getAll();
	}
	
	
}
