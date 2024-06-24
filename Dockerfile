FROM eclipse-temurin:17-jdk-alpine
COPY target/movie-service-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]