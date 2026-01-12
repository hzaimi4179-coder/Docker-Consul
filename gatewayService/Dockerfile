FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

VOLUME /tmp

COPY target/*.jar gateway-service.jar

ENTRYPOINT ["java","-jar","gateway-service.jar"]
