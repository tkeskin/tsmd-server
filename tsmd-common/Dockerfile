FROM openjdk:11

MAINTAINER dberber

EXPOSE 5009

# label for the image
LABEL Description="TSMD COMMON" Version="0.0.1"

ADD /build/libs/tsmd-common*.jar /tsmd-common.jar

ENTRYPOINT ["java","-jar","/tsmd-common.jar"]
