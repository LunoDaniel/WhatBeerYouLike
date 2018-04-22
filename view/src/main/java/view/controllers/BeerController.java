package view.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import business.services.BeerService;
import business.services.BeerTypeService;
import business.services.CityService;
import domain.entities.Beer;
import domain.entities.BeerType;
import domain.entities.City;

@Controller
@RequestMapping("/beer")
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

	@GetMapping("/{id}")
	public ModelAndView editBeer(@PathVariable Long id) {
		return addNewBeer(beerService.findOneBeer(id));
	}

	@GetMapping("/new")
	public ModelAndView addNewBeer(Beer beer) {
		ModelAndView mv = new ModelAndView("beer/new/new-beer");
		List<BeerType> beersType = beerTypeService.findAllGroupedByNameType();
		List<City> cities = cityService.findAllGroupByName();

		mv.addObject("beer", beer);
		mv.addObject("beersType", beersType);
		mv.addObject("cities", cities);

		return mv;
	}

	@PostMapping("/new")
	public ModelAndView saveNewBeer(@PathParam(value = "beer") Beer beer, BindingResult result, RedirectAttributes attributes) {

		boolean isCityNull = beer.getOriginCity() != null;
		boolean isTypeBeerNull = beer.getType().getId() != null;

		if (result.hasErrors()) {
			return addNewBeer(beer);
		}

		if (isCityNull) {
			beer.setOriginCity(insertNewCity(beer.getOriginCity().getId()));
		}

		if (isTypeBeerNull) {
			beer.setType(insertNewTypeBeer(beer.getType().getId()));
		}

		beerService.addBeer(beer);

		attributes.addFlashAttribute("message", "Cerveja Salva com sucesso.");

		return new ModelAndView("beer/search/beer-list");
	}
	
	@DeleteMapping("/remove/{id}")
	public String removeBeer(@PathVariable Long id, RedirectAttributes attributes) {
		Beer beer = beerService.findOneBeer(id);
		beerService.removeBeer(beer);
		attributes.addFlashAttribute("message", "Cerveja Removida com sucesso.");
		
		return "redirect:/beer/list";
	}

	private BeerType insertNewTypeBeer(Long typeBeerId) {
		BeerType beerType = this.beerTypeService.findTypeBeerById(typeBeerId);

		if (null != beerType) {
			beerType = this.beerTypeService.addBeerType(beerType);
		}

		return beerType;
	}

	private City insertNewCity(Long cityId) {
		City city = this.cityService.findCityById(cityId);

		if (null != city) {
			city = this.cityService.addCity(city);
		}

		return city;
	}

}
