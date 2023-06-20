# Use a base image with Java and necessary dependencies
FROM adoptopenjdk:8-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/Application-0.0.1-SNAPSHOT.jar Application-0.0.1-SNAPSHOT.jar

# Expose the port your application will listen on
EXPOSE 8090

# Set environment variables for database configuration
ENV DB_HOST=localhost
ENV DB_PORT=5432
ENV DB_NAME=postgres
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=root

# Wait for the database to be ready before starting the application
CMD ["sh", "-c", "while ! nc -z localhost 5432; do sleep 1; done; java -jar Application-0.0.1-SNAPSHOT.jar"]