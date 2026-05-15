package com.budakattusante.ui.leader;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.budakattusante.R;
import com.budakattusante.data.preferences.SessionManager;
import com.budakattusante.databinding.FragmentLeaderDashboardBinding;
import com.budakattusante.ui.adapter.OrderAdapter;
import com.budakattusante.ui.auth.AuthViewModel;
import com.budakattusante.ui.auth.LoginActivity;
import com.budakattusante.ui.viewmodel.OrderViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006+"}, d2 = {"Lcom/budakattusante/ui/leader/LeaderDashboardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/budakattusante/databinding/FragmentLeaderDashboardBinding;", "authViewModel", "Lcom/budakattusante/ui/auth/AuthViewModel;", "getAuthViewModel", "()Lcom/budakattusante/ui/auth/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/budakattusante/databinding/FragmentLeaderDashboardBinding;", "orderAdapter", "Lcom/budakattusante/ui/adapter/OrderAdapter;", "orderViewModel", "Lcom/budakattusante/ui/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/budakattusante/ui/viewmodel/OrderViewModel;", "orderViewModel$delegate", "sessionManager", "Lcom/budakattusante/data/preferences/SessionManager;", "getSessionManager", "()Lcom/budakattusante/data/preferences/SessionManager;", "setSessionManager", "(Lcom/budakattusante/data/preferences/SessionManager;)V", "observeData", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupLogout", "setupQuickActions", "setupRecyclerView", "app_debug"})
public final class LeaderDashboardFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.budakattusante.databinding.FragmentLeaderDashboardBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy orderViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authViewModel$delegate = null;
    private com.budakattusante.ui.adapter.OrderAdapter orderAdapter;
    @javax.inject.Inject()
    public com.budakattusante.data.preferences.SessionManager sessionManager;
    
    public LeaderDashboardFragment() {
        super();
    }
    
    private final com.budakattusante.databinding.FragmentLeaderDashboardBinding getBinding() {
        return null;
    }
    
    private final com.budakattusante.ui.viewmodel.OrderViewModel getOrderViewModel() {
        return null;
    }
    
    private final com.budakattusante.ui.auth.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.preferences.SessionManager getSessionManager() {
        return null;
    }
    
    public final void setSessionManager(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.preferences.SessionManager p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupQuickActions() {
    }
    
    private final void setupLogout() {
    }
    
    private final void observeData() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}