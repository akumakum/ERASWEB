# Stage 1: Build stage

FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
COPY pom.xml /app/erasweb/pom.xml
RUN mvn -f /app/erasweb/pom.xml clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/erasweb/target/erasweb-0.0.1-SNAPSHOT.jar /app/erasweb.jar
EXPOSE 8082
CMD ["java", "-jar", "erasweb.jar"]
