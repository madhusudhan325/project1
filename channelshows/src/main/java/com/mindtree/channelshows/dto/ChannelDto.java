package com.mindtree.channelshows.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ChannelDto implements Comparable<ChannelDto> {
	private int channelId;
	private String channelName;
	private int channelPricre;
	private List<ShowDto> showDtos;
	private ChannelGroupDto channelGroupDto;

	public ChannelDto() {
		// TODO Auto-generated constructor stub
	}

	public ChannelDto(int channelId, String channelName, int channelPricre, List<ShowDto> showDtos,
			ChannelGroupDto channelGroupDto) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPricre = channelPricre;
		this.showDtos = showDtos;
		this.channelGroupDto = channelGroupDto;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getChannelPricre() {
		return channelPricre;
	}

	public void setChannelPricre(int channelPricre) {
		this.channelPricre = channelPricre;
	}

	public List<ShowDto> getShowDtos() {
		return showDtos;
	}

	public void setShowDtos(List<ShowDto> showDtos) {
		this.showDtos = showDtos;
	}

	public ChannelGroupDto getChannelGroupDto() {
		return channelGroupDto;
	}

	public void setChannelGroupDto(ChannelGroupDto channelGroupDto) {
		this.channelGroupDto = channelGroupDto;
	}

	@Override
	public int compareTo(ChannelDto channelDto) {
		if (this.channelPricre - channelDto.channelPricre == 0)
			return this.channelName.compareTo(channelDto.channelName);
		else
			return this.channelPricre - channelDto.channelPricre;
	}

}
