package com.jspiders.cardekhomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhomvc.pojo.CarPOJO;
import com.jspiders.cardekhomvc.repository.CarRepository;


@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String carName, String model, String fuel,double price) {
		CarPOJO pojo = repository.addCar(carName, model, fuel, price);
		return pojo;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo = repository.searchCar(id);
		return pojo;
	}

	public List<CarPOJO> findAllCars() {
		List<CarPOJO> cars = repository.findAllCars();
		return cars;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo = repository.removeCar(id);
		return pojo;
	}

	public CarPOJO updateCar(int id, String carName, String model, String fuel,double price) {
		CarPOJO pojo = repository.updateCar(id, carName, model, fuel, price);
		return pojo;
	}

}