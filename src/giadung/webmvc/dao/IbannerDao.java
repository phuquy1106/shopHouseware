package giadung.webmvc.dao;
import java.util.List;

import giadung.webmvc.model.Banner;

public interface IbannerDao {
	void insert(Banner banner);
	void delete(int id);
	Banner get(int id);
	void edit(Banner banner);
	List<Banner> getAll();
}
