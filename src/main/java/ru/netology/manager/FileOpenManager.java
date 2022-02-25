package ru.netology.manager;

import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class FileOpenManager {
    private final Map<String, Object> map = new HashMap<>();

    public void add(String key, Object value) {
        map.put(key, value);
        map.put(key.toUpperCase(Locale.ROOT), value);
    }

    public Object getApplication(String key) {
        return map.get(key);
    }

    public void removeApplication(String key) {
        map.remove(key);
        map.remove(key.toUpperCase(Locale.ROOT));
    }

    public Set<String> getAllExtensions() {
        return map.keySet();
    }

    public Set<Object> getAllApplications() {
        Set<Object> result = new HashSet<>(map.values());
        return Collections.unmodifiableSet(result);
    }
}
