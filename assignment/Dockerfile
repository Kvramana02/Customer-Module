# define docker image

FROM openjdk:11
#LABEL maintainer="RAMANA"
ADD target/assignment-0.0.1-SNAPSHOT.jar springboot-assignment-docker.jar
ENTRYPOINT ["java", "-jar", "springboot-assignment-docker.jar"]