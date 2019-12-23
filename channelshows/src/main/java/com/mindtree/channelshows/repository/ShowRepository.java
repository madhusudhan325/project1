package com.mindtree.channelshows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshows.entity.Shows;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Integer> {

}
