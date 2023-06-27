FROM openjdk:17
WORKDIR /app
COPY target/Retail-en-Java-Lab-III-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "Retail-en-Java-Lab-III-0.0.1-SNAPSHOT.jar"]