package com.budakattusante.ui.buyer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.FragmentOrderHistoryBinding
import com.budakattusante.ui.adapter.OrderAdapter
import com.budakattusante.ui.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Displays all preorders placed by the logged-in buyer.
 * Shows empty state illustration when no orders exist.
 */
@AndroidEntryPoint
class OrderHistoryFragment : Fragment() {

    private var _binding: FragmentOrderHistoryBinding? = null
    private val binding get() = _binding!!

    private val orderViewModel: OrderViewModel by activityViewModels()
    private lateinit var orderAdapter: OrderAdapter

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        val buyerId = sessionManager.getUserId()
        orderViewModel.loadBuyerOrders(buyerId)

        observeOrders()
    }

    private fun setupRecyclerView() {
        orderAdapter = OrderAdapter()
        binding.rvOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = orderAdapter
        }
    }

    private fun observeOrders() {
        orderViewModel.buyerOrders.observe(viewLifecycleOwner) { orders ->
            orderAdapter.submitList(orders)
            if (orders.isEmpty()) {
                binding.rvOrders.visibility   = View.GONE
                binding.emptyState.visibility = View.VISIBLE
            } else {
                binding.rvOrders.visibility   = View.VISIBLE
                binding.emptyState.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
