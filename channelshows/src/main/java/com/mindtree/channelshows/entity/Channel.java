package com.mindtree.channelshows.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelId;
	private String channelName;
	private int channelPricre;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "channel")
	private List<Shows> shows;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ChannelGroup channelGroup;

	public Channel() {
		// TODO Auto-generated constructor stub
	}

	public Channel(int channelId, String channelName, List<Shows> shows, ChannelGroup channelGroup) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.shows = shows;
		this.channelGroup = channelGroup;
	}

	public Channel(int channelId, String channelName, int channelPricre, List<Shows> shows, ChannelGroup channelGroup) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPricre = channelPricre;
		this.shows = shows;
		this.channelGroup = channelGroup;
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

	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	public ChannelGroup getChannelGroup() {
		return channelGroup;
	}

	public void setChannelGroup(ChannelGroup channelGroup) {
		this.channelGroup = channelGroup;
	}

	public int getChannelPricre() {
		return channelPricre;
	}

	public void setChannelPricre(int channelPricre) {
		this.channelPricre = channelPricre;
	}

	

}
