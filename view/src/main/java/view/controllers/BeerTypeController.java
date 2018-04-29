package view.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.services.BeerTypeService;
import domain.entities.BeerType;

@Controller
@RequestMapping("/beer-type")
public class BeerTypeController {
	
	@Autowired
	private BeerTypeService beerTypeService;
	
	@GetMapping("/list")
	public ModelAndView getListOfBeerType() {
		
		List<BeerType> beerTypes = beerTypeService.findAllGroupedByNameType();
		ModelAndView mv = new ModelAndView("/beer/search/beer-type-list");
		
		mv.addObject("beerTypes", beerTypes);
		return mv;
	}
	
	
	@GetMapping("/new")
	public ModelAndView addNewBeerType(BeerType beerType) {
		ModelAndView modelAndView = new ModelAndView("beer/new/new-type-beer");
		
		modelAndView.addObject("beerType", beerType);
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveBeerType(@PathParam(value="beerType") BeerType beerType) {
		try {			
			beerTypeService.addBeerType(beerType);
		} catch (Exception e) {
			
		}
		
		return new ModelAndView("beer/search/beer-type-list");
	}

}
