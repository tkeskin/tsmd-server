FROM openjdk:11

MAINTAINER dberber

EXPOSE 8763

# label for the image
LABEL Description="ZUUL SERVER" Version="0.0.1"

ADD /build/libs/zuul-server*.jar /zuul-server.jar

ENTRYPOINT ["java","-jar","/zuul-server.jar"]
