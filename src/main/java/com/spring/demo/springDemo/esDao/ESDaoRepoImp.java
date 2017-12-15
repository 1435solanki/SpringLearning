package com.spring.demo.springDemo.esDao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.base.Supplier;

import io.searchbox.action.Action;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.cluster.Health;

@Scope(value = "singleton")
@Component
public class ESDaoRepoImp {

	private static final Logger LOG = LoggerFactory.getLogger(ESDaoRepoImp.class);
	
	private JestClientFactory factory;
	private JestClient client;

	public ESDaoRepoImp() throws Exception {
		LOG.info("init esDaoImp started");
		init();
		LOG.info("init esDaoImp finish");
	}

	public void init() throws Exception {
		makeRemoteConnection();
		LOG.info("makeRemoteConnection esDaoImp started");
	}

	private void makeRemoteConnection() {
		
		 factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        
         client = factory.getObject();
        
	}

	public <T extends JestResult> T execute(Action<T> clientRequest) throws IOException {
		return client.execute(clientRequest);
	}

	private void testConnection() throws Exception {
		client.execute(new Health.Builder().build());
	}
}
