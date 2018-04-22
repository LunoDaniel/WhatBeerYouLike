package view.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import business.services.CityService;
import domain.entities.City;

@Controller
@RequestMapping("beer-city")
public class BeerCityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/list")
	public ModelAndView getListOfCities() {
		List<City> cities = cityService.listAllCity();

		ModelAndView mv = new ModelAndView("beer/search/beer-city-list");
		mv.addObject("cities", cities);

		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editBeerCity(@PathVariable Long id) {
		return addNewBeerCity(cityService.findCityById(id));
	}
	
	@GetMapping("/new")
	public ModelAndView addNewBeerCity(City city) {
		ModelAndView mv = new ModelAndView("beer/new/new-city-beer");
		
		mv.addObject("beerCity", city);

		return mv;
	}

	@PostMapping("/new")
	public ModelAndView saveNewCity(@PathParam(value = "city") City city, BindingResult result, RedirectAttributes attributes) {
		
		
		cityService.addCity(city);
		
		return new ModelAndView("beer/search/beer-city-list");
	}

}
