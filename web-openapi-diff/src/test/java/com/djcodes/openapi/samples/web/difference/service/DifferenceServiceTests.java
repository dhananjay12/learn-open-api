package com.djcodes.openapi.samples.web.difference.service;

import java.io.File;
import java.nio.charset.Charset;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class DifferenceServiceTests {

    private static String petStore_content_v1;

    private static String petStore_content_v1_1;

    private static String petStore_content_v2;

    @BeforeAll
    @SneakyThrows
    static void setUp() {
        petStore_content_v1 = IOUtils.toString(
                new File(getFilePath("/pet-store-client-api-v1.yaml")).toURI(), Charset.defaultCharset());
        petStore_content_v1_1 = IOUtils.toString(
                new File(getFilePath("/pet-store-client-api-v1_1.yaml")).toURI(), Charset.defaultCharset());
        petStore_content_v2 = IOUtils.toString(
                new File(getFilePath("/pet-store-client-api-v2.yaml")).toURI(), Charset.defaultCharset());
    }


    @Test
    void test_compare(){

        DifferenceService differenceService = new DifferenceService();

        ChangedOpenApi result = differenceService.compare(petStore_content_v1,petStore_content_v1_1);

        assertTrue(result.isCompatible());

    }


    private static String getFilePath(String glob) {
        return (new File("src/test/resources").getAbsolutePath() + glob);
    }
}
