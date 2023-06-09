# Utilisez l'image de base Java 8
FROM openjdk:8-jdk
  
WORKDIR /app
  
COPY target/TestTechnique-0.0.1-SNAPSHOT.jar app.jar
  
CMD ["java", "-jar", "app.jar"]
