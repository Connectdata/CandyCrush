package controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.mapping.AgencyContent;
import model.mapping.Bonus;
import model.mapping.Prize;
import model.service.AgencyService;
import model.service.ClassicalService;
import model.service.PrizeService;

@Controller
public class ActionPrize 
{
	
	
	@Autowired
	ClassicalService classicalService;
	
	@Autowired
	PrizeService prizeService;
	
	@Autowired
	AgencyService agencyService;
	
	
	
	@RequestMapping(value=API.PRIZE,method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Prize>> getAllPrize() 
	{
		
		List<Prize> resp = prizeService.getAllPrize();
		return new ResponseEntity<List<Prize>>(resp,HttpStatus.OK);

	}
	
	
	@RequestMapping(value=API.PRIZE_AGENCY,method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<AgencyContent>> AgnecyContentThis(@RequestParam(required=true)long idprize) 
	{
		
		List<AgencyContent> resp = agencyService.GetAllAgencyHasThisPrize(idprize);
		return new ResponseEntity<List<AgencyContent>>(resp,HttpStatus.OK);

	}

}
