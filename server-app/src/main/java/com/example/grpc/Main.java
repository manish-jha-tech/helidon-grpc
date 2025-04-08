package com.example.grpc;

import io.helidon.microprofile.server.Server;

public class Main {

	public static void main(String[] args) {
		Server server = Server.create().start();
		System.out.println("Helidon MP Server is up at: http://localhost:" + server.port());
	}

}
