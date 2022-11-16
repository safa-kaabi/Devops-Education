
FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achat-1.0.0-SNAPSHOT.jar achat-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","achat-1.0.0-SNAPSHOT.jar"]