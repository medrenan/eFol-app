# bin/sh
echo 'Pulling latest Swagger-UI image from Docker'
docker pull swaggerapi/swagger-ui

echo 'Running swagger docker image using swagger-efol.yaml as the local enviroment'
docker run -p 80:8080 -e SWAGGER_JSON=/tmp/swagger-efol.yaml -v $PWD/bin/swagger:/tmp swaggerapi/swagger-ui