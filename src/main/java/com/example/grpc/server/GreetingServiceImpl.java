package com.example.grpc.server;

import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;
import com.google.protobuf.ProtocolStringList;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{

@Override
public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
	String nombre = request.getNombre();
	String deporte = request.getDeportes(0);
	ProtocolStringList  listaDeportes = request.getDeportesList();
	
	for(String string : listaDeportes) {
		deporte = string;
	}
	
	HelloResponse response = HelloResponse.newBuilder().setGreeting("Hola " + nombre + " Porfin ingresaste! y te gusta el " + deporte).build();	

	responseObserver.onNext(response);
	responseObserver.onCompleted();
}
	
}
