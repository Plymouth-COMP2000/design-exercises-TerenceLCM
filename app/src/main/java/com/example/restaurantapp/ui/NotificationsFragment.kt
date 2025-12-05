package com.example.restaurantapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.restaurantapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupButtons()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Notifications"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupButtons() {
        // Save Changes button - no real functionality
        binding.btnSaveChanges.setOnClickListener {
            // UI only - no real functionality
        }

        // Discard button - no real functionality
        binding.btnDiscard.setOnClickListener {
            // UI only - no real functionality
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

