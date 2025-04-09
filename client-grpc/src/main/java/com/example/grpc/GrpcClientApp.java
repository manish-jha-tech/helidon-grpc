package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClientApp {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		GreetServiceGrpc.GreetServiceBlockingStub stub = GreetServiceGrpc.newBlockingStub(channel);

		GreetRequest request = GreetRequest.newBuilder().setName("message from client").build();

		GreetResponse response = stub.greet(request);

		System.out.println("Response from gRPC server: " + response.getMessage());

		channel.shutdown();
	}

}
