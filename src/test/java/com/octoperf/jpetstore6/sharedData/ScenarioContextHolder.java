package com.octoperf.jpetstore6.sharedData;

/**
 * The ScenarioContextHolder class provides thread-local storage for the {@link ScenarioContext} object.
 * It allows each thread to have its own instance of {@link ScenarioContext}, ensuring that data is isolated between threads.
 */
public class ScenarioContextHolder {

    /**
     * A thread-local storage for {@link ScenarioContext} instances. Each thread has its own {@link ScenarioContext} instance.
     */
    private static final ThreadLocal<ScenarioContext> context = ThreadLocal.withInitial(ScenarioContext::new);

    /**
     * Retrieves the {@link ScenarioContext} instance for the current thread.
     *
     * @return the {@link ScenarioContext} instance associated with the current thread
     */
    public static ScenarioContext getContext() {
        return context.get();
    }

    /**
     * Clears the {@link ScenarioContext} instance for the current thread, removing it from thread-local storage.
     */
    public static void clear() {
        context.remove();
    }
}