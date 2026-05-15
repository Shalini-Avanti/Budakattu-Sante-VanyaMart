package com.budakattusante.ui.buyer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.budakattusante.data.preferences.SessionManager;
import com.budakattusante.databinding.FragmentOrderHistoryBinding;
import com.budakattusante.ui.adapter.OrderAdapter;
import com.budakattusante.ui.viewmodel.OrderViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

/**
 * Displays all preorders placed by the logged-in buyer.
 * Shows empty state illustration when no orders exist.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u001a\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/budakattusante/ui/buyer/OrderHistoryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/budakattusante/databinding/FragmentOrderHistoryBinding;", "binding", "getBinding", "()Lcom/budakattusante/databinding/FragmentOrderHistoryBinding;", "orderAdapter", "Lcom/budakattusante/ui/adapter/OrderAdapter;", "orderViewModel", "Lcom/budakattusante/ui/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/budakattusante/ui/viewmodel/OrderViewModel;", "orderViewModel$delegate", "Lkotlin/Lazy;", "sessionManager", "Lcom/budakattusante/data/preferences/SessionManager;", "getSessionManager", "()Lcom/budakattusante/data/preferences/SessionManager;", "setSessionManager", "(Lcom/budakattusante/data/preferences/SessionManager;)V", "observeOrders", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRecyclerView", "app_debug"})
public final class OrderHistoryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.budakattusante.databinding.FragmentOrderHistoryBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy orderViewModel$delegate = null;
    private com.budakattusante.ui.adapter.OrderAdapter orderAdapter;
    @javax.inject.Inject()
    public com.budakattusante.data.preferences.SessionManager sessionManager;
    
    public OrderHistoryFragment() {
        super();
    }
    
    private final com.budakattusante.databinding.FragmentOrderHistoryBinding getBinding() {
        return null;
    }
    
    private final com.budakattusante.ui.viewmodel.OrderViewModel getOrderViewModel() {
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
    
    private final void observeOrders() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}