package giadung.webmvc.service.impl;

import java.util.List;

import giadung.webmvc.dao.BoardnewDao;
import giadung.webmvc.dao.impl.BoardnewDaoImpl;
import giadung.webmvc.model.Boardnew;
import giadung.webmvc.service.BoardnewService;

public class BoardnewServicesImpl implements BoardnewService{
	BoardnewDao boardnewDao = new BoardnewDaoImpl();

	
	public void insert(Boardnew boardnew) {
		// TODO Auto-generated method stub
		boardnewDao.insert(boardnew);
	}

	
	public void edit(Boardnew newBoardnew) {
		// TODO Auto-generated method stub
		Boardnew oldBoardnew = boardnewDao.get(Integer.parseInt(newBoardnew.getId()));
		System.out.println("xem thử có chưa "+oldBoardnew);
		oldBoardnew.setTitle(newBoardnew.getTitle());
		oldBoardnew.setContent(newBoardnew.getContent());
		oldBoardnew.setImage_link(newBoardnew.getImage_link());
		oldBoardnew.setCreated(newBoardnew.getCreated());
		boardnewDao.edit(oldBoardnew);
	}
	
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		boardnewDao.delete(id);
	}

	
	public Boardnew get(int id) {
		return boardnewDao.get(id);
	}

	
	public Boardnew get(String name) {
		return boardnewDao.get(name);
	}

	
	public List<Boardnew> getAll(int sizePage,int index) {
		return boardnewDao.getAll(sizePage,index);
	}


	public int getTotalBoardnew() {
		// TODO Auto-generated method stub
		return boardnewDao.getTotalBoardnew();
	}


	public List<Boardnew> getAll() {
		// TODO Auto-generated method stub
		return boardnewDao.getAll();
	}
	
}
