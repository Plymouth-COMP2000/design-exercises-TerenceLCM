package com.example.restaurantapp.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.databinding.FragmentMenuItemDetailBinding

class MenuItemDetailFragment : Fragment() {

    private var _binding: FragmentMenuItemDetailBinding? = null
    private val binding get() = _binding!!
    private val args: MenuItemDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        displayMenuItemDetails()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Menu Item"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun displayMenuItemDetails() {
        if (args.menuItemName.isNotEmpty()) {
            binding.tvItemName.text = args.menuItemName
        }
        if (args.menuItemPrice > 0) {
            binding.tvItemPrice.text = "RM ${String.format("%.2f", args.menuItemPrice)}"
        }
        if (args.menuItemImageResId != 0) {
            binding.ivMenuItemImage.setImageResource(args.menuItemImageResId)
        }
        if (args.menuItemDescription.isNotEmpty()) {
            binding.tvItemDescription.text = args.menuItemDescription
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

