package org.aeros;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;

public class CDKStack extends Stack {

	public CDKStack(final Construct scope, final String id, final StackProps props) {

		super(scope, id, props);
		String asset = System.getenv("FUNCTION_ASSET");
		// Stack definition

		Function function = Function.Builder.create(this, "quarkus-dorian-service")
				.code(Code.fromAsset(asset))
				.functionName("quarkus-lambda-dorian-inventory")
				.memorySize(512)
				.handler("io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest")
				.runtime(Runtime.JAVA_17)
				.build();

		LambdaRestApi.Builder.create(this, "gateway")
				.handler(function).build();


	}

}
