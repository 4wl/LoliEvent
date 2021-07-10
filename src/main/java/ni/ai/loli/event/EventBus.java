package ni.ai.loli.event;

import net.jodah.typetools.TypeResolver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author M3dusa
 * @since 7/7/21
 */

public class EventBus {

    private final HashMap<Class<?>, List<LoliListener<?>>> listeners = new HashMap<>();

    public void loliEvent(Object o) {
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (isValid(f)) {
                try {
                    lolievent((LoliListener<?>) f.get(o));
                } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    public void lolievent(LoliListener<?> loliListener) {
        Class<?> type = getType(loliListener);
        if (listeners.get(type).contains(loliListener))
            return;

        if (!listeners.containsKey(type)) {
            listeners.put(type, new ArrayList<>());
        }
        listeners.get(type).add(loliListener);
    }

    public void unlolievent(Object o) {
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (isValid(f)) {
                try {
                    unlolievent((LoliListener<?>) f.get(o));
                } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    public void unlolievent(LoliListener<?> loliListener) {
        Class<?> type = getType(loliListener);
        if (listeners.containsKey(type)) {
            listeners.get(type).remove(loliListener);
        }
    }

    @SuppressWarnings("rawtypes")
    public void post(Object event) {
        if (listeners.containsKey(event.getClass())) {
            for (LoliListener loliListener : listeners.get(event.getClass())) {
                loliListener.invoke(event);
            }
        }
    }



    private Class<?> getType(LoliListener<?> loliListener) {
        return TypeResolver.resolveRawArgument(LoliListener.class, loliListener.getClass());
    }

    private boolean isValid(Field field) {
        return field.isAnnotationPresent(LoliEvent.class) && LoliListener.class.isAssignableFrom(field.getType());
    }
}