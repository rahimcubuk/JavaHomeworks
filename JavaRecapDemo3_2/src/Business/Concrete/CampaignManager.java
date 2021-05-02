package Business.Concrete;

import Business.Abstract.ICampaignService;
import Entities.Campaign;
import Loggers.ILogger;

public class CampaignManager implements ICampaignService {

	private ILogger[] loggers;

	public CampaignManager(ILogger... loggers) {
		this.loggers = loggers;
	}

	@Override
	public void add(Campaign campaign) {
		System.out.println(campaign.getDescription() + " kampanyas� sisteme kaydedildi.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanyas� sisteme kaydedildi.");
		}
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println(campaign.getDescription() + " kampanya bilgileri g�ncellendi.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanya bilgileri g�ncellendi.");
		}
	}

	@Override
	public void delete(Campaign campaign) {
		campaign.setDiscountApplied(false);
		System.out.println(campaign.getDescription() + " kampanya bilgileri kald�r�ld�.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanya bilgileri kald�r�ld�.");
		}
	}

}
