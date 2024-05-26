package com.jspiders.cardekhomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekhomvc.pojo.AdminPOJO;
import com.jspiders.cardekhomvc.pojo.CarPOJO;
import com.jspiders.cardekhomvc.service.CarService;


@Controller
public class CarController {
	
	@Autowired
	private CarService service;

	//Home page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false)AdminPOJO admin,
						ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Add page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Add student Controller
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam String carName,
								@RequestParam String model,
								@RequestParam String  fuel,
								@RequestParam double price ,
								ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.addCar(carName, model, fuel, price);
			
			//Success
			if (pojo != null) {
				map.addAttribute("msg","Car Data inserted successfully..!");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				return "Add";
			}
			//Failure
			map.addAttribute("msg","Data not inserted..!");
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
		
	}
	
	//Search page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false)AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Search student Controller
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);
			//Success
			if (pojo != null) {
				map.addAttribute("car",pojo);
				map.addAttribute("msg","Car data found..!");
				return "Search";
			}
			//Failure
			map.addAttribute("msg", "Car data not found..!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Remove page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			//Success
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			map.addAttribute("msg", "No data present..!");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Remove student Controller
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.removeCar(id);
			List<CarPOJO> cars = service.findAllCars();
			
			//Success
			if (pojo != null) {
				map.addAttribute("msg", "Data removed successfully..!");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			//Failure
			map.addAttribute("msg", "Data does not exist..!");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update form Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);
			//Success
			if (pojo != null) {
				map.addAttribute("car",pojo);
				return "Update";
			}
			//Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car data not found..!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update Car Controller
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								@RequestParam String carName,
								@RequestParam String model,
								@RequestParam String  fuel,
								@RequestParam double price ,
								ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.updateCar(id, carName, model, fuel, price);
			//Success
			if (pojo != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", "Car Data updated successfully..!");
				map.addAttribute("cars", cars);
				return "Update";
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Data not updated..!");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
}