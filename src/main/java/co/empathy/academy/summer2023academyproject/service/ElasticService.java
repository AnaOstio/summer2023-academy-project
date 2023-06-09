package co.empathy.academy.summer2023academyproject.service;

import co.empathy.academy.summer2023academyproject.repositories.ElasticRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ElasticService {

    private ElasticRepository eRepo;

    @Autowired
    public ElasticService(ElasticRepository eRepo){
        this.eRepo = eRepo;
    }

    /**
     *
     */
    public JSONObject getClusterNameWithQuery(String query) {
        JSONObject res = new JSONObject();
        res.put("query", query);
        try {
            res.put("clusterName", eRepo.getCluster());
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return res;
    }
}
