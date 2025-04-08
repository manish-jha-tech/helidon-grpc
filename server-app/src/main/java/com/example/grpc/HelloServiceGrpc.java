package com.example.grpc;

import io.grpc.stub.ServerCalls;
import io.grpc.*;

public class HelloServiceGrpc {
	public static final String SERVICE_NAME = "HelloServiceGrpc";

	public static ServerServiceDefinition bindService() {
		MethodDescriptor<HelloRequest, HelloResponse> method = MethodDescriptor
				.<HelloRequest, HelloResponse>newBuilder().setType(MethodDescriptor.MethodType.UNARY)
				.setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "SayHello"))
				.setRequestMarshaller(new ManualMarshaller<>(HelloRequest.class))
				.setResponseMarshaller(new ManualMarshaller<>(HelloResponse.class)).build();

		return ServerServiceDefinition.builder(SERVICE_NAME)
				.addMethod(method, ServerCalls.asyncUnaryCall((request, responseObserver) -> {
					String msg = "Hello, " + request.getName();
					HelloResponse response = new HelloResponse(msg);
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				})).build();
	}
}
