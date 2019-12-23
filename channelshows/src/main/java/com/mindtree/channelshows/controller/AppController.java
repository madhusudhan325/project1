package com.mindtree.channelshows.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.channelshows.dto.ChannelDto;
import com.mindtree.channelshows.dto.ChannelGroupDto;
import com.mindtree.channelshows.dto.ShowDto;
import com.mindtree.channelshows.exception.AppException;
import com.mindtree.channelshows.service.ChannelGroupService;

@RestController
public class AppController {
	@Autowired
	private ChannelGroupService channelGroupService;

	@PostMapping("/channelGroup")
	public ResponseEntity<Map<String, Object>> insertChannelGroup(@RequestBody ChannelGroupDto channelGroupDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Channel Group ");
		response.put("Error", false);
		response.put("message", channelGroupService.addChannelGroupToDatabase(channelGroupDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/channel")
	public ResponseEntity<Map<String, Object>> insertChannels(@RequestBody ChannelDto channelDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Channel data ");
		response.put("Error", false);
		response.put("message", channelGroupService.addChannelToDatabase(channelDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/shows")
	public ResponseEntity<Map<String, Object>> insertShows(@RequestBody ShowDto showDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Show Data ");
		response.put("Error", false);
		response.put("message", channelGroupService.addShowToDatabase(showDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/channel-assign/{channelGroupId}/{channelId}")
	public ResponseEntity<Map<String, Object>> assignChannelGroupToChannel(@PathVariable int channelGroupId,
			@PathVariable int channelId) throws AppException {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Show Data ");
		response.put("Error", false);
		response.put("message", channelGroupService.assignChannelToChannelGroup(channelGroupId, channelId));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/show-assign/{channelId}/{showId}")
	public ResponseEntity<Map<String, Object>> assignChannelToShow(@PathVariable int channelId,
			@PathVariable int showId) throws AppException {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Show Data ");
		response.put("Error", false);
		response.put("message", channelGroupService.assignShowToChanne(channelId, showId));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/channelGroupDetails/{channelGroupId}")
	public ResponseEntity<Map<String, Object>> getDataOfParticularChannelGroup(@PathVariable int channelGroupId) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "Show Data ");
		response.put("Error", false);
		response.put("message", channelGroupService
				.getAllDataPresentInDataBaseOfParticularChannelGroupByGroupIdInSortedOrder(channelGroupId));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
