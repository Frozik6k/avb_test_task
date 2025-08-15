# 1. Общий билд всех модулей
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# 2. Запуск конкретного сервиса
FROM eclipse-temurin:21
WORKDIR /app
ARG SERVICE_NAME
COPY --from=build /app/${SERVICE_NAME}/target/${SERVICE_NAME}-[0-9]*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]