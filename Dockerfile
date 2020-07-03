FROM maven:3.6.3 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY ./ /workspace
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","app.jar"]