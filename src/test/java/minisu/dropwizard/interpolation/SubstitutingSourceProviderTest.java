package minisu.dropwizard.interpolation;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;

import java.io.IOException;

import static minisu.dropwizard.interpolation.SubstitutingSourceProvider.convertStreamToString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubstitutingSourceProviderTest {

    private StrLookup dummyLookup = new StrLookup() {
        @Override
        public String lookup(String s) {
            return "baz";
        }
    };

    @Test
    public void shouldSubstituteCorrectly() throws IOException {
        SubstitutingSourceProvider preprocessor = new SubstitutingSourceProvider(new DummySourceProvider(), new StrSubstitutor(dummyLookup));
        String results = convertStreamToString(preprocessor.open("foo: ${bar}"));

        assertThat(results, is("foo: baz"));
    }
}
