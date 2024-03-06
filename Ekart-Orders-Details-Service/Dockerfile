FROM openjdk:1.8
VOLUME /tmp
EXPOSE 9005
ARG JAR_FILE=target/Ekart-Orders-Details-Service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]