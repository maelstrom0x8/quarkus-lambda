#!/bin/sh

set -e

export FUNCTION_ASSET=../lambda/target/function.zip
export CDK_DEPLOY_ACCOUNT= #account_id
export CDK_DEPLOY_REGION= #region

cd lambda && ./mvnw clean package
echo "Building CDK.."
cd ../cdk && ./mvnw clean package && cdk deploy --all --require-approval=never
