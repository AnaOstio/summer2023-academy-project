package co.empathy.academy.summer2023academyproject.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ElasticController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/search")
    public JSONObject getElasticInfo(@RequestParam String query) {

        String url = "http://localhost:9200";
        ResponseEntity<Object> elasticsearchResponse = restTemplate.getForEntity(url, Object.class);
        String name = ((Map<String, Object>) elasticsearchResponse.getBody()).get("cluster_name").toString();
        System.out.println(name);
        JSONObject result = new JSONObject();
        if(query.isEmpty()){
            result.put("query", "");
        } else {
            result.put("query", query);
        }
        result.put("clusterName", name);
        return result;
    }
}
