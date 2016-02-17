package minisu.dropwizard.interpolation;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.commons.lang3.text.StrSubstitutor;

public class EnvironmentVariableInterpolationBundle implements Bundle {

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new StrSubstitutor(new EnvironmentVariableLookup())
                )
        );
    }

    @Override
    public void run(Environment environment) {
    }
}
