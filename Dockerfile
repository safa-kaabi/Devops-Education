FROM openjdk:8-jre-alpine
COPY target/achat-3.0.jar achat-3.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-3.0.jar"]
