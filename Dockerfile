
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app


COPY . .


RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app


COPY --from=build /app/target/qlsv.jar /app/qlsv.jar


ENTRYPOINT ["java", "-jar", "/app/qlsv.jar"]
