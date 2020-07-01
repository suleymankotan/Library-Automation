FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/Library-Automation-*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8001
