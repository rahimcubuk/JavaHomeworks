package Business.Concrete;

import Business.Abstract.ICampaignService;
import Entities.Campaign;
import Loggers.ILogger;
import Utils.LoggerAspect;

public class CampaignManager implements ICampaignService {

	private ILogger[] loggers;

	public CampaignManager(ILogger... loggers) {
		this.loggers = loggers;
	}

	@Override
	public void add(Campaign campaign) {
		System.out.println(campaign.getDescription() + " kampanyasý sisteme kaydedildi.");
		LoggerAspect.run(campaign.getDescription() + " kampanyasý sisteme kaydedildi.", loggers);
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println(campaign.getDescription() + " kampanya bilgileri güncellendi.");
		LoggerAspect.run(campaign.getDescription() + " kampanya bilgileri güncellendi.", loggers);
	}

	@Override
	public void delete(Campaign campaign) {
		campaign.setDiscountApplied(false);
		System.out.println(campaign.getDescription() + " kampanya bilgileri kaldýrýldý.");
		LoggerAspect.run(campaign.getDescription() + " kampanya bilgileri kaldýrýldý.", loggers);
	}
}
