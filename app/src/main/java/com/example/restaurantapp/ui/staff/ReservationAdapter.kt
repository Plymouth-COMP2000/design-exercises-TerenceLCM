package com.example.restaurantapp.ui.staff

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.R
import com.example.restaurantapp.databinding.ComponentReservationItemCardBinding
import com.example.restaurantapp.model.Reservation
import com.example.restaurantapp.model.ReservationStatus

class ReservationAdapter(
    private val onActionClick: (Reservation) -> Unit,
    private val onCancelClick: ((Reservation, Int) -> Unit)? = null
) : ListAdapter<Reservation, ReservationAdapter.ReservationViewHolder>(ReservationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val binding = ComponentReservationItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReservationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ReservationViewHolder(
        private val binding: ComponentReservationItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(reservation: Reservation, position: Int) {
            binding.tvGuestName.text = reservation.customerName
            binding.tvReservationId.text = reservation.id
            binding.tvReservationDate.text = "${reservation.date} at ${reservation.time}"
            binding.tvNumberOfGuests.text = "${reservation.partySize} ${if (reservation.partySize == 1) "guest" else "guests"}"

            // Set status badge
            when (reservation.status) {
                ReservationStatus.PENDING -> {
                    binding.tvStatusBadge.text = "Pending"
                    binding.tvStatusBadge.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_status_badge_pending
                    )
                    binding.tvStatusBadge.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.md_theme_light_onTertiaryContainer)
                    )
                }
                ReservationStatus.CONFIRMED -> {
                    binding.tvStatusBadge.text = "Confirmed"
                    binding.tvStatusBadge.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_status_badge_confirmed
                    )
                    binding.tvStatusBadge.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.md_theme_light_onPrimaryContainer)
                    )
                }
                ReservationStatus.CANCELLED -> {
                    binding.tvStatusBadge.text = "Cancelled"
                    binding.tvStatusBadge.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_status_badge_cancelled
                    )
                    binding.tvStatusBadge.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.md_theme_light_onErrorContainer)
                    )
                }
            }

            // Set quick action button text based on status
            when (reservation.status) {
                ReservationStatus.PENDING -> {
                    binding.btnQuickAction.text = "Confirm"
                    binding.btnQuickAction.visibility = ViewGroup.VISIBLE
                }
                ReservationStatus.CONFIRMED -> {
                    binding.btnQuickAction.text = "View"
                    binding.btnQuickAction.visibility = ViewGroup.VISIBLE
                }
                ReservationStatus.CANCELLED -> {
                    binding.btnQuickAction.visibility = ViewGroup.GONE
                }
            }

            // Show/hide cancel button based on status and whether cancel callback is provided
            if (onCancelClick != null && reservation.status != ReservationStatus.CANCELLED) {
                binding.btnCancel.visibility = ViewGroup.VISIBLE
                binding.btnCancel.setOnClickListener {
                    onCancelClick(reservation, position)
                }
            } else {
                binding.btnCancel.visibility = ViewGroup.GONE
            }

            binding.btnQuickAction.setOnClickListener {
                onActionClick(reservation)
            }
        }
    }

    private class ReservationDiffCallback : DiffUtil.ItemCallback<Reservation>() {
        override fun areItemsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
            return oldItem == newItem
        }
    }
}

