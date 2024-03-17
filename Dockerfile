FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/erp-0.0.1-SNAPSHOT.jar erp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "erp.jar"]