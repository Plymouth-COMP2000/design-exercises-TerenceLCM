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
import com.example.restaurantapp.databinding.FragmentStaffMenuManagementBinding
import com.example.restaurantapp.model.MenuItem
import com.example.restaurantapp.ui.guest.MenuItemAdapter

class StaffMenuManagementFragment : Fragment() {

    private var _binding: FragmentStaffMenuManagementBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuAdapter: MenuItemAdapter
    private val menuItems = mutableListOf<MenuItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStaffMenuManagementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupMenuRecyclerView()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Menu Management"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupMenuRecyclerView() {
        // Initialize menu items list
        menuItems.clear()
        menuItems.addAll(DummyDataProvider.getSampleMenuItems())

        menuAdapter = MenuItemAdapter(
            onItemClick = { menuItem ->
                // Handle item click if needed (e.g., navigate to edit screen)
            },
            onDeleteClick = { menuItem, position ->
                // Remove item from the list
                menuItems.removeAt(position)
                // Submit updated list to adapter
                menuAdapter.submitList(menuItems.toList()) {
                    // Show toast message after list is updated
                    Toast.makeText(requireContext(), "Menu item deleted", Toast.LENGTH_SHORT).show()
                }
            }
        )

        binding.rvMenuItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenuItems.adapter = menuAdapter

        // Submit initial list
        menuAdapter.submitList(menuItems.toList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

