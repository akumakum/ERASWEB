# Use a base image with Maven and JDK
FROM maven:3.8.5-openjdk-17 AS build

# Create directory and set as working directory
WORKDIR /app

# Copy the project files
COPY . /app

# Build the JAR file
RUN mvn clean package -DskipTests

# Use a smaller JDK image for runtime
FROM eclipse-temurin:17-jdk-alpine

# Create directory and set as working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/erasweb-0.0.1-SNAPSHOT.jar /app/erasweb.jar

# Expose the port
EXPOSE 8082

# Run the JAR file
CMD ["java", "-jar", "erasweb.jar"]