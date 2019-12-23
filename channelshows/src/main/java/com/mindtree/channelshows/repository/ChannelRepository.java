package com.mindtree.channelshows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshows.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer>{

}
