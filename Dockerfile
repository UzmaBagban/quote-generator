# ============================================
# Stage 1: Multi-stage build (Optional but good practice)
# ============================================

# Use OpenJDK 17 as base image
# This image comes with Java 17 pre-installed
# slim = minimal size (not bloated with unnecessary packages)
FROM eclipse-temurin:latest

# ============================================
# Set up the working directory inside container
# ============================================

# Create a folder called /app inside the container
# All commands after this will run from /app
# Think of it like: cd /app
WORKDIR /app

# ============================================
# Copy the JAR file from your computer into container
# ============================================

# COPY [source_on_your_computer] [destination_in_container]
# Copy the compiled JAR file from target folder
# Rename it to app.jar (easier to reference)
# Note: Build JAR using: mvn clean package
COPY target/quote-generator-0.0.1-SNAPSHOT.jar app.jar

# ============================================
# Expose the port your app uses
# ============================================

# Tell Docker this container listens on port 8080
# This is where Spring Boot runs
# Port inside container (not accessible from outside without mapping)
EXPOSE 8080

# ============================================
# Run the application when container starts
# ============================================

# ENTRYPOINT = the command to run when container starts
# This command: java -jar app.jar
# Starts your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

# ============================================
# How it works:
# 1. Gets Java 17
# 2. Creates /app folder
# 3. Copies your JAR file
# 4. Exposes port 8080
# 5. Runs: java -jar app.jar
# ============================================