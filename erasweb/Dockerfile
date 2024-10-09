# Stage 1: Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy only the pom.xml first and download dependencies
#COPY pom.xml .
COPY /erasweb/pom.xml /app/pom.xml
RUN mvn dependency:go-offline

# Now copy the rest of the project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/erasweb-0.0.1-SNAPSHOT.jar /app/erasweb.jar

# Expose port 8082
EXPOSE 8082

# modify jar so it would execute
#RUN chmod +x /app/erasweb.jar

# Verify if Java is installed
#RUN java -version

# Check if the JAR file exists
#RUN ls -la /app/erasweb.jar

# Start the application
CMD ["java", "-jar", "/app/erasweb.jar"]
