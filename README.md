# LoliEvent
GAY!
# How About!
```java
@LoliEvent
public Listener<String> stringListener = event -> {
  System.out.println(event);
};
```

# Gradle usage
```
Next, add the dependency for this library, and also add TypeTools because this depends on it.
dependencies {
  compile 'ni.ai.loli:Loli:1.0'
  compile 'net.jodah:typetools:0.4.4'
}
```
Lastly, run `gradlew --refresh-dependencies` in your project to download the libraries.
