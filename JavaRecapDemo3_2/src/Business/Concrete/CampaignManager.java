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
		System.out.println(campaign.getDescription() + " kampanyasý sisteme kaydedildi.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanyasý sisteme kaydedildi.");
		}
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println(campaign.getDescription() + " kampanya bilgileri güncellendi.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanya bilgileri güncellendi.");
		}
	}

	@Override
	public void delete(Campaign campaign) {
		campaign.setDiscountApplied(false);
		System.out.println(campaign.getDescription() + " kampanya bilgileri kaldýrýldý.");
		for (ILogger logger : loggers) {
			logger.log(campaign.getDescription() + " kampanya bilgileri kaldýrýldý.");
		}
	}

}
