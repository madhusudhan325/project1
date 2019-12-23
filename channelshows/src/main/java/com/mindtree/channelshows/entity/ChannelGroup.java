package com.mindtree.channelshows.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChannelGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelGroupId;
	private String channelGroupName;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "channelGroup")
	private List<Channel> channels;

	public ChannelGroup() {
		// TODO Auto-generated constructor stub
	}

	public ChannelGroup(int channelGroupId, String channelGroupName, List<Channel> channels) {
		super();
		this.channelGroupId = channelGroupId;
		this.channelGroupName = channelGroupName;
		this.channels = channels;
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

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

}
