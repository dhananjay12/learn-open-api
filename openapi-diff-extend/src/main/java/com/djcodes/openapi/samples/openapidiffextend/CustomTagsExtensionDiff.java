package com.djcodes.openapi.samples.openapidiffextend;


import io.swagger.v3.oas.models.Components;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.openapidiff.core.compare.ExtensionDiff;
import org.openapitools.openapidiff.core.compare.OpenApiDiff;
import org.openapitools.openapidiff.core.model.Change;
import org.openapitools.openapidiff.core.model.Changed;
import org.openapitools.openapidiff.core.model.DiffContext;
import org.openapitools.openapidiff.core.model.schema.ChangedReadOnly;

public class CustomTagsExtensionDiff implements ExtensionDiff {

    private final static String name = "CustomTagsExtensionDiff";

    private Components leftComponents;
    private Components rightComponents;
    private OpenApiDiff openApiDiff;

    public ExtensionDiff setOpenApiDiff(OpenApiDiff openApiDiff) {
        this.openApiDiff = openApiDiff;
        this.leftComponents =
                openApiDiff.getOldSpecOpenApi() != null
                        ? openApiDiff.getOldSpecOpenApi().getComponents()
                        : null;
        this.rightComponents =
                openApiDiff.getNewSpecOpenApi() != null
                        ? openApiDiff.getNewSpecOpenApi().getComponents()
                        : null;

        return new CustomTagsExtensionDiff();
    }

    public String getName() {
        return name;
    }

    public Changed diff(Change change, DiffContext diffContext) {
        System.out.println(openApiDiff.toString());
        System.out.println(change.toString());
        System.out.println(diffContext.toString());
        return new ChangedReadOnly(false,false,diffContext);
    }
}
