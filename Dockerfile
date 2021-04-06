FROM arm64v8/openjdk:11-slim 
WORKDIR /home/run
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]