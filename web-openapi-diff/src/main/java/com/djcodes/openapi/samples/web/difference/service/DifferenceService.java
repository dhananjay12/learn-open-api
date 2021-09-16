package com.djcodes.openapi.samples.web.difference.service;

import io.swagger.v3.oas.models.OpenAPI;
import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.springframework.stereotype.Service;

@Service
public class DifferenceService {

    public ChangedOpenApi compare (String oldSpec, String newSpec){
        ChangedOpenApi diff = null;
        try {
            diff = OpenApiCompare.fromContents(oldSpec, newSpec);
        } catch (Exception e) {
        }
        return diff;
    }
}
