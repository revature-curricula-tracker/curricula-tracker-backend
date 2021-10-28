# Declare the base image - here is a light weight JDK 8 environment setup
FROM 855430746673.dkr.ecr.us-east-1.amazonaws.com/curricula-tracker-ecr:latest

# Copy the jar produced from the mvn clean package phase from the target to the inside of the container
COPY /target/curricula-tracker-backend-0.0.1-SNAPSHOT.jar curricula-tracker-backend-0.0.1-SNAPSHOT.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR when you run the container, thus executing the app
ENTRYPOINT ["java", "-jar", "/curricula-tracker-backend-0.0.1-SNAPSHOT.jar"]
