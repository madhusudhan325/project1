package com.mindtree.channelshows.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ChannelGroupDto {
	private int channelGroupId;
	private String channelGroupName;
	private List<ChannelDto> channelDtos;

	public ChannelGroupDto() {
		// TODO Auto-generated constructor stub
	}

	public ChannelGroupDto(int channelGroupId, String channelGroupName, List<ChannelDto> channelDtos) {
		super();
		this.channelGroupId = channelGroupId;
		this.channelGroupName = channelGroupName;
		this.channelDtos = channelDtos;
	}

	public int getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(int channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	public String getChannelGroupName() {
		return channelGroupName;
	}

	public void setChannelGroupName(String channelGroupName) {
		this.channelGroupName = channelGroupName;
	}

	public List<ChannelDto> getChannelDtos() {
		return channelDtos;
	}

	public void setChannelDtos(List<ChannelDto> channelDtos) {
		this.channelDtos = channelDtos;
	}

}
