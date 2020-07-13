FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/Udemy_Test

ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs
ADD FlightBooking.xml					FlightBooking.xml
ADD getVideoLinkCount.xml				getVideoLinkCount.xml

ADD test.sh 							test.sh

ENTRYPOINT sh test.sh