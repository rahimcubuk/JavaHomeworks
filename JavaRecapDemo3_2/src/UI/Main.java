package UI;

import Adaptors.MernisCheckManager;
import Adaptors.PersonCheckManager;
import Business.Concrete.CampaignManager;
import Business.Concrete.GameManager;
import Business.Concrete.OrderManager;
import Business.Concrete.UserManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Order;
import Entities.User;
import Loggers.FileLogger;
import Loggers.SmsLogger;

public class Main {

	public static void main(String[] args) {
		/*
		 * KULLANICI ISLEMLERI
		 * Yeni Kullanýcý Girme.
		 * * yeni kullanýcý eklenmeden önce TC kimlik numarasý ile kontrol ediliyor. Hatalýysa kayýt iþlemi gerçekleþmiyor.
		 */
		UserManager userManager = new UserManager(new MernisCheckManager(), new FileLogger(), new SmsLogger());
		User validUser = new User(1, "Rahim", "Çubuk", "21260425136", "1994", true);	// Bilgileri doðru bir kullanýcý
		User invalidUser = new User(2, "Elif", "Çubuk", "12345678999", "1994", true);	// Bilgileri hatalý bir kullanýcý

		userManager.add(validUser);
		System.out.println();
		
		userManager.add(invalidUser);
		System.out.println();

		/*
		 * OYUN ve KAMPANYA ISLEMLERI
		 * * Yeni bir kampanya ekleme.
		 * * Eklenen kampanyanýn kaldýrýlmasý.
		 * * Yeni oyun ekleme.
		 * * * Ekelenen oyunlar sýrasýyla kampanyaya dahil, Kampanyaya dahil olmayan ve kampanyasý geçmiþ.
		 * * * Eklenen oyunlarýn kampanyalý ve kampanyasýz fiyatlarý listelenmiþtir.
		 * * Bir oyunun Satýþýný Durdurma.
		 * * * Satýþý durdulan bir oyunun sipariþi verilememeli.
		 */
		CampaignManager campaignManager = new CampaignManager(new FileLogger());
		GameManager gameManager = new GameManager(new FileLogger());
		
		Campaign campaign1 = new Campaign(1, "Yýl Baþý", 10, true); 		// hala geçerli bir kampanya
		campaignManager.add(campaign1);
		System.out.println();
		
		Game game1 = new Game(1, "YYY", 500, campaign1, true); 	// hala geçerli kampanyaya dahil bir oyun	
		Game game2 = new Game(2, "XXX", 500, null, true); 		// herhangi bir kampaynaya dahil olmayan bir oyun		
		
		campaignManager.delete(campaign1); 						// Kampanyanýn geçerliliðini kaldýrýyoruz.
		Game game3 = new Game(3, "VVV", 500, campaign1, true); 	// geçersiz kampanyaya dahil bir oyun
		System.out.println();
		
		listGamePrice(game1, game2, game3);
		System.out.println();
		
		gameManager.delete(game3); // 3. oyunun satýþýný durduruyoruz.
		System.out.println();

		/*
		 * SIPARIS ISLEMLERI
		 * * Sipariþ ekleme. 
		 * 
		 */
		
		OrderManager orderManager = new OrderManager(new PersonCheckManager(), new SmsLogger());
		Order order1 = new Order(1, invalidUser, game1, campaign1, game1.getFinalPrice(), true);
		Order order2 = new Order(1, validUser, game3, campaign1, game1.getFinalPrice(), true);
		Order order3 = new Order(1, validUser, game1, campaign1, game1.getFinalPrice(), true);

		orderManager.add(order1); // hatalý kullanýcý ile satýn alma iþlemi
		orderManager.add(order2); // satýþý olmayan bir oyun satýn alma iþlemi
		orderManager.add(order3); // geçerli bir satýn alma iþlemi
	}
	
	private static void listGamePrice(Game...games) {
		for (Game game : games) {
			System.out.println("Oyunun Adý: " + game.getName());
			System.out.println("Kampanyalý Fiyat: " + game.getFinalPrice() + " / Kampanyasýz fiyat: " + game.getPrice());
		}
	}

}
