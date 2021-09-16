package com.djcodes.openapi.samples.web.difference.api;

import com.djcodes.openapi.samples.web.difference.service.DifferenceService;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.io.IOException;
import java.nio.charset.Charset;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class DifferenceController implements OpenapiDiffApi{

    DifferenceService differenceService;



    public DifferenceController(DifferenceService differenceService){
        this.differenceService = differenceService;
    }

    @Override
    public ResponseEntity<String> check(MultipartFile spec1, MultipartFile spec2) {
        String oldSpec = parse(spec1);
        String newSpec = parse(spec2);
        ChangedOpenApi result = differenceService.compare(oldSpec,newSpec);
        return ResponseEntity.ok().body(new MarkdownRender().render(result));

    }

    @SneakyThrows
    private String parse(MultipartFile file){
        OpenAPIV3Parser openAPIParser = new OpenAPIV3Parser();
        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setFlatten(true);
        parseOptions.setResolve(true);
        parseOptions.setResolveFully(true);
        parseOptions.setFlattenComposedSchemas(true);
        parseOptions.setResolveCombinators(true);

        String contents = IOUtils.toString(file.getInputStream(), Charset.defaultCharset());

        OpenAPI openAPI  = openAPIParser.readContents(contents,null,parseOptions).getOpenAPI();
        log.info(openAPI.toString());

        return contents;

    }
}
