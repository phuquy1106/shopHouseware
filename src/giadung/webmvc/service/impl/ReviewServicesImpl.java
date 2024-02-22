package giadung.webmvc.service.impl;

import java.util.List;

import giadung.webmvc.dao.ReviewDao;
import giadung.webmvc.dao.impl.ReviewDaoImpl;
import giadung.webmvc.model.Review;
import giadung.webmvc.service.ReviewService;

public class ReviewServicesImpl implements ReviewService {
	ReviewDao reviewDao = new ReviewDaoImpl();
	
	public void insert(Review review) {
		reviewDao.insert(review);
		
	}

	
	public void edit(Review review) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int id) {
		// TODO Auto-generated method stub
		reviewDao.delete(id);
	}

	
	public Review get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Review get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Review> getAll() {
		return reviewDao.getAll();
	}
	
	
	public List<Review> getReviewById(int id) {
		return reviewDao.getReviewById(id);
	}

}
