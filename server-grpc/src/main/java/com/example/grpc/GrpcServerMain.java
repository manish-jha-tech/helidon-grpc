package com.example.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServerMain {
	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(50051).addService(new GreetServiceImpl()).build().start();
		System.out.println("✅ gRPC server started on port 50051");
		server.awaitTermination();
	}

}
