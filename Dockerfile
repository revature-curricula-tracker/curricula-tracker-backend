# Declare the base image - here is a light weight JDK 8 environment
# In order to avoid pull rate limits from Docker, I have pushed the opnejdk:	8-jdk-alpine image into
# AWS ECR so we can routinely pull from ECR as the Base Image. Resource: https://computingforgeeks.com/resolve-docker-pull-rate-limit-aws-error/
FROM 855430746673.dkr.ecr.us-east-1.amazonaws.com/curricula-tracker-ecr:openjdk8

# Copy the jar produced from the mvn clean package phase from the target to the inside of the container
COPY /target/curricula-tracker-backend-0.0.1-SNAPSHOT.jar curricula-tracker-backend-0.0.1-SNAPSHOT.jar

# Expose port 8080
# EXPOSE 8080
EXPOSE 5000

# Run the JAR when you run the container, thus executing the app
ENTRYPOINT ["java", "-jar", "/curricula-tracker-backend-0.0.1-SNAPSHOT.jar"]
