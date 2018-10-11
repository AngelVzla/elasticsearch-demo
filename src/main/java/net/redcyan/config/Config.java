package net.redcyan.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "net.redcyan.repos")
@ComponentScan(basePackages = { "net.redcyan" })
public class Config {
 
    @Bean
    public Client client() throws UnknownHostException {
        Settings elasticsearchSettings = Settings.builder()
         // .put("path.home", elasticsearchHome) //In case we need to specify an installation path
         // .put("cluster.name", clusterName) //In case the cluster name is different than "elasticsearch"
         //.put("client.transport.sniff", true)
        		.build();
        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
        client
//        	  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200))
              .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));//9300 to send data
        
        return client;
    }
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}