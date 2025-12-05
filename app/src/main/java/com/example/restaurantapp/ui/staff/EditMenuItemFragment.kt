package com.example.restaurantapp.ui.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.databinding.FragmentEditMenuItemBinding

class EditMenuItemFragment : Fragment() {

    private var _binding: FragmentEditMenuItemBinding? = null
    private val binding get() = _binding!!
    private val args: EditMenuItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditMenuItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupForm()
    }

    private fun setupToolbar() {
        binding.toolbar.title = if (args.isNewItem) "Add Menu Item" else "Edit Menu Item"
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(
            requireContext(),
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupForm() {
        // UI only - no functionality
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

