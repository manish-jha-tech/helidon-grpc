package com.example.grpc;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/grpc")

public class GrpcTriggerResource {
	@Inject
	GrpcServerStarter starter;

	@GET
	@Path("/start")
	@Produces(MediaType.TEXT_PLAIN)
	public String startGrpc() {
		System.out.println(starter);
		return "Trigger invoked. Check logs.";

	}

}
