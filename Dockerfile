FROM openjdk:8-jdk-alpine
VOLUME /simcat
ARG JAR_FILE=*.jar
ADD target/${JAR_FILE} /simcat/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /simcat/app.jar
