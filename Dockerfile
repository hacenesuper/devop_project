FROM ubuntu:latest

RUN apt-get update

ADD . /devop_dataframe/
WORKDIR /devop_dataframe