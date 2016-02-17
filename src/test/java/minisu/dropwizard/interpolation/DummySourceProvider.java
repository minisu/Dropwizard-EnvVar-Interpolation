package minisu.dropwizard.interpolation;

import io.dropwizard.configuration.ConfigurationSourceProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class DummySourceProvider implements ConfigurationSourceProvider {
    @Override
    public InputStream open(String textToReturn) throws IOException {
        return new ByteArrayInputStream(textToReturn.getBytes());
    }
}