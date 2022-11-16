FROM openjdk:8-jdk-alpine
ADD target/achat-1.0.jar achat-1.0.0-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","achat-1.0.0-SNAPSHOT.jar"]
