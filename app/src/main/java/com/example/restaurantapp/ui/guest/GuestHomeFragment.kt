package com.example.restaurantapp.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantapp.data.DummyDataProvider
import com.example.restaurantapp.databinding.FragmentGuestHomeBinding

class GuestHomeFragment : Fragment() {

    private var _binding: FragmentGuestHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuAdapter: MenuItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuestHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupMenuRecyclerView()

        binding.btnMakeReservation.setOnClickListener {
            findNavController().navigate(GuestHomeFragmentDirections.actionGuestHomeToReservation())
        }

        binding.ivNotifications.setOnClickListener {
            findNavController().navigate(GuestHomeFragmentDirections.actionGuestHomeToNotifications())
        }
    }

    private fun setupToolbar() {
        // Toolbar setup - title removed for minimal design
    }

    private fun setupMenuRecyclerView() {
        menuAdapter = MenuItemAdapter(
            onItemClick = { menuItem ->
                val action = GuestHomeFragmentDirections.actionGuestHomeToMenuItemDetail(
                    menuItemId = menuItem.id,
                    menuItemName = menuItem.name,
                    menuItemPrice = menuItem.price.toFloat(),
                    menuItemImageResId = menuItem.imageResId,
                    menuItemDescription = menuItem.description
                )
                findNavController().navigate(action)
            }
        )

        binding.rvMenuItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenuItems.adapter = menuAdapter

        // Load dummy data
        menuAdapter.submitList(DummyDataProvider.getSampleMenuItems())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

