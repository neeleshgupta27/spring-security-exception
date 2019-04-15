package com.neel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neel.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
	
}
