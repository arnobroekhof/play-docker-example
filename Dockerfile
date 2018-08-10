
# Use the gradle container as builder container
FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build dist

FROM openjdk:8-jre-slim
EXPOSE 9000
COPY --from=builder /home/gradle/src/build/distributions/playBinary.tar /app/
WORKDIR /app
RUN tar -xvf playBinary.tar
WORKDIR /app/playBinary


# set default java opts for running in the container
ENV DEFAULT_JVM_OPTS "-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ENTRYPOINT ["bin/playBinary"]



