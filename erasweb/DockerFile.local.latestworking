# Use Maven for building
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . /app
COPY pom.xml /app/erasweb/pom.xml

#RUN mvn clean package -DskipTests
#RUN mvn -f /app/erasweb/pom.xml clean package -DskipTests
RUN mvn clean package  -DskipTests

# Use a JDK runtime for running the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/erasweb-0.0.1-SNAPSHOT.jar /app/erasweb.jar
#COPY --from=build /app/erasweb/target/erasweb-0.0.1-SNAPSHOT.jar /app/erasweb.jar
EXPOSE 8082
CMD ["java", "-jar", "erasweb.jar"]
