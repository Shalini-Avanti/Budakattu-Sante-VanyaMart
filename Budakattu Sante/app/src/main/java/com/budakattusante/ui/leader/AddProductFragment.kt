package com.budakattusante.ui.leader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.budakattusante.data.db.entity.Product
import com.budakattusante.databinding.FragmentAddProductBinding
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Form screen for Cooperative Leader to add a new product.
 * When productId argument != -1, it pre-fills the form for editing.
 * All fields are validated before saving.
 */
@AndroidEntryPoint
class AddProductFragment : Fragment() {

    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()

    // Holds existing product if in edit mode
    private var editProductId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editProductId = arguments?.getInt("productId", -1) ?: -1

        if (editProductId != -1) {
            // Edit mode — load existing product
            binding.tvFormTitle.text = "Edit Product"
            productViewModel.loadProductById(editProductId)
            productViewModel.selectedProduct.observe(viewLifecycleOwner) { product ->
                product?.let { prefillForm(it) }
            }
        }

        observeResult()
        setupSaveButton()
    }

    private fun prefillForm(product: Product) {
        binding.etProductName.setText(product.name)
        binding.etDescription.setText(product.description)
        binding.etPrice.setText(product.price.toLong().toString())
        binding.etMspPrice.setText(product.mspPrice.toLong().toString())
        binding.etStock.setText(product.stock.toString())
        binding.etSeason.setText(product.season)
        binding.etVillage.setText(product.village)
        binding.etFamilyName.setText(product.category) // repurpose for display

        // Select matching category chip
        when (product.category) {
            "Forest Produce"  -> binding.chipCatForest.isChecked     = true
            "Handicrafts"     -> binding.chipCatHandicraft.isChecked = true
            "Herbal Products" -> binding.chipCatHerbal.isChecked     = true
            "Grains & Seeds"  -> binding.chipCatGrains.isChecked     = true
            "Honey & Sweets"  -> binding.chipCatHoney.isChecked      = true
        }
    }

    private fun setupSaveButton() {
        binding.btnSaveProduct.setOnClickListener {
            val name       = binding.etProductName.text.toString().trim()
            val desc       = binding.etDescription.text.toString().trim()
            val priceStr   = binding.etPrice.text.toString().trim()
            val mspStr     = binding.etMspPrice.text.toString().trim()
            val stockStr   = binding.etStock.text.toString().trim()
            val season     = binding.etSeason.text.toString().trim().ifEmpty { "All Season" }
            val village    = binding.etVillage.text.toString().trim()
            val family     = binding.etFamilyName.text.toString().trim().ifEmpty { "Tribal Family" }
            val category   = getSelectedCategory()

            // Validation
            when {
                name.isEmpty()     -> toast("Product name is required")
                desc.isEmpty()     -> toast("Description is required")
                priceStr.isEmpty() -> toast("Price is required")
                mspStr.isEmpty()   -> toast("MSP price is required")
                stockStr.isEmpty() -> toast("Stock quantity is required")
                village.isEmpty()  -> toast("Village name is required")
                category.isEmpty() -> toast("Please select a category")
                else -> {
                    val price = priceStr.toDoubleOrNull() ?: 0.0
                    val msp   = mspStr.toDoubleOrNull() ?: 0.0
                    val stock = stockStr.toIntOrNull() ?: 0

                    val audioText = "$name from $village. Price rupees ${price.toLong()}. " +
                            "Category $category. $desc"

                    val product = Product(
                        id            = if (editProductId != -1) editProductId else 0,
                        name          = name,
                        description   = desc,
                        category      = category,
                        imageRes      = "img_default",
                        price         = price,
                        mspPrice      = msp,
                        stock         = stock,
                        season        = season,
                        tribalFamilyId = 1,
                        village       = village,
                        audioText     = audioText
                    )

                    if (editProductId != -1) {
                        productViewModel.updateProduct(product)
                    } else {
                        productViewModel.addProduct(product)
                    }
                }
            }
        }
    }

    private fun getSelectedCategory(): String = when {
        binding.chipCatForest.isChecked     -> "Forest Produce"
        binding.chipCatHandicraft.isChecked -> "Handicrafts"
        binding.chipCatHerbal.isChecked     -> "Herbal Products"
        binding.chipCatGrains.isChecked     -> "Grains & Seeds"
        binding.chipCatHoney.isChecked      -> "Honey & Sweets"
        else -> ""
    }

    private fun observeResult() {
        productViewModel.operationResult.observe(viewLifecycleOwner) { message ->
            toast(message)
            if (message.contains("success", ignoreCase = true) ||
                message.contains("updated", ignoreCase = true)) {
                clearForm()
            }
        }
    }

    private fun clearForm() {
        binding.etProductName.text?.clear()
        binding.etDescription.text?.clear()
        binding.etPrice.text?.clear()
        binding.etMspPrice.text?.clear()
        binding.etStock.text?.clear()
        binding.etSeason.text?.clear()
        binding.etVillage.text?.clear()
        binding.etFamilyName.text?.clear()
        binding.chipGroupCategory.clearCheck()
    }

    private fun toast(msg: String) =
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
