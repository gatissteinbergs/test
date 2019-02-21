package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommitInfoController {

    @Value("${git.build.time:}")
    private String buildTime;

    @Value("${git.branch:}")
    private String branch;

    @Value("${git.commit.id:}")
    private String commitId;

    @Value("${git.commit.id.abbrev:}")
    private String abbrev;

    @Value("${git.tags:}")
    private String tags;

    @RequestMapping("/commitId")
    public Map<String, String> getCommitId() {
        Map<String, String> result = new HashMap<>();
        if(!"".equals(buildTime)) result.put("Build  time", buildTime);
        if(!"".equals(branch)) result.put("Commit branch", branch);
        if(!"".equals(commitId)) result.put("Commit id", commitId);
        if(!"".equals(abbrev)) result.put("Commit id short", abbrev);
        if(!"".equals(tags)) result.put("Tag ", tags);
        return result;
    }
}