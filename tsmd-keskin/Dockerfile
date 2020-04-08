FROM openjdk:11

MAINTAINER dberber

EXPOSE 5003

# label for the image
LABEL Description="TSMD KESKIN" Version="0.0.1"

ADD /build/libs/tsmd-keskin*.jar /tsmd-keskin.jar

ENTRYPOINT ["java","-jar","/tsmd-keskin.jar"]
