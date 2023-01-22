package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.vo.v1.LinkVO;
import com.example.demo.exceptions.ConflictException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.models.Link;
import com.example.demo.repositories.LinkRepository;

@Service
public class LinkServices {
	@Autowired
	LinkRepository repository;

	public List<LinkVO> getAll() {
		List<LinkVO> allLinks = DozerMapper.parseListObjects(repository.findAll(), LinkVO.class);
		return allLinks;
	}

	public LinkVO create(LinkVO link) {

		Link entity = DozerMapper.parseObject(link, Link.class);
		List<LinkVO> allLinks = DozerMapper.parseListObjects(repository.findAll(), LinkVO.class);

		for (LinkVO linkInDB : allLinks) {
			if (entity.getId().equals(linkInDB.getId())) {
				throw new ConflictException("This link is registered!");
			}
		}
		LinkVO vo = DozerMapper.parseObject(repository.save(entity), LinkVO.class);
		return vo;

	}

	public LinkVO findById(String id) {

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, LinkVO.class);
	}

	public LinkVO update(LinkVO link) {


		var entity = repository.findById(link.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setOriginalUrl(link.getOriginalUrl());

		var vo = DozerMapper.parseObject(repository.save(entity), LinkVO.class);
		return vo;
	}

	public void delete(String id) {

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
