# API service for Continuous Perf Test


## Prerequisite

1. Install [MongoDB](https://docs.mongodb.com/manual/installation/)


## Configuration

Set values of properties inside ```an application.properties``` file located in ```src/main/resources```

1. Set the values of MongoDB properties (host, port)
2. Set the value of the service port


## Build Setup

```bash 
# package the service
mvn package

# run the service as a packaged application
java -jar target/service-api-0.0.1-SNAPSHOT.jar
```


## License

This project is licensed under the GPL-3.0 License - see the [LICENSE.md](https://github.com/continuousperftest/agent-java/blob/master/LICENSE) file for details