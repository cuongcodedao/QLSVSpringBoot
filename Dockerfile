
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app


COPY . .


RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app


COPY --from=build /app/target/QLSV-0.0.1-SNAPSHOT.jar /app/QLSV-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "/app/QLSV-0.0.1-SNAPSHOT.jar"]