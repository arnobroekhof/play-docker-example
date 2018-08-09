# Play Framework Docker example

this is a very simple and default example setup for building an docker container containing the 
play framework using Gradle that downloads SBT and Play including all it's dependencies.


## Build the play framework and the docker container

```bash
docker build -t play-docker-example .
```

## Running the container


### default run with the port mapped on 9000
```bash
docker run -p9000:9000 play-docker-example:latest
```

### Running with a custom secret
```bash
docker run -p 9000:9000 -e APPLICATION_SECRET=MySuperSecret play-docker-example:latest
```

### Running with custom jvm settings
docker run -p 9000:9000 -e APPLICATION_SECRET=MySuperSecret -e JAVA_OPTS="-Xms512m" play-docker-example:latest