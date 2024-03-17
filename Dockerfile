FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean install package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/erp-0.0.1-SNAPSHOT.jar erp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "erp.jar"]