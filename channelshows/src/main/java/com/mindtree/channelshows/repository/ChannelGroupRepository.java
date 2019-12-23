package com.mindtree.channelshows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshows.entity.ChannelGroup;

@Repository
public interface ChannelGroupRepository extends JpaRepository<ChannelGroup, Integer>{

}
