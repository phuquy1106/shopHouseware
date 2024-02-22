package giadung.webmvc.service.impl;

import java.util.List;

import giadung.webmvc.dao.IbannerDao;
import giadung.webmvc.dao.impl.BannerDaoImpl;
import giadung.webmvc.model.Banner;
import giadung.webmvc.service.IBannerService;

public class BannerServicesImpl implements IBannerService{
	IbannerDao bannerDao = new BannerDaoImpl();
	
	public void insert(Banner banner) {
		bannerDao.insert(banner);
		
	}

	
	public void delete(int id) {
		bannerDao.delete(id);
		
	}

	
	public void edit(Banner banner1) {
	
		Banner oldBanner = bannerDao.get(Integer.parseInt(banner1.getId()));
	
		oldBanner.setName(banner1.getName());
		oldBanner.setNote(banner1.getNote());
		oldBanner.setImg(banner1.getImg());
		bannerDao.edit(oldBanner);
		
	}

	
	public List<Banner> getAll() {
		// TODO Auto-generated method stub
		return bannerDao.getAll();
	}

	
	public Banner get(int id) {
		return bannerDao.get(id);
	}

}
