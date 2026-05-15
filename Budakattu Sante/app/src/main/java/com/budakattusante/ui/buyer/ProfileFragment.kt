package com.budakattusante.ui.buyer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.FragmentProfileBinding
import com.budakattusante.ui.auth.AuthViewModel
import com.budakattusante.ui.auth.LoginActivity
import com.budakattusante.ui.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Buyer profile screen showing account info, order count, and logout option.
 */
@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by activityViewModels()
    private val orderViewModel: OrderViewModel by activityViewModels()

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateProfile()
        loadOrderCount()
        setupLogout()
    }

    private fun populateProfile() {
        val name    = sessionManager.getUserName()
        val phone   = sessionManager.getUserPhone()
        val village = sessionManager.getUserVillage()

        binding.tvProfileName.text    = name
        binding.tvAvatarInitial.text  = name.firstOrNull()?.uppercase() ?: "B"
        binding.tvPhone.text          = phone
        binding.tvVillage.text        = village.ifEmpty { "—" }
        binding.chipRole.text         = "Buyer"
    }

    private fun loadOrderCount() {
        val buyerId = sessionManager.getUserId()
        orderViewModel.loadBuyerOrders(buyerId)
        orderViewModel.buyerOrders.observe(viewLifecycleOwner) { orders ->
            binding.tvOrderCount.text = orders.size.toString()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
