Interpolates environment variables in Dropwizard YAML configurations.

## Usage ##
### In your Application class ###
```java
public void initialize( Bootstrap bootstrap ) {
	bootstrap.addBundle( new EnvironmentVariableInterpolationBundle() );
```

### In your YAML configuration ###
```java
# This is just an example
mongo:
  host: ${MONGO_HOST}
  port: ${MONGO_PORT}
```

## Notes ##
This bundle will fail fast, i.e. if an environment variable is not found, it will throw an `EnvironmentException`:
`EnvironmentException: The environment variable 'MONGO_HOST' is not defined; could not substitute the expression '${MONGO_HOST}'.`
