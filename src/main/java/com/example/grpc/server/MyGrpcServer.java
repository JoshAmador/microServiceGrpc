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
		System.out.println("Servidor iniciado en puerto 9080");
		server.awaitTermination();
	}
	
	public void startServer() {
		
		Server server = ServerBuilder.forPort(9080)
				.addService(new GreetingServiceImpl())
				.build();
		
		try {
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Servidor iniciado en puerto 9080");
		
	}
	
	public void stopServer() {
		Server server = ServerBuilder.forPort(9080)
				.addService(new GreetingServiceImpl())
				.build();
		server.shutdown();
		System.out.println("El servidor ha terminado su sesion");
	}
	
}
