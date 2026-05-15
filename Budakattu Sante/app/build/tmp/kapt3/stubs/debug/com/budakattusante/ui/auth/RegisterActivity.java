package com.budakattusante.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.budakattusante.databinding.ActivityRegisterBinding;
import com.budakattusante.ui.LeaderActivity;
import com.budakattusante.ui.MainActivity;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * Registration screen for new buyers and cooperative leaders.
 * Role is selected via ChipGroup (buyer is default).
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/budakattusante/ui/auth/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authViewModel", "Lcom/budakattusante/ui/auth/AuthViewModel;", "getAuthViewModel", "()Lcom/budakattusante/ui/auth/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/budakattusante/databinding/ActivityRegisterBinding;", "observeRegisterResult", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupClickListeners", "toast", "msg", "", "app_debug"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.budakattusante.databinding.ActivityRegisterBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authViewModel$delegate = null;
    
    public RegisterActivity() {
        super();
    }
    
    private final com.budakattusante.ui.auth.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeRegisterResult() {
    }
    
    private final void toast(java.lang.String msg) {
    }
}