import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
public class MMHCLI {
	
	public static void main(String[] args) throws IOException {
		Client client = ClientBuilder.newClient();

		WebTarget resource = client.target("http://localhost:8080/mmh?location1=mountain+view,+california&location2=san+diego,+california");

		Builder request = resource.request();
		request.accept(MediaType.APPLICATION_JSON);

		Response response = request.get();

		if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
		    System.out.println("Success! " + response.getStatus());
		    System.out.println(response.getEntity());
		    response.bufferEntity();
		    System.out.println(response.readEntity(String.class));
		} else {
		    System.out.println("ERROR! " + response.getStatus());    
		    System.out.println(response.getEntity());
		}
		
//		ClientConfig config = new ClientConfig();
//        Client client = ClientBuilder.newClient(config);
//        WebTarget service = client.target("http://localhost:8080/mmh?location1=mountain+view,+california&location2=san+diego,+california");
//        
//        service.path("rest").path("todos").path(todo.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(todo,MediaType.APPLICATION_XML),Response.class);
	}
}