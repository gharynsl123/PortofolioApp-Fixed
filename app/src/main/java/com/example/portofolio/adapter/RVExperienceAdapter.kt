package com.example.portofolio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portofolio.R
import com.example.portofolio.data.Portofolio
import com.example.portofolio.databinding.ItemExperienceBinding

class RVExperienceAdapter : RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>(){

    private val listData = ArrayList<Portofolio>()
    var onItemClicked: ((Portofolio) -> Unit)? = null

    fun setData(data : List<Portofolio>?){
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class ExperienceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data : Portofolio){
            binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size
}