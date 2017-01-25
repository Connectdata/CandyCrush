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

import model.mapping.Bonus;
import model.mapping.PlayerBonus;
import model.mapping.PlayerBonusFull;
import model.mapping.Purchase;
import model.service.BonusService;
import model.service.PurchaseService;

@Controller
public class ActionBonus
{
	
	
	@Autowired
	BonusService bonusService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	
	@RequestMapping(value=API.BONUS,method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Bonus>> getAllPlayerBonus(@RequestParam(required=false)Long idbonus) 
	{
		
		if(idbonus == null|| idbonus<=0)
		{
			idbonus = (long) -1;
		}
		
		List<Bonus> resp = bonusService.getBonus(idbonus);
		
		return new ResponseEntity<List<Bonus>>(resp,HttpStatus.OK);

	}
	
	
	
	
	@RequestMapping(value=API.PLAYER_BONUS,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Purchased> PlayerBuyingBonus(@RequestParam(required=true)Long idplayer,@RequestParam(required=true)Long idbonus,@RequestParam(required=false)Integer number) 
	{
		System.out.println("INACTION_BONUS");
		
		if(number==null)
		{
			number = 1;
		}
		
		
		Purchase resp = purchaseService.buying(idplayer, idbonus, number);
		
		if(resp != null)
		{
			
			Purchased prd = new Purchased();
			prd.setPurchase(resp);
			prd.setPlayerBonus(bonusService.getPlayerBonus(idplayer, idbonus));
			
			return new ResponseEntity<Purchased>(prd,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		
		

	}
	
	
	
	public class Purchased
	{
		Purchase purchase;
		PlayerBonusFull playerBonus;
		public Purchase getPurchase() {
			return purchase;
		}
		public void setPurchase(Purchase purchase) {
			this.purchase = purchase;
		}
		public PlayerBonusFull getPlayerBonus() {
			return playerBonus;
		}
		public void setPlayerBonus(PlayerBonusFull playerBonus) {
			this.playerBonus = playerBonus;
		}
		public Purchased(Purchase purchase, PlayerBonusFull playerBonus) {
			super();
			this.purchase = purchase;
			this.playerBonus = playerBonus;
		}
		public Purchased() {
			super();
		}
		@Override
		public String toString() {
			return "Purchased [purchase=" + purchase + ", playerBonus=" + playerBonus + "]";
		}
		
		
		
		
		
		
	}
	

}
