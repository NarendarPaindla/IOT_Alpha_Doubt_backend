# Stage 1: Build the application using Java 21 and Maven
FROM eclipse-temurin:21-jdk AS build

# Install required tools: wget and tar
RUN apt-get update && apt-get install -y wget tar && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Download and install Maven 3.9.0
RUN wget https://archive.apache.org/dist/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.tar.gz && \
    tar -xzvf apache-maven-3.9.0-bin.tar.gz && \
    mv apache-maven-3.9.0 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn && \
    rm apache-maven-3.9.0-bin.tar.gz

# Copy pom.xml and download dependencies (offline mode)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the jar file (skip tests for speed)
COPY src ./src
RUN mvn clean package -DskipTests -B

# Stage 2: Run the application using Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the jar file from the build stage. Adjust the jar name if necessary.
COPY --from=build /app/target/app-1.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
