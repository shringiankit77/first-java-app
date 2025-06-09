# Use Amazon Corretto 17 as base image
FROM amazoncorretto:17-alpine AS base

# Create app directory
WORKDIR /app

# Copy built jar file into image
COPY build/libs/*.jar app.jar

# Expose port (adjust to match your app's port)
EXPOSE 8080

# Set the entry point
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
