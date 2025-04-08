package com.example.grpc;

import java.io.IOException;

import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GrpcServerStarter {

	private io.grpc.Server grpcServer;

	public GrpcServerStarter() {
        System.out.println(">>> GrpcServerStarter constructor called");
    }

	@PostConstruct
	public void startGrpcServer() {
		try {
			grpcServer = ServerBuilder.forPort(50051).addService(HelloServiceGrpc.bindService()).build().start();

			System.out.println("gRPC Server started on port 50051");

			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				if (grpcServer != null) {
					grpcServer.shutdown();
				}
			}));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
