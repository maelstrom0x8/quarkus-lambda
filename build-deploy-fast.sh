#!/bin/sh

set -e

export FUNCTION_ASSET=dorian/target/function.zip

./mvnw clean
./mvnw package -f dorian/pom.xml
./mvnw package -f cdk/pom.xml

cd cdk && cdk deploy --all --require-approval=never

