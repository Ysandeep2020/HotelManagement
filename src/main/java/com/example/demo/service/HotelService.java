package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HotelModel;

public interface HotelService {
	public String add(HotelModel hotel);

	public HotelModel findById(int id) throws Exception;

	public List<HotelModel> fetchAll();
}
