#!/bin/bash

mvn clean package -DskipTests
docker build -t libraryapp .
docker-compose up -d