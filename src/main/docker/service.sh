#!/bin/sh
touch /app.jar

java -Djava.security.egd=file:/dev/./urandom -Xms1024m -Xms1024m -jar /app.jar