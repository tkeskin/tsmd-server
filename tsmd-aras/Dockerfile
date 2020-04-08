FROM openjdk:11

MAINTAINER dberber

EXPOSE 5002

# label for the image
LABEL Description="TSMD ARAS" Version="0.0.1"

ADD /build/libs/tsmd-aras*.jar /tsmd-aras.jar

ENTRYPOINT ["java","-jar","/tsmd-aras.jar"]
