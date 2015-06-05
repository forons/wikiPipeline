package it.unitn.disi.wikipedia.restexecutor;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Services [/]<br>
 * USAGE:
 * 
 * <pre>
 *        TestClient client = new TestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class AidaClient {
	private WebTarget webTarget;
	private Client client;

	// private static final String BASE_URI =
	// "http://sneezy.disi.unitn.eu:8080/ExAidaLighy-1.0-SNAPSHOT/aida/";

	public AidaClient(String BASE_URI) {

		client = ClientBuilder.newClient();
		webTarget = client.target(BASE_URI);
	}

	public String init() throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path("init");
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(String.class);
	}

	public <T> T findExemplar(Object requestEntity, Class<T> responseType)
			throws ClientErrorException {
		return webTarget
				.path("findExemplar")
				.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.post(javax.ws.rs.client.Entity.entity(requestEntity,
						javax.ws.rs.core.MediaType.APPLICATION_JSON),
						responseType);
	}

	public void close() {
		client.close();
	}

}
