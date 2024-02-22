package giadung.webmvc.dao;

import java.util.List;

import giadung.webmvc.model.Boardnew;

public interface BoardnewDao {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	List<Boardnew> getAll(int sizePage,int index);
	List<Boardnew> getAll();
	int getTotalBoardnew();
}
