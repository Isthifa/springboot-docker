FROM openjdk:17-jdk
COPY target/taskspring.jar taskspring.jar
ENTRYPOINT ["java", "-jar", "taskspring.jar"]
#
#FROM openjdk:17-jdk
#EXPOSE 8080 8000
#ADD target/taskspring.jar taskspring.jar
#ADD entrypoint.sh entrypoint.sh
#ENTRYPOINT ["sh","/entrypoint.sh"]