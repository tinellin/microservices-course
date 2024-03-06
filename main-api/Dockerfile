###
# Movendo o projeto completo para o container Docker
###

###
# Build Stage
###

FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app/main-api

COPY ./pom.xml .
COPY ./src ./src

RUN mvn -f ./pom.xml -DskipTests clean package

###
# Package stage
###

FROM eclipse-temurin:17-jdk
ENV JAR_FILE=/app/main-api
ENV NAME=main-api
COPY --from=build ${JAR_FILE}/target/*.jar ${JAR_FILE}/${NAME}.jar
EXPOSE 8085
ENTRYPOINT java -jar ${JAR_FILE}/${NAME}.jar