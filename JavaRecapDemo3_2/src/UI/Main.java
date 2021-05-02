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
		 * Yeni Kullan�c� Girme.
		 * * yeni kullan�c� eklenmeden �nce TC kimlik numaras� ile kontrol ediliyor. Hatal�ysa kay�t i�lemi ger�ekle�miyor.
		 */
		UserManager userManager = new UserManager(new MernisCheckManager(), new FileLogger(), new SmsLogger());
		User validUser = new User(1, "Rahim", "�ubuk", "21260425136", "1994", true);	// Bilgileri do�ru bir kullan�c�
		User invalidUser = new User(2, "Elif", "�ubuk", "12345678999", "1994", true);	// Bilgileri hatal� bir kullan�c�

		userManager.add(validUser);
		System.out.println();
		
		userManager.add(invalidUser);
		System.out.println();

		/*
		 * OYUN ve KAMPANYA ISLEMLERI
		 * * Yeni bir kampanya ekleme.
		 * * Eklenen kampanyan�n kald�r�lmas�.
		 * * Yeni oyun ekleme.
		 * * * Ekelenen oyunlar s�ras�yla kampanyaya dahil, Kampanyaya dahil olmayan ve kampanyas� ge�mi�.
		 * * * Eklenen oyunlar�n kampanyal� ve kampanyas�z fiyatlar� listelenmi�tir.
		 * * Bir oyunun Sat���n� Durdurma.
		 * * * Sat��� durdulan bir oyunun sipari�i verilememeli.
		 */
		CampaignManager campaignManager = new CampaignManager(new FileLogger());
		GameManager gameManager = new GameManager(new FileLogger());
		
		Campaign campaign1 = new Campaign(1, "Y�l Ba��", 10, true); 		// hala ge�erli bir kampanya
		campaignManager.add(campaign1);
		System.out.println();
		
		Game game1 = new Game(1, "YYY", 500, campaign1, true); 	// hala ge�erli kampanyaya dahil bir oyun	
		Game game2 = new Game(2, "XXX", 500, null, true); 		// herhangi bir kampaynaya dahil olmayan bir oyun		
		
		campaignManager.delete(campaign1); 						// Kampanyan�n ge�erlili�ini kald�r�yoruz.
		Game game3 = new Game(3, "VVV", 500, campaign1, true); 	// ge�ersiz kampanyaya dahil bir oyun
		System.out.println();
		
		listGamePrice(game1, game2, game3);
		System.out.println();
		
		gameManager.delete(game3); // 3. oyunun sat���n� durduruyoruz.
		System.out.println();

		/*
		 * SIPARIS ISLEMLERI
		 * * Sipari� ekleme. 
		 * 
		 */
		
		OrderManager orderManager = new OrderManager(new PersonCheckManager(), new SmsLogger());
		Order order1 = new Order(1, invalidUser, game1, campaign1, game1.getFinalPrice(), true);
		Order order2 = new Order(1, validUser, game3, campaign1, game1.getFinalPrice(), true);
		Order order3 = new Order(1, validUser, game1, campaign1, game1.getFinalPrice(), true);

		orderManager.add(order1); // hatal� kullan�c� ile sat�n alma i�lemi
		orderManager.add(order2); // sat��� olmayan bir oyun sat�n alma i�lemi
		orderManager.add(order3); // ge�erli bir sat�n alma i�lemi
	}
	
	private static void listGamePrice(Game...games) {
		for (Game game : games) {
			System.out.println("Oyunun Ad�: " + game.getName());
			System.out.println("Kampanyal� Fiyat: " + game.getFinalPrice() + " / Kampanyas�z fiyat: " + game.getPrice());
		}
	}

}
