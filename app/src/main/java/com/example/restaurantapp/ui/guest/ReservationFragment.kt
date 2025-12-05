package com.example.restaurantapp.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.databinding.FragmentReservationBinding

class ReservationFragment : Fragment() {

    private var _binding: FragmentReservationBinding? = null
    private val binding get() = _binding!!
    private val args: ReservationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.btnEditReservation.setOnClickListener {
            findNavController().navigate(ReservationFragmentDirections.actionReservationToEditReservation())
        }

        binding.btnCancelReservation.setOnClickListener {
            findNavController().navigate(ReservationFragmentDirections.actionReservationToCancelReservation())
        }
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Make Reservation"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

