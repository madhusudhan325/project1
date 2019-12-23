package com.mindtree.channelshows.service;

import org.springframework.stereotype.Service;

import com.mindtree.channelshows.dto.ChannelDto;
import com.mindtree.channelshows.dto.ChannelGroupDto;
import com.mindtree.channelshows.dto.ShowDto;
import com.mindtree.channelshows.exception.serviceexception.ServiceException;

@Service
public interface ChannelGroupService {

	/**
	 * @param channelGroupDto
	 * @return message as inserted
	 */
	public String addChannelGroupToDatabase(ChannelGroupDto channelGroupDto);

	/**
	 * @param channelDto
	 * @return message as inserted
	 */
	public String addChannelToDatabase(ChannelDto channelDto);

	/**
	 * @param showDto
	 * @return message as inserted
	 */
	public String addShowToDatabase(ShowDto showDto);

	/**
	 * @param channelGroupId
	 * @param channelId
	 * @return message as assigned
	 * @throws ServiceException or else throws an exception with some message
	 */
	public String assignChannelToChannelGroup(int channelGroupId, int channelId) throws ServiceException;

	/**
	 * @param channelId
	 * @param showId
	 * @return message as assigned
	 * @throws ServiceException else throws an exception with some message
	 */
	public String assignShowToChanne(int channelId, int showId) throws ServiceException;

	/**
	 * @param channelGroupId
	 * @return data under particular channel group in sorted order by price
	 */
	public ChannelGroupDto getAllDataPresentInDataBaseOfParticularChannelGroupByGroupIdInSortedOrder(
			int channelGroupId);

}
