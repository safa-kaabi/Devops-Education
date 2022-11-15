FROM openjdk:8-jre-alpine
COPY target/achat-6.0.jar achat-6.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-6.0.jar"]
