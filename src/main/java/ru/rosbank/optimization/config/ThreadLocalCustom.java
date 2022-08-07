package ru.rosbank.optimization.config;

public class ThreadLocalCustom {
    private static final ThreadLocal<Context> userContext = new ThreadLocal<>();

    public static void setContext(Context context) {
        userContext.set(context);
    }

    public static Context getContext() {
        return userContext.get();
    }

    public static void clearContext() {
        userContext.remove();
    }
}
