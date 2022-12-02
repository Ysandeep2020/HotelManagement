package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.model.HotelModel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public String add(HotelModel hotel) {
		Hotel entity = new Hotel();
		// set default rating is : 0
		entity.setRating(0);
		BeanUtils.copyProperties(hotel, entity);
		hotelRepo.save(entity);
		return "Hotel Added !";
	}

	@Override
	public HotelModel findById(int id) throws Exception {
		HotelModel model = new HotelModel();
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new Exception("Hotel Not found with :" + id));
		BeanUtils.copyProperties(hotel, model);
		return model;
	}

	@Override
	public List<HotelModel> fetchAll() {
		List<HotelModel> models = new ArrayList<>();
		List<Hotel> hotels = hotelRepo.findAll();
		hotels.stream().forEach(hotel -> {
			HotelModel model = new HotelModel();
			BeanUtils.copyProperties(hotel, model);
			models.add(model);
		});
		return models;
	}

}
