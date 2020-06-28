package com.example.parkingslot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingslot.model.SlotUpdation;

@Repository
public interface SlotDao extends CrudRepository<SlotUpdation, Integer> {





}
