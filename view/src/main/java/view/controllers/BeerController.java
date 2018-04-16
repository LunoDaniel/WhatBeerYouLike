package view.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.services.BeerService;
import domain.entities.Beer;

@Controller
@RequestMapping("/beers")
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping("/list")
	public ModelAndView getListOfBeers() {
		List<Beer> beers = beerService.listAllBeer();
		ModelAndView mv = new ModelAndView("beer/beer-list");
		mv.addObject("beers", beers);
		
		return mv;
	}

}
