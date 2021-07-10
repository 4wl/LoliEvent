package ni.ai.loli.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author M3dusa
 * @since 7/7/21
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoliEvent {
    int priority() default EventPriority.DEFAULT;
}