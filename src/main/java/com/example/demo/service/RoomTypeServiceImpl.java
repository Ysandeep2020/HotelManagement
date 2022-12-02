package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

}
