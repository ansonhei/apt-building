# OpenJDK 
FROM openjdk:17-jdk-slim

# working directory inside the container
WORKDIR /app

# JAR file from the host to the container
COPY target/apt-building-1.0.0.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
