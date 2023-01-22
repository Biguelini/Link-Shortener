package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.vo.v1.LinkVO;
import com.example.demo.services.LinkServices;

@RestController
@RequestMapping("/")
@CrossOrigin
public class LinkController {
	@Autowired
	private LinkServices service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LinkVO> getAll() {

		return service.getAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(@PathVariable(value = "id") String id) {

		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(service.findById(id).getOriginalUrl()))
				.build();

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LinkVO create(@RequestBody LinkVO link) {

		return service.create(link);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkVO update(@RequestBody LinkVO link) {
		return service.update(link);
	}
}
