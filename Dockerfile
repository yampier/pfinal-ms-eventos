FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-eventos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9084
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java", "-jar", "app.jar"]