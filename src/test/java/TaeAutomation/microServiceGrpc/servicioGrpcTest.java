package TaeAutomation.microServiceGrpc;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.example.grpc.client.MyGrpcClient;
import com.example.grpc.server.MyGrpcServer;
import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;

import junit.framework.Assert;

public class servicioGrpcTest extends GreetingServiceGrpc.GreetingServiceImplBase {

	MyGrpcServer server;
	
	@BeforeSuite
	public void startingSuite() {
		server = new MyGrpcServer();
		server.startServer();
	}

	@Test
	@Parameters({"nombre","deporte"})
	public void nombreValidationTest(String nombre, String deporte) {
		
		MyGrpcClient cliente = new MyGrpcClient();
		
		Assert.assertEquals(cliente.datosCliente(nombre, deporte), "Hola " + nombre + " Porfin ingresaste! y te gusta el " + deporte);
		
	}
	
	@AfterSuite
	public void closingSuite() {
		server.stopServer();
	}
	
}
