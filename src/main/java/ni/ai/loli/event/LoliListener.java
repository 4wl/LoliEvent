package ni.ai.loli.event;

/**
 * @author M3dusa
 * @since 7/7/21
 */

@FunctionalInterface
public interface LoliListener<T> {

    void invoke(T event);
}