package view.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.services.BeerService;
import business.services.BeerTypeService;
import business.services.CityService;
import domain.entities.Beer;
import domain.entities.BeerType;
import domain.entities.City;
import domain.entities.Volume;
import domain.enums.Storage;

@Controller
@RequestMapping("/beers")
public class BeerController {

	@Autowired
	private BeerService beerService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired 
	private BeerTypeService beerTypeService;

	@GetMapping("/list")
	public ModelAndView getListOfBeers() {
		List<Beer> beers = beerService.listAllBeer();
		ModelAndView mv = new ModelAndView("beer/search/beer-list");
		mv.addObject("beers", beers);

		return mv;
	}

	@GetMapping("/new")
	public ModelAndView addNewBeer() {
		ModelAndView mv = new ModelAndView("beer/new/new-beer");

		mv.addObject("beer", new Beer());

		return mv;
	}

	@PostMapping("/new")
	public ModelAndView saveNewBeer(@PathParam(value = "beer") Beer beer) {
		City city = new City();
		city.setCountry("Brasil");
		city.setName("Diamantina");

		Volume vlm = new Volume();
		vlm.setUnity("ml");
		vlm.setValue(600);

		BeerType beerType = new BeerType();
		beerType.setDescriptionType("Larger");
		beerType.setNameType("Red Larger Ale");

		beer.setOriginCity(city);
		beer.setVolume(vlm);
		beer.setStorageMode(Storage.BOTTLE);
		beer.setAbv(6.);
		beer.setType(beerType);
		
		cityService.addCity(city);
		
		beerTypeService.addBeerType(beerType);
		
		beerService.addBeer(beer);

		return new ModelAndView("beer/search/beer-list");
	}

}
