package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Hotel;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.HotelRequest;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public String add(HotelRequest hotel) {
		Hotel entity = new Hotel();
		// set default rating is : 0
		entity.setRating(0);
		BeanUtils.copyProperties(hotel, entity);
		hotelRepo.save(entity);
		return "Hotel Added !";
	}

	@Override
	public HotelRequest findById(int id) throws Exception {
		HotelRequest model = new HotelRequest();
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new Exception("Hotel Not found with :" + id));
		BeanUtils.copyProperties(hotel, model);
		return model;
	}

	@Override
	public List<HotelRequest> fetchAll() {
		List<HotelRequest> models = new ArrayList<>();
		List<Hotel> hotels = hotelRepo.findAll();
		hotels.stream().forEach(hotel -> {
			HotelRequest model = new HotelRequest();
			BeanUtils.copyProperties(hotel, model);
			models.add(model);
		});
		return models;
	}

}
