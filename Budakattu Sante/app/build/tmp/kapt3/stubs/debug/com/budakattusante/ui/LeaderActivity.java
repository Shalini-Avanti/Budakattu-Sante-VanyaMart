package com.budakattusante.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import com.budakattusante.R;
import com.budakattusante.databinding.ActivityLeaderBinding;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * Main activity for COOPERATIVE LEADER role.
 * Hosts the NavHostFragment with nav_leader.xml navigation graph.
 * BottomNavigationView controls:
 * Dashboard → Add Product → Manage → Analytics
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/budakattusante/ui/LeaderActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/budakattusante/databinding/ActivityLeaderBinding;", "navController", "Landroidx/navigation/NavController;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "app_debug"})
public final class LeaderActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.budakattusante.databinding.ActivityLeaderBinding binding;
    private androidx.navigation.NavController navController;
    
    public LeaderActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}