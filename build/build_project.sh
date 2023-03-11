#!/bin/bash

cd ../frontend || exit
npm run build
cd ../build || exit
cp -r ../backend t_backend
cp -r ../frontend/build/* t_backend/src/main/resources/static
cd t_backend || exit
mvn clean package
cd ..
cp -r t_backend/target/*.jar .

rm -r ../frontend/build
rm -r t_backend