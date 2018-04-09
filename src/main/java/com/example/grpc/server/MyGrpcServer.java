package com.example.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MyGrpcServer {

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = ServerBuilder.forPort(9080)
				.addService(new GreetingServiceImpl())
				.build();
		server.start();
		server.awaitTermination();
		System.out.println("Servidor iniciado en puerto 9080");
	}
	
}
