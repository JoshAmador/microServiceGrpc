package com.example.grpc.client;

import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {

	HelloResponse response;
	
	  public static void main(String[] args) throws InterruptedException {
		    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9080)
		        .usePlaintext(true)
		        .build();

		    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
		    HelloResponse response = stub.greeting(HelloRequest.newBuilder()
		        .setNombre("Joshua")
		        .addDeportes("Ciclismo")
		        .addDeportes("Gimnasia")
		        .build());
		    System.out.print(response.toString());
		    response.wait(10);
		  }
	  
	  public String datosCliente(String nombre, String deporte) {
		  
		  ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9080)
			        .usePlaintext(true)
			        .build();

			    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
			    HelloResponse response = stub.greeting(HelloRequest.newBuilder()
			        .setNombre(nombre)
			        .addDeportes(deporte)
			        .build());
			    
			    return response.getGreeting();
		  
		  
	  }
	
}
