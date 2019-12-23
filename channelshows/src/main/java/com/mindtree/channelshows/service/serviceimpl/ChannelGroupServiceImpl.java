package com.mindtree.channelshows.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.channelshows.dto.ChannelDto;
import com.mindtree.channelshows.dto.ChannelGroupDto;
import com.mindtree.channelshows.dto.ShowDto;
import com.mindtree.channelshows.entity.Channel;
import com.mindtree.channelshows.entity.ChannelGroup;
import com.mindtree.channelshows.entity.Shows;
import com.mindtree.channelshows.exception.serviceexception.NoSuchChannelFoundException;
import com.mindtree.channelshows.exception.serviceexception.NoSuchChannelGroupFoundException;
import com.mindtree.channelshows.exception.serviceexception.ServiceException;
import com.mindtree.channelshows.repository.ChannelGroupRepository;
import com.mindtree.channelshows.repository.ChannelRepository;
import com.mindtree.channelshows.repository.ShowRepository;
import com.mindtree.channelshows.service.ChannelGroupService;

@Service
public class ChannelGroupServiceImpl implements ChannelGroupService {
	@Autowired
	private ChannelGroupRepository channelGroupRepository;
	@Autowired
	private ChannelRepository channelRepository;
	@Autowired
	private ShowRepository showRepository;

	@Override
	public String addChannelGroupToDatabase(ChannelGroupDto channelGroupDto) {
		ChannelGroup channelGroup = new ChannelGroup();
		channelGroup.setChannelGroupId(channelGroupDto.getChannelGroupId());
		channelGroup.setChannelGroupName(channelGroupDto.getChannelGroupName());
		channelGroupRepository.save(channelGroup);
		return "inserted";
	}

	@Override
	public String addChannelToDatabase(ChannelDto channelDto) {
		Channel channel = new Channel();
		channel.setChannelId(channelDto.getChannelId());
		channel.setChannelName(channelDto.getChannelName());
		channel.setChannelPricre(channelDto.getChannelPricre());
		channelRepository.save(channel);
		return "inserted";
	}

	@Override
	public String addShowToDatabase(ShowDto showDto) {
		Shows shows = new Shows();
		shows.setShowId(showDto.getShowId());
		shows.setShowName(showDto.getShowName());
		showRepository.save(shows);
		return "inserted";
	}

	@Override
	public String assignChannelToChannelGroup(int channelGroupId, int channelId) throws ServiceException {
		try {
			ChannelGroup channelGroup = channelGroupRepository.findById(channelGroupId)
					.orElseThrow(() -> new NoSuchChannelGroupFoundException("No Channel Group Found with that Id"));
		} catch (NoSuchChannelGroupFoundException e) {
			throw new ServiceException(e.getMessage());
		}
		ChannelGroup channelGroup = channelGroupRepository.findById(channelGroupId).get();
		Channel channel = channelRepository.findById(channelId).get();
		channel.setChannelGroup(channelGroup);
		channelRepository.save(channel);
		return "assigned";
	}

	@Override
	public String assignShowToChanne(int channelId, int showId) throws ServiceException {
		try {
			Channel channel = channelRepository.findById(channelId)
					.orElseThrow(() -> new NoSuchChannelFoundException("No Channel found with that id"));
		} catch (NoSuchChannelFoundException e) {
			throw new ServiceException(e.getMessage());
		}
		Channel channel = channelRepository.findById(channelId).get();
		Shows shows = showRepository.findById(showId).get();
		shows.setChannel(channel);
		showRepository.save(shows);
		return "assigned";
	}

	@Override
	public ChannelGroupDto getAllDataPresentInDataBaseOfParticularChannelGroupByGroupIdInSortedOrder(
			int channelGroupId) {

		ChannelGroup channelGroup = channelGroupRepository.findById(channelGroupId).get();
		ChannelGroupDto channelGroupDto = new ChannelGroupDto();
		channelGroupDto.setChannelGroupId(channelGroup.getChannelGroupId());
		channelGroupDto.setChannelGroupName(channelGroup.getChannelGroupName());
		List<ChannelDto> channelDtos = new ArrayList<ChannelDto>();
		for (Channel channel : channelGroup.getChannels()) {
			ChannelDto channelDto = new ChannelDto();
			channelDto.setChannelId(channel.getChannelId());
			channelDto.setChannelName(channel.getChannelName());
			channelDto.setChannelPricre(channel.getChannelPricre());
			channelDtos.add(channelDto);
			List<ShowDto> showDtos = new ArrayList<ShowDto>();
			for (Shows shows : channel.getShows()) {
				ShowDto showDto = new ShowDto();
				showDto.setShowId(shows.getShowId());
				showDto.setShowName(shows.getShowName());
				showDtos.add(showDto);
			}
			channelDto.setShowDtos(showDtos);
		}
		Collections.sort(channelDtos);
		channelGroupDto.setChannelDtos(channelDtos);
		return channelGroupDto;
	}

}
