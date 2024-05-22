FROM openjdk:18
VOLUME /tmp
EXPOSE 8084
ARG JAR_FILE=target/*.jar
COPY ./target/SongService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]