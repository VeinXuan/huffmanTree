package com.wei.http.request;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class HttpRequest {
	private static CloseableHttpClient client;
	static {
		ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {

			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				// Honor 'keep-alive' header
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						try {
							return Long.parseLong(value) * 1000;
						} catch (NumberFormatException ignore) {
						}
					}
				}
				// otherwise keep alive for 30 seconds
				return 30 * 1000;
			}

		};
		client = HttpClients.custom().setKeepAliveStrategy(myStrategy).build();
	}

	public static String execute(HttpRequestBase post) throws ClientProtocolException, IOException {
		CloseableHttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		byte[] data;
		is.read(data = new byte[(int) entity.getContentLength()]);
		return new String(data, Charset.forName("utf-8"));
	}
}
