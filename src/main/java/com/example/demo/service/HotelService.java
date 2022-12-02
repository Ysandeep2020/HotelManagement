package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HotelRequest;

public interface HotelService {
	public String add(HotelRequest hotel);

	public HotelRequest findById(int id) throws Exception;

	public List<HotelRequest> fetchAll();
}
