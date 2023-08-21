FROM eclipse-temurin:17

LABEL maintainer="nkempegowda@gmail.com"

WORKDIR /app

COPY target/spring-boot-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]