package com.shatteredpixel.shatteredpixeldungeon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class Events {    
    @FunctionalInterface
    public interface TriConsumer<A, B, C> {
        void accept(A a, B b, C c);
    }

    // 0 Parameter
    public static class Event0 {
        private final Map<String, Runnable> listeners = new LinkedHashMap<>();

        public void add(String key, Runnable listener) { listeners.put(key, listener); }
        public void remove(String key)                 { listeners.remove(key); }

        public void trigger() {
            for (Map.Entry<String, Runnable> e : new ArrayList<>(listeners.entrySet())) {
                if (e.getValue() == null) continue;
                try {
                    e.getValue().run();
                } catch (Exception ex) {
                    System.err.println("리스너 오류 [" + e.getKey() + "]");
                    ex.printStackTrace();
                }
            }
        }
    }

    // 1 Parameter
    public static class Event1<A> {
        private final Map<String, Consumer<A>> listeners = new LinkedHashMap<>();

        public void add(String key, Consumer<A> listener) { listeners.put(key, listener); }
        public void remove(String key)                    { listeners.remove(key); }

        public void trigger(A arg) {
            for (Map.Entry<String, Consumer<A>> e : new ArrayList<>(listeners.entrySet())) {
                if (e.getValue() == null) continue;
                try {
                    e.getValue().accept(arg);
                } catch (Exception ex) {
                    System.err.println("리스너 오류 [" + e.getKey() + "]");
                    ex.printStackTrace();
                }
            }
        }
    }

    // 2 Parameters
    public static class Event2<A, B> {
        private final Map<String, BiConsumer<A, B>> listeners = new LinkedHashMap<>();

        public void add(String key, BiConsumer<A, B> listener) { listeners.put(key, listener); }
        public void remove(String key)                         { listeners.remove(key); }

        public void trigger(A a, B b) {
            for (Map.Entry<String, BiConsumer<A, B>> e : new ArrayList<>(listeners.entrySet())) {
                if (e.getValue() == null) continue;
                try {
                    e.getValue().accept(a, b);
                } catch (Exception ex) {
                    System.err.println("리스너 오류 [" + e.getKey() + "]");
                    ex.printStackTrace();
                }
            }
        }
    }

    // 3 Parameters
    public static class Event3<A, B, C> {
        private final Map<String, TriConsumer<A, B, C>> listeners = new LinkedHashMap<>();

        public void add(String key, TriConsumer<A, B, C> listener) { listeners.put(key, listener); }
        public void remove(String key)                         { listeners.remove(key); }

        public void trigger(A a, B b, C c) {
            for (Map.Entry<String, TriConsumer<A, B, C>> e : new ArrayList<>(listeners.entrySet())) {
                if (e.getValue() == null) continue;
                try {
                    e.getValue().accept(a, b, c);
                } catch (Exception ex) {
                    System.err.println("리스너 오류 [" + e.getKey() + "]");
                    ex.printStackTrace();
                }
            }
        }
    }
}
