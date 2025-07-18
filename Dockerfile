FROM maven:3.9.6-eclipse-temurin-22 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:22

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]
