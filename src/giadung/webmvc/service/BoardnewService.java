package giadung.webmvc.service;

import java.util.List;

import giadung.webmvc.model.Boardnew;

public interface BoardnewService {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	List<Boardnew> getAll(int sizePage,int index);
	int getTotalBoardnew();
	List<Boardnew> getAll();
}
