package com.example.grpc.server;

import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{

@Override
public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
	String name = request.getNombre();
	HelloResponse response = HelloResponse.newBuilder().setGreeting("Hola porfin! " + name).build();
	
	responseObserver.onNext(response);
	responseObserver.onCompleted();
}
	
}
