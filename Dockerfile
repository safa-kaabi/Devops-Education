FROM openjdk:8-jre-alpine
COPY target/achat-2.0.jar achat-2.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-2.0.jar"]
