FROM openjdk:18
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=target/*.jar
COPY ./target/AlbumService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]