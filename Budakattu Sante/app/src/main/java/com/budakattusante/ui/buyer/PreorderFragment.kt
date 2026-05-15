package com.budakattusante.ui.buyer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.FragmentPreorderBinding
import com.budakattusante.ui.viewmodel.OrderViewModel
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Preorder screen where buyer selects quantity and confirms order.
 * Validates against available stock before placing order.
 * Reduces stock in Room DB after successful order.
 */
@AndroidEntryPoint
class PreorderFragment : Fragment() {

    private var _binding: FragmentPreorderBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()
    private val orderViewModel: OrderViewModel by activityViewModels()

    @Inject
    lateinit var sessionManager: SessionManager

    private var currentQuantity = 1
    private var unitPrice = 0.0
    private var availableStock = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPreorderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = arguments?.getInt("productId") ?: -1
        if (productId == -1) {
            findNavController().popBackStack()
            return
        }

        productViewModel.loadProductById(productId)
        observeProduct()
        observeOrderResult()
        setupQuantityButtons()

        binding.btnConfirmOrder.setOnClickListener {
            confirmOrder(productId)
        }
    }

    private fun observeProduct() {
        productViewModel.selectedProduct.observe(viewLifecycleOwner) { product ->
            if (product == null) return@observe

            unitPrice      = product.price
            availableStock = product.stock

            binding.tvProductName.text    = product.name
            binding.tvUnitPrice.text      = "₹${product.price.toLong()}"
            binding.tvAvailableStock.text = "${product.stock} units"

            updateTotal()
        }
    }

    private fun setupQuantityButtons() {
        binding.btnIncrease.setOnClickListener {
            if (currentQuantity < availableStock) {
                currentQuantity++
                binding.tvQuantity.text = currentQuantity.toString()
                updateTotal()
            } else {
                Toast.makeText(requireContext(), "Max stock: $availableStock units", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDecrease.setOnClickListener {
            if (currentQuantity > 1) {
                currentQuantity--
                binding.tvQuantity.text = currentQuantity.toString()
                updateTotal()
            }
        }
    }

    private fun updateTotal() {
        val total = currentQuantity * unitPrice
        binding.tvTotalAmount.text = "₹${total.toLong()}"
    }

    private fun confirmOrder(productId: Int) {
        val product = productViewModel.selectedProduct.value ?: return
        val buyerId = sessionManager.getUserId()

        orderViewModel.placeOrder(
            productId     = productId,
            buyerId       = buyerId,
            productName   = product.name,
            quantity      = currentQuantity,
            pricePerUnit  = unitPrice,
            availableStock = availableStock
        )
    }

    private fun observeOrderResult() {
        orderViewModel.orderResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess { message ->
                Toast.makeText(requireContext(), "✅ $message", Toast.LENGTH_LONG).show()
                // Navigate back to home after successful order
                findNavController().popBackStack(
                    com.budakattusante.R.id.buyerHomeFragment,
                    false
                )
            }
            result.onFailure { e ->
                Toast.makeText(requireContext(), "❌ ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
