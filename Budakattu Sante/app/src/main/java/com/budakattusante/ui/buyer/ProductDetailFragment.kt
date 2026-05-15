package com.budakattusante.ui.buyer

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.budakattusante.R
import com.budakattusante.databinding.FragmentProductDetailBinding
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

/**
 * Displays full product details including:
 * - Name, category, price, MSP price
 * - Village, season, tribal family, stock
 * - Description
 * - Audio description via TextToSpeech
 * - Preorder button (disabled if out of stock)
 */
@AndroidEntryPoint
class ProductDetailFragment : Fragment(), TextToSpeech.OnInitListener {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()
    private var textToSpeech: TextToSpeech? = null
    private var ttsReady = false
    private var currentAudioText = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve product ID passed via Bundle
        val productId = arguments?.getInt("productId") ?: -1
        if (productId == -1) {
            findNavController().popBackStack()
            return
        }

        // Initialise TextToSpeech engine
        textToSpeech = TextToSpeech(requireContext(), this)

        productViewModel.loadProductById(productId)
        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        productViewModel.selectedProduct.observe(viewLifecycleOwner) { product ->
            if (product == null) return@observe

            currentAudioText = product.audioText

            // Set category-based background color for header
            binding.productImageContainer.setBackgroundColor(categoryColor(product.category))

            // Set category emoji
            binding.tvProductEmoji.text = categoryEmoji(product.category)

            // Populate fields
            binding.chipCategory.text    = product.category
            binding.tvProductName.text   = product.name
            binding.tvPrice.text         = "₹${product.price.toLong()}"
            binding.tvMspPrice.text      = "₹${product.mspPrice.toLong()}"
            binding.tvVillage.text       = product.village
            binding.tvSeason.text        = product.season
            binding.tvDescription.text   = product.description

            // Stock display
            if (product.stock > 0) {
                binding.tvStock.text  = "${product.stock} units"
                binding.tvStock.setTextColor(Color.parseColor("#2E7D32"))
                binding.btnPreorder.visibility   = View.VISIBLE
                binding.tvOutOfStock.visibility  = View.GONE
            } else {
                binding.tvStock.text  = "Sold Out"
                binding.tvStock.setTextColor(Color.parseColor("#B00020"))
                binding.btnPreorder.visibility   = View.GONE
                binding.tvOutOfStock.visibility  = View.VISIBLE
            }
        }

        productViewModel.selectedFamily.observe(viewLifecycleOwner) { family ->
            binding.tvTribalFamily.text = family?.familyName ?: "—"
        }
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnListen.setOnClickListener {
            speakText(currentAudioText)
            binding.btnListen.visibility   = View.GONE
            binding.btnStopAudio.visibility = View.VISIBLE
        }

        binding.btnStopAudio.setOnClickListener {
            stopSpeaking()
            binding.btnListen.visibility   = View.VISIBLE
            binding.btnStopAudio.visibility = View.GONE
        }

        binding.btnPreorder.setOnClickListener {
            val productId = arguments?.getInt("productId") ?: return@setOnClickListener
            val bundle = Bundle().apply { putInt("productId", productId) }
            findNavController().navigate(R.id.action_detail_to_preorder, bundle)
        }
    }

    // ---- TextToSpeech ----

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech?.language = Locale.ENGLISH
            ttsReady = true
        }
    }

    private fun speakText(text: String) {
        if (ttsReady && text.isNotEmpty()) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_desc")
        } else {
            Toast.makeText(requireContext(), "TTS not ready, please wait.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopSpeaking() {
        textToSpeech?.stop()
    }

    // ---- Helpers ----

    private fun categoryColor(category: String): Int = when (category) {
        "Forest Produce"  -> Color.parseColor("#388E3C")
        "Handicrafts"     -> Color.parseColor("#795548")
        "Herbal Products" -> Color.parseColor("#1976D2")
        "Grains & Seeds"  -> Color.parseColor("#F57C00")
        "Honey & Sweets"  -> Color.parseColor("#FFA000")
        else              -> Color.parseColor("#2E7D32")
    }

    private fun categoryEmoji(category: String): String = when (category) {
        "Forest Produce"  -> "🌿"
        "Handicrafts"     -> "🧺"
        "Herbal Products" -> "🌱"
        "Grains & Seeds"  -> "🌾"
        "Honey & Sweets"  -> "🍯"
        else              -> "🍃"
    }

    override fun onDestroyView() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        textToSpeech = null
        _binding = null
        super.onDestroyView()
    }
}
