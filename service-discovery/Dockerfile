FROM openjdk:17-jdk-alpine
COPY target/*.jar service-discovery-1.0.0.jar
ENTRYPOINT ["java","-jar","/service-discovery-1.0.0.jar"]