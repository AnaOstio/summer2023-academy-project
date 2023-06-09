package co.empathy.academy.summer2023academyproject.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfiguration {
    /**
     * Create a connection to elastic on port 9200
     */
    @Bean
    public ElasticsearchClient getElasticClient(){

        // Create the low-level client
        // To put it on the Docker I have to change the HtppPost
        // in this case to "elasticsearch"
        RestClient restClient = RestClient.builder(
                new HttpHost("elasticsearch", 9200)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);

        return client;
    }
}
