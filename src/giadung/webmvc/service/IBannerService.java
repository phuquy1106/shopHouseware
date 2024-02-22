package giadung.webmvc.service;

import java.util.List;

import giadung.webmvc.model.Banner;

public interface IBannerService {
	void insert(Banner banner);
	void delete(int id);
	void edit(Banner banner);
	Banner get(int id);
	List<Banner> getAll();
}
