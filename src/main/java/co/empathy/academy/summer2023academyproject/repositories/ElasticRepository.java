package co.empathy.academy.summer2023academyproject.repositories;

import co.elastic.clients.json.JsonData;
import co.empathy.academy.summer2023academyproject.configuration.ElasticConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ElasticRepository {

    private ElasticConfiguration elasticConfiguration;

    @Autowired
    public ElasticRepository(ElasticConfiguration elasticConfiguration){
        this.elasticConfiguration = elasticConfiguration;
    }

    public String getCluster() throws IOException {
        JsonData res = elasticConfiguration.getElasticClient().cluster().state().valueBody();
        return res.toJson().asJsonObject().getString("cluster_name");
    }
}
