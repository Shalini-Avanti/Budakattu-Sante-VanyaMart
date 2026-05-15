package com.budakattusante.ui.leader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.budakattusante.R
import com.budakattusante.databinding.FragmentManageProductsBinding
import com.budakattusante.ui.adapter.ManageProductAdapter
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Manage Products screen for the Cooperative Leader.
 * Shows all products with Edit and Delete actions.
 * Edit navigates to AddProductFragment pre-filled.
 */
@AndroidEntryPoint
class ManageProductsFragment : Fragment() {

    private var _binding: FragmentManageProductsBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()
    private lateinit var manageAdapter: ManageProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManageProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeProducts()
    }

    private fun setupRecyclerView() {
        manageAdapter = ManageProductAdapter(
            onEdit = { product ->
                // Navigate to AddProductFragment with productId for editing
                val bundle = Bundle().apply { putInt("productId", product.id) }
                findNavController().navigate(R.id.action_manage_to_addProduct, bundle)
            },
            onDelete = { product ->
                AlertDialog.Builder(requireContext())
                    .setTitle("Delete Product")
                    .setMessage("Are you sure you want to delete \"${product.name}\"?")
                    .setPositiveButton("Delete") { _, _ ->
                        productViewModel.deleteProduct(product)
                    }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
        )
        binding.rvManageProducts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = manageAdapter
        }
    }

    private fun observeProducts() {
        productViewModel.allProducts.observe(viewLifecycleOwner) { products ->
            manageAdapter.submitList(products)
            binding.tvEmpty.visibility =
                if (products.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
