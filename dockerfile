# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom first to leverage Docker cache
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -B clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy only the jar from build stage
COPY --from=builder /app/target/*.jar app.jar

# Render injects PORT automatically
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
