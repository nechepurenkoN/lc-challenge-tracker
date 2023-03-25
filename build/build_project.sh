#!/bin/bash

cd ../frontend || exit
cd ../build || exit
cp -r ../backend t_backend
cp -r ../frontend/build/* t_backend/src/main/resources/static
cd t_backend || exit
mvn clean package
cd ..
cp -r t_backend/target/*.jar .

aws s3 cp lc-challenge-tracker-backend-0.0.1-SNAPSHOT.jar s3://nechn-leetcode-challenge-deploy/lc-challenge-tracker-backend-0.0.1-SNAPSHOT.jar
aws s3 cp ../py-graphql-proxy/main.py s3://nechn-leetcode-challenge-deploy/py-graphql-proxy/main.py

rm -r ../frontend/build
rm -r t_backend