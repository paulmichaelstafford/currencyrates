#!/bin/bash

VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout --batch-mode -U -e -Dsurefire.useFile=false)

mvn clean package -DskipTests=true
docker  build -t localhost:32000/com/oghamstone/cache:$VERSION .
docker push localhost:32000/com/oghamstone/cache:$VERSION


cd ./kubernetes/

./upgrade.sh cache $VERSION master oghamstone-master
