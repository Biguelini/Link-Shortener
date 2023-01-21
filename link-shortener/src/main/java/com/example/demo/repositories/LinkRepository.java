package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Link;

public interface LinkRepository extends JpaRepository<Link, String> {

}
