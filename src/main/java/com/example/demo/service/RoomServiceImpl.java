package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.model.RoomRequest;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository repo;
	@Autowired
	private HotelRepository hotelReop;

	@Override
	public String add(RoomRequest request) throws Exception {
		Room room = new Room();
		// update total Rooms into Hotel
		Hotel hotel = updateRoomsToHotel(request);
		BeanUtils.copyProperties(request, room);
		room.setHotelCode(hotel);
		repo.save(room);
		return "Room Added !";
	}

	private Hotel updateRoomsToHotel(RoomRequest request) throws Exception {
		Hotel hotel = hotelReop.findById(request.getHotelCode())
				.orElseThrow(() -> new Exception("Hotel Not avalable with this id:" + request.getHotelCode()));
		int preTotal = hotel.getTotalRoom();
		hotel.setTotalRoom(preTotal + 1);
		return hotel;
	}

}
