## openapi-diff

Compare two OpenAPI specifications (3.x) and render the difference to HTML plaintext, or Markdown files.

https://github.com/OpenAPITools/openapi-diff

Diff in v1 and v1_1 - New /pets api added , along with new enum added- Backward compatible:
```
docker run --rm -t \
  -v $(pwd)/petstore-sample-spec:/specs:ro \
  openapitools/openapi-diff:latest /specs/v1/pet-store-client-api-v1.yaml /specs/v1_1/pet-store-client-api-v1_1.yaml
```
Diff in v1_1 and v2 - Enum changed - breaking change:
```
docker run --rm -t \
  -v $(pwd)/petstore-sample-spec:/specs:ro \
  openapitools/openapi-diff:latest /specs/v1_1/pet-store-client-api-v1_1.yaml /specs/v2/pet-store-client-api-v2.yaml
```

Diff in v1 and v2 - New api  - new api and enum but not a breaking change, because enum changed from 1.1 to 2:

```
docker run --rm -t \
  -v $(pwd)/petstore-sample-spec:/specs:ro \
  openapitools/openapi-diff:latest /specs/v1/pet-store-client-api-v1.yaml /specs/v2/pet-store-client-api-v2.yaml
```