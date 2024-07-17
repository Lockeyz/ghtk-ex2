package bdl.lockey.ghtk_ex2.ui.b3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bdl.lockey.ghtk_ex2.R

class B3Adapter(private val context: Context, private val dataset: List<HistoryModel>) :
    RecyclerView.Adapter<B3Adapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvIsUp: TextView = view.findViewById(R.id.tv_is_up)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.tvIsUp.text = if (item.isUp) "UP" else "DOWN"
        holder.tvTitle.text = item.title
    }
}