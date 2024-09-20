#!/bin/sh

# consumer
docker build -t xcbeyond/consumer:v1 --build-arg MODULE=consumer .
docker push xcbeyond/consumer:v1

# provider
#docker build -t xcbeyond/provider:0.0.1 --build-arg MODULE=consumer .
#docker build -t xcbeyond/provider:0.0.1 --build-arg MODULE=consumer --build-arg VERSION=v2 .