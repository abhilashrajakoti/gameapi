package com.api.game.gameapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.core.game.CricketFieldPixel;
import com.core.game.GameEngine;

@Path("/pixels")
public class GameRestAPI {

	final static Logger logger = Logger.getLogger(GameRestAPI.class);

	@GET
	@Path("/{pixelId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CricketFieldPixel getPositionName(@PathParam("pixelId") int pixelId) {
		CricketFieldPixel pixel = null;
		try {
			GameEngine game = new GameEngine();
			pixel = game.getFieldPostionsInfo(pixelId);
			logger.info(pixel.getId() + "::" + pixel.getName());
		} catch (Exception e) {
			logger.error("GameAPIError", e);
		}
		return pixel;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CricketFieldPixel> getAllPositions() {
		List<CricketFieldPixel> list = null;
		try {
			GameEngine game = new GameEngine();
			list = game.getAllFieldPostions();
		} catch (Exception e) {
			logger.error("GameAPIError", e);
		}
		return list;

	}
}
