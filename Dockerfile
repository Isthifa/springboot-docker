FROM openjdk:17-jdk
COPY target/taskspring.jar taskspring.jar
ENTRYPOINT ["java", "-jar", "taskspring.jar"]