# LoliEvent
Very similar to alpine, but like 20x more lightweight

# How About!
```java
@LoliEvent
public Listener<String> stringListener = event -> {
  System.out.println(event);
};
```

# Gradle usage
If you haven't already, add the `jitpack.io` maven repository to your build.gradle
```groovy
repositories {
  maven { url = 'https://jitpack.io/' }
}
```
Next, add the dependency for this library, and also add TypeTools because this depends on it.
```groovy
dependencies {
  compile 'ni.ai.loli:Loli:1.0'
  compile 'net.jodah:typetools:0.4.4'
}
```
Lastly, run `gradlew --refresh-dependencies` in your project to download the libraries.
