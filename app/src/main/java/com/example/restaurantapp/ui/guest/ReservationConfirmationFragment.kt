package com.example.restaurantapp.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.databinding.FragmentReservationConfirmationBinding

class ReservationConfirmationFragment : Fragment() {

    private var _binding: FragmentReservationConfirmationBinding? = null
    private val binding get() = _binding!!
    private val args: ReservationConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        displayConfirmationDetails()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Reservation Confirmed"
    }

    private fun displayConfirmationDetails() {
        binding.tvReservationId.text = args.reservationId
        binding.tvGuestName.text = args.guestName
        binding.tvReservationDate.text = args.reservationDate
        binding.tvReservationTime.text = args.reservationTime
        binding.tvNumberOfGuests.text = args.numberOfGuests.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

