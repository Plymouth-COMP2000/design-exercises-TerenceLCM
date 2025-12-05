package com.example.restaurantapp.ui.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantapp.data.DummyDataProvider
import com.example.restaurantapp.databinding.FragmentStaffReservationListBinding
import com.example.restaurantapp.model.Reservation

class StaffReservationListFragment : Fragment() {

    private var _binding: FragmentStaffReservationListBinding? = null
    private val binding get() = _binding!!
    private lateinit var reservationAdapter: ReservationAdapter
    private val reservations = mutableListOf<Reservation>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStaffReservationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupReservationRecyclerView()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Reservations"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupReservationRecyclerView() {
        // Initialize reservations list
        reservations.clear()
        reservations.addAll(DummyDataProvider.getSampleReservations())

        reservationAdapter = ReservationAdapter(
            onActionClick = { reservation ->
                // Handle quick action click
                // UI only - no functionality
            },
            onCancelClick = { reservation, position ->
                // Remove reservation from the list
                reservations.removeAt(position)
                // Submit updated list to adapter
                reservationAdapter.submitList(reservations.toList()) {
                    // Show toast message after list is updated
                    Toast.makeText(requireContext(), "Reservation cancelled", Toast.LENGTH_SHORT).show()
                    // Update empty state visibility
                    binding.tvEmptyState.visibility = if (reservations.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        )

        binding.rvReservations.layoutManager = LinearLayoutManager(requireContext())
        binding.rvReservations.adapter = reservationAdapter

        // Submit initial list
        reservationAdapter.submitList(reservations.toList())

        // Show/hide empty state
        binding.tvEmptyState.visibility = if (reservations.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

