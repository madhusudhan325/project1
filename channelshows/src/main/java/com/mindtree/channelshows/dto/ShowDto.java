package com.mindtree.channelshows.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ShowDto {
	private int showId;
	private String showName;
	private ChannelDto channelDto;

	public ShowDto() {
		// TODO Auto-generated constructor stub
	}

	public ShowDto(int showId, String showName, ChannelDto channelDto) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channelDto = channelDto;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public ChannelDto getChannelDto() {
		return channelDto;
	}

	public void setChannelDto(ChannelDto channelDto) {
		this.channelDto = channelDto;
	}

}
