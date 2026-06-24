---- Build Stage ----
FROM eclipse-temurin:21-jdk AS build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
Copy everything needed for the build
COPY . .
RUN chmod +x mvnw
COPY pom.xml .
COPY src/ src/
Build the application
RUN ./mvnw clean package -DskipTests -q
RUN mvn clean package -DskipTests -q
---- Runtime Stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
