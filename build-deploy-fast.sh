#!/bin/sh

set -e

export FUNCTION_ASSET=dorian/target/function.zip
export CDK_DEPLOY_ACCOUNT=224743825541
export CDK_DEPLOY_REGION=us-east-1

./mvnw clean
./mvnw package -f dorian/pom.xml
./mvnw package -f cdk/pom.xml

cd cdk && cdk deploy --all --require-approval=never

