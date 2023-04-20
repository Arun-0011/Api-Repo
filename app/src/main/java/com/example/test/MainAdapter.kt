package com.example.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.SingleCardDesignBinding
import com.squareup.picasso.Picasso

class MainAdapter(
    private var list: List<TokenDetail>,
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: SingleCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SingleCardDesignBinding
                .inflate(LayoutInflater
                    .from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.itemName.text = this.token
                binding.tokenPrice.text = this.tokenPrice
                binding.tokenValue.text = this.tokenValue.toString()
                Picasso.with(holder.itemView.context).load(this.tokenImage).into(binding.imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}