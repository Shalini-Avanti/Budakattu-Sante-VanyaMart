package com.budakattusante.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.budakattusante.data.preferences.SessionManager;
import com.budakattusante.databinding.ActivitySplashBinding;
import com.budakattusante.ui.LeaderActivity;
import com.budakattusante.ui.MainActivity;
import com.budakattusante.ui.auth.LoginActivity;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

/**
 * Entry point splash screen.
 * Checks existing session and routes to the correct activity.
 * Displays for 2.5 seconds before navigating.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/budakattusante/ui/splash/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/budakattusante/databinding/ActivitySplashBinding;", "sessionManager", "Lcom/budakattusante/data/preferences/SessionManager;", "getSessionManager", "()Lcom/budakattusante/data/preferences/SessionManager;", "setSessionManager", "(Lcom/budakattusante/data/preferences/SessionManager;)V", "navigateToNextScreen", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.budakattusante.databinding.ActivitySplashBinding binding;
    @javax.inject.Inject()
    public com.budakattusante.data.preferences.SessionManager sessionManager;
    
    public SplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.preferences.SessionManager getSessionManager() {
        return null;
    }
    
    public final void setSessionManager(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.preferences.SessionManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navigateToNextScreen() {
    }
}