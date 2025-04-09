package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

	@Override
	public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
		String name = request.getName();
		String message = "Hello , Response from server " + name;
		GreetResponse response = GreetResponse.newBuilder().setMessage(message).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
