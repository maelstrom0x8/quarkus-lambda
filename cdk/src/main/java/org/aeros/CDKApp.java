package org.aeros;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.Tags;

public class CDKApp {

    static StackProps createStackProperties() {
        var account = System.getenv("CDK_DEPLOY_ACCOUNT");
        var region  = System.getenv("CDK_DEPLOY_REGION");

        if(account == null)
            return StackProps.builder().build();

        var environment =  Environment.builder()
                .account(account)
                .region(region)
                .build();
        return StackProps.builder().env(environment).build();
    }


    public static void main(final String[] args) {
        var app = new App();

        var appName = "aeros-cdk";
        Tags.of(app).add("project", "quarkus-aeros-lambda");
        Tags.of(app).add("environment","development");
        Tags.of(app).add("application", appName);

        var stackProps = createStackProperties();

        new CDKStack(app, appName, stackProps);
        app.synth();

    }
}
