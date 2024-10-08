# FROM maven:3.8.2-jdk-8 # for Java 8
FROM adoptopenjdk/openjdk11:latest

WORKDIR /app

VOLUME /tmp

ADD icare-backend-0.0.1-SNAPSHOT.jar icare-backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "icare-backend-0.0.1-SNAPSHOT.jar"]