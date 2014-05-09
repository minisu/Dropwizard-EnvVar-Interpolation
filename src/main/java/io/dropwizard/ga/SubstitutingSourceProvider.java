package io.dropwizard.ga;

import io.dropwizard.configuration.ConfigurationSourceProvider;
import org.apache.commons.lang.text.StrSubstitutor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SubstitutingSourceProvider implements ConfigurationSourceProvider
{
	private final ConfigurationSourceProvider baseProvider;
	private final StrSubstitutor strSubstitutor;

	public SubstitutingSourceProvider( ConfigurationSourceProvider baseProvider, StrSubstitutor strSubstitutor )
	{
		this.baseProvider = baseProvider;
		this.strSubstitutor = strSubstitutor;
	}

	@Override
	public InputStream open( String path ) throws IOException
	{
		String config = convertStreamToString( baseProvider.open( path ) );
		StrSubstitutor environmentVariableSubstitutor = strSubstitutor;

		String substitutedConfig = environmentVariableSubstitutor.replace( config );
		return new ByteArrayInputStream( substitutedConfig.getBytes() );
	}

	static String convertStreamToString( InputStream is )
	{
		Scanner s = new Scanner( is ).useDelimiter( "\\A" );
		return s.hasNext() ? s.next() : "";
	}
}
