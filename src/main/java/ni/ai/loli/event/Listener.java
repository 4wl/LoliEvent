package ni.ai.loli.event;

import java.lang.reflect.Method;

/**
 * @author M3dusa
 * @since 7/7/21
 */

public class Listener {
    public final Method method;
    public final Object object;
    public final Class<?> event;
    public final EventPriority priority;

    public Listener(Method method, Object object, Class<?> event, EventPriority priority){
        this.method = method;
        this.object = object;
        this.event = event;
        this.priority = priority;
    }
}
