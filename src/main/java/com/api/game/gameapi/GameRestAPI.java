package com.api.game.gameapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.core.game.CricketFieldPixel;
import com.core.game.GameEngine;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/pixels")
public class GameRestAPI {

	final static Logger logger = Logger.getLogger(GameRestAPI.class);

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{pixelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CricketFieldPixel getIt(@PathParam("pixelId") int pixelId) {
    	CricketFieldPixel pixel=null;
    	try {
        GameEngine game=new GameEngine();
        pixel=game.getFieldInfo(pixelId);
        logger.info(pixel.getId()+"::"+pixel.getName());;
    	} 
    	catch(Exception e) {
    		logger.error("GameAPIError", e);
    	}
    	return pixel;
    }
}
