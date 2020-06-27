FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/Library-Automation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8001
