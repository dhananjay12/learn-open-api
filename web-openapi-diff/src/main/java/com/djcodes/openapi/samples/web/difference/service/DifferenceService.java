package com.djcodes.openapi.samples.web.difference.service;

import io.swagger.v3.oas.models.OpenAPI;
import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.springframework.stereotype.Service;

@Service
public class DifferenceService {

    public String compare (String oldSpec, String newSpec){
        ChangedOpenApi diff = null;
        String render =null;
        try {
            diff = OpenApiCompare.fromContents(oldSpec, newSpec);
            render = new MarkdownRender().render(diff);
        } catch (Exception e) {
        }
        return render;
    }
}
