# Use Java 17 JRE base image
FROM eclipse-temurin:17-jre

# Create group & user
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Set working directory
WORKDIR /app

# Copy your jar file
COPY target/*.jar /app/app.jar

# Change ownership & permissions
RUN chown -R appuser:appgroup /app
RUN chmod -R 750 /app

# Switch to non-root user
USER appuser

# Start application
CMD ["java", "-jar", "app.jar"]