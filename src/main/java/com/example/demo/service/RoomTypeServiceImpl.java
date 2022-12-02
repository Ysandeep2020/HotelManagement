package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Attachment;
import com.example.demo.entity.Room;
import com.example.demo.entity.RoomType;
import com.example.demo.model.RoomTypeRequest;
import com.example.demo.repository.AttachmentRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.RoomTypeRepository;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	@Autowired
	private RoomTypeRepository repo;
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private AttachmentRepository attRepo;

	@Override
	public String add(RoomTypeRequest request) throws Exception {
		RoomType entity = new RoomType();
		BeanUtils.copyProperties(request, entity);
		Room room = roomRepo.findById(request.getRoomId())
				.orElseThrow(() -> new Exception("No Room for this id:" + request.getRoomId()));
		entity.setRoomId(room);
		repo.save(entity);
		return "Room Type Added!";
	}

//	@Override
//	public String add(RoomTypeRequest request, MultipartFile[] files) throws Exception {
//		List<Attachment> attachments = null;
//		RoomType entity = new RoomType();
//		attachments = getListOfAttachment(files);
//
//		BeanUtils.copyProperties(request, entity);
//		Room room = roomRepo.findById(request.getRoomId())
//				.orElseThrow(() -> new Exception("No Room for this id:" + request.getRoomId()));
//		entity.setRoomId(room);
//		entity.setAttachment(attachments);
//		repo.save(entity);
//		return "Room Type Added With Image...";
//	}

	private List<Attachment> getListOfAttachment(MultipartFile[] files) {
		List<Attachment> attachments = new ArrayList<>();
		if (files != null) {
			Arrays.asList(files).stream().forEach(file -> {
				Attachment attachment = new Attachment();
				attachment.setFileName(file.getOriginalFilename());
				attachment.setFileType(file.getContentType());
				try {
					attachment.setData(file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				attRepo.save(attachment);
				attachments.add(attachment);
			});
		}
		return attachments;
	}

	@Override
	public RoomTypeRequest findById(int id) throws Exception {
		RoomTypeRequest model = new RoomTypeRequest();
		RoomType roomType = repo.findById(id).orElseThrow(() -> new Exception("No RoomType with id:" + id));
		BeanUtils.copyProperties(roomType, model);
		int id2 = roomType.getRoomId().getId();
		model.setRoomId(id2);
		return model;
	}

	@Override
	public List<RoomTypeRequest> fetchAll() {
		List<RoomTypeRequest> models = new ArrayList<>();
		List<RoomType> roomTypes = repo.findAll();
		roomTypes.stream().forEach(roomType -> {
			RoomTypeRequest model = new RoomTypeRequest();
			BeanUtils.copyProperties(roomType, model);
			model.setRoomId(roomType.getRoomId().getId());
			models.add(model);
		});
		return models;
	}

}
