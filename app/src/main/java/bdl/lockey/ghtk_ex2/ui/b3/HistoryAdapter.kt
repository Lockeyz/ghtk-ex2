package bdl.lockey.ghtk_ex2.ui.b3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bdl.lockey.ghtk_ex2.R
import bdl.lockey.ghtk_ex2.databinding.ItemHistoryBinding

class HistoryAdapter(private val dataset: List<HistoryModel>) :
    RecyclerView.Adapter<HistoryAdapter.ItemViewHolder>() {

    class ItemViewHolder(binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle: TextView = binding.tvTitle
        val tvDate: TextView = binding.tvDate
        val tvIsUp: TextView = binding.tvIsUp
        val imageIcon: ImageView = binding.imageUp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        if (!item.isUp) {
            holder.imageIcon.setImageResource(R.drawable.ic_down)
            holder.tvIsUp.text
        } else {
            holder.imageIcon.setImageResource(R.drawable.ic_up)
            holder.tvIsUp.text = "UP"
        }
        holder.tvTitle.text = item.title
        holder.tvDate.text = "18/07/2024"


    }
}