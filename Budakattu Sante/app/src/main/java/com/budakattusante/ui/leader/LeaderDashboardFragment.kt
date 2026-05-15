package com.budakattusante.ui.leader

import android.content.Intent
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
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.FragmentLeaderDashboardBinding
import com.budakattusante.ui.adapter.OrderAdapter
import com.budakattusante.ui.auth.AuthViewModel
import com.budakattusante.ui.auth.LoginActivity
import com.budakattusante.ui.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LeaderDashboardFragment : Fragment() {

    private var _binding: FragmentLeaderDashboardBinding? = null
    private val binding get() = _binding!!

    private val orderViewModel: OrderViewModel by activityViewModels()
    private val authViewModel: AuthViewModel by activityViewModels()
    private lateinit var orderAdapter: OrderAdapter

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvLeaderName.text = "Welcome, ${sessionManager.getUserName()}"

        setupRecyclerView()
        setupQuickActions()
        setupLogout()
        observeData()

        orderViewModel.loadAnalytics()
    }

    private fun setupRecyclerView() {
        orderAdapter = OrderAdapter()
        binding.rvRecentOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = orderAdapter
        }
    }

    private fun setupQuickActions() {
        binding.btnGoAddProduct.setOnClickListener {
            val options = androidx.navigation.NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(R.id.leaderDashboardFragment, false)
                .build()
            findNavController().navigate(R.id.addProductFragment, null, options)
        }
        binding.btnGoManage.setOnClickListener {
            val options = androidx.navigation.NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(R.id.leaderDashboardFragment, false)
                .build()
            findNavController().navigate(R.id.manageProductsFragment, null, options)
        }
    }

    private fun setupLogout() {
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout") { _, _ ->
                    authViewModel.logout()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }

    private fun observeData() {
        orderViewModel.productCount.observe(viewLifecycleOwner) { count ->
            binding.tvTotalProducts.text = count.toString()
        }
        orderViewModel.orderCount.observe(viewLifecycleOwner) { count ->
            binding.tvTotalOrders.text = count.toString()
        }
        orderViewModel.totalEarnings.observe(viewLifecycleOwner) { amount ->
            binding.tvEarnings.text = "₹${amount.toLong()}"
        }
        orderViewModel.allOrders.observe(viewLifecycleOwner) { orders ->
            orderAdapter.submitList(orders.take(5))
            binding.tvNoOrders.visibility =
                if (orders.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}