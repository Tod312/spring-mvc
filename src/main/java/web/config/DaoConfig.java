package web.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;

@Configuration
@ComponentScan("web")
public class DaoConfig {

	 @Bean
	 public List<Car> carsStorage(){
	    List<Car> cars = new ArrayList<>();
	    cars.add(new Car(13324, "Audi", LocalDate.of(1998, 7, 11)));
	    cars.add(new Car(12298, "Mercedez", LocalDate.of(2000, 3, 4)));
	    cars.add(new Car(77611, "BMW", LocalDate.of(1998, 12, 21)));
	    cars.add(new Car(12298, "Volvo", LocalDate.of(2005, 1, 10)));
	    cars.add(new Car(12298, "Honda", LocalDate.of(2007, 11, 28)));
	    return cars;
	 }
	 
	 @Bean
	 public CarDao carDao() {
		 return new CarDaoImpl(carsStorage());
	 }
}
