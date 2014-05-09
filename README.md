Dropwizard Environment Variable Interpolation
======

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
