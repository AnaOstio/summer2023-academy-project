package co.empathy.academy.summer2023academyproject.controller;

import co.empathy.academy.summer2023academyproject.service.ElasticService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
public class ElasticController {

    @Autowired
    private ElasticService elasticService;

   /** @GetMapping("/search")
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
    }*/

    @GetMapping("")
    public JSONObject call(@RequestParam String query){
        return elasticService.getClusterNameWithQuery(query);
    }
}
