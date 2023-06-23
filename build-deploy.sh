#!/bin/sh

set -e

./mvnw clean package && cdk deploy --all --require-approval=never
