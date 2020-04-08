FROM openjdk:11

MAINTAINER dberber

EXPOSE 5007

# label for the image
LABEL Description="TSMD AUTH" Version="0.0.1"

ADD /build/libs/tsmd-auth*.jar /tsmd-auth.jar

ENTRYPOINT ["java","-jar","/tsmd-auth.jar"]
