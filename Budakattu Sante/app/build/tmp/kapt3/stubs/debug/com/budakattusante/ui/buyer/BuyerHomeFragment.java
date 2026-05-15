package com.budakattusante.ui.buyer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.budakattusante.R;
import com.budakattusante.data.db.entity.Product;
import com.budakattusante.data.preferences.SessionManager;
import com.budakattusante.databinding.FragmentBuyerHomeBinding;
import com.budakattusante.ui.adapter.ProductAdapter;
import com.budakattusante.ui.viewmodel.ProductViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

/**
 * Buyer home screen.
 * Shows greeting, category filter chips, and all products in a list.
 * Tapping the search bar navigates to ProductListFragment.
 * Tapping a product navigates to ProductDetailFragment.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u001a\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010\'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/budakattusante/ui/buyer/BuyerHomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/budakattusante/databinding/FragmentBuyerHomeBinding;", "binding", "getBinding", "()Lcom/budakattusante/databinding/FragmentBuyerHomeBinding;", "productAdapter", "Lcom/budakattusante/ui/adapter/ProductAdapter;", "productViewModel", "Lcom/budakattusante/ui/viewmodel/ProductViewModel;", "getProductViewModel", "()Lcom/budakattusante/ui/viewmodel/ProductViewModel;", "productViewModel$delegate", "Lkotlin/Lazy;", "sessionManager", "Lcom/budakattusante/data/preferences/SessionManager;", "getSessionManager", "()Lcom/budakattusante/data/preferences/SessionManager;", "setSessionManager", "(Lcom/budakattusante/data/preferences/SessionManager;)V", "navigateToDetail", "", "productId", "", "observeProducts", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupCategoryChips", "setupClickListeners", "setupGreeting", "setupRecyclerView", "app_debug"})
public final class BuyerHomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.budakattusante.databinding.FragmentBuyerHomeBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy productViewModel$delegate = null;
    private com.budakattusante.ui.adapter.ProductAdapter productAdapter;
    @javax.inject.Inject()
    public com.budakattusante.data.preferences.SessionManager sessionManager;
    
    public BuyerHomeFragment() {
        super();
    }
    
    private final com.budakattusante.databinding.FragmentBuyerHomeBinding getBinding() {
        return null;
    }
    
    private final com.budakattusante.ui.viewmodel.ProductViewModel getProductViewModel() {
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
    
    private final void setupGreeting() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupCategoryChips() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeProducts() {
    }
    
    private final void navigateToDetail(int productId) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}