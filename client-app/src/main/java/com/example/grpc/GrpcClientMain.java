package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.stub.ClientCalls;
public class GrpcClientMain {
	public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Create MethodDescriptor manually
        MethodDescriptor<HelloRequest, HelloResponse> methodDescriptor = MethodDescriptor
                .<HelloRequest, HelloResponse>newBuilder()
                .setType(MethodDescriptor.MethodType.UNARY)
                .setFullMethodName(MethodDescriptor.generateFullMethodName("HelloServiceGrpc", "SayHello"))
                .setRequestMarshaller(new ManualMarshaller<>(HelloRequest.class))
                .setResponseMarshaller(new ManualMarshaller<>(HelloResponse.class))
                .build();

        // Create request
        HelloRequest request = new HelloRequest();
        request.setName("Bhai");

        // Call the server manually
        HelloResponse response = ClientCalls.blockingUnaryCall(channel, methodDescriptor, io.grpc.CallOptions.DEFAULT, request);

        System.out.println("Server responded: " + response.getMessage());

        channel.shutdown();
    }

}
