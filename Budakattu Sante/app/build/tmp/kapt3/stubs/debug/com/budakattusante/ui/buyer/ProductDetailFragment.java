package com.budakattusante.ui.buyer;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.budakattusante.R;
import com.budakattusante.databinding.FragmentProductDetailBinding;
import com.budakattusante.ui.viewmodel.ProductViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Locale;

/**
 * Displays full product details including:
 * - Name, category, price, MSP price
 * - Village, season, tribal family, stock
 * - Description
 * - Audio description via TextToSpeech
 * - Preorder button (disabled if out of stock)
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0016H\u0016J\u001a\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/budakattusante/ui/buyer/ProductDetailFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "_binding", "Lcom/budakattusante/databinding/FragmentProductDetailBinding;", "binding", "getBinding", "()Lcom/budakattusante/databinding/FragmentProductDetailBinding;", "currentAudioText", "", "productViewModel", "Lcom/budakattusante/ui/viewmodel/ProductViewModel;", "getProductViewModel", "()Lcom/budakattusante/ui/viewmodel/ProductViewModel;", "productViewModel$delegate", "Lkotlin/Lazy;", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "ttsReady", "", "categoryColor", "", "category", "categoryEmoji", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onInit", "status", "onViewCreated", "view", "setupClickListeners", "setupObservers", "speakText", "text", "stopSpeaking", "app_debug"})
public final class ProductDetailFragment extends androidx.fragment.app.Fragment implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.Nullable()
    private com.budakattusante.databinding.FragmentProductDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy productViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech textToSpeech;
    private boolean ttsReady = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentAudioText = "";
    
    public ProductDetailFragment() {
        super();
    }
    
    private final com.budakattusante.databinding.FragmentProductDetailBinding getBinding() {
        return null;
    }
    
    private final com.budakattusante.ui.viewmodel.ProductViewModel getProductViewModel() {
        return null;
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
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    private final void speakText(java.lang.String text) {
    }
    
    private final void stopSpeaking() {
    }
    
    private final int categoryColor(java.lang.String category) {
        return 0;
    }
    
    private final java.lang.String categoryEmoji(java.lang.String category) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}