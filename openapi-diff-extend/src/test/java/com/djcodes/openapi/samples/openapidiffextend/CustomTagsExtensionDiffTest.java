package com.djcodes.openapi.samples.openapidiffextend;


import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import org.junit.jupiter.api.Test;
import org.openapitools.openapidiff.core.compare.ExtensionDiff;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CustomTagsExtensionDiffTest {


    @Test
    void loadTest(){
        List<ExtensionDiff> extensionDiffs = new ArrayList<>();
        ServiceLoader<ExtensionDiff> extensionsLoader = ServiceLoader.load(ExtensionDiff.class);
        for (ExtensionDiff anExtensionsLoader : extensionsLoader) {
            extensionDiffs.add(anExtensionsLoader);
        }
        assertTrue(extensionDiffs.size()==1);
        extensionDiffs.get(0).getName();
    }


}
