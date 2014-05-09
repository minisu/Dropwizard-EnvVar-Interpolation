import io.dropwizard.Bundle;
import io.dropwizard.ga.EnvironmentVariableLookup;
import io.dropwizard.ga.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.commons.lang.text.StrSubstitutor;

public class EnvironmentVariableConfigSubstitution implements Bundle
{
	@Override
	public void initialize( Bootstrap<?> bootstrap )
	{
		bootstrap.setConfigurationSourceProvider(
				new SubstitutingSourceProvider(
						bootstrap.getConfigurationSourceProvider(),
						new StrSubstitutor( new EnvironmentVariableLookup() )
				)
		);
	}

	@Override
	public void run( Environment environment )
	{

	}
}
