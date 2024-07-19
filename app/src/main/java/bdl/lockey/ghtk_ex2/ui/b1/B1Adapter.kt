package bdl.lockey.ghtk_ex2.ui.b1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bdl.lockey.ghtk_ex2.R

class B1Adapter(private val context: Context, private val dataset: List<CharacterModel>):
    RecyclerView.Adapter<B1Adapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvCharacter: TextView = view.findViewById(R.id.tv_character)
        val tvOccurrence: TextView = view.findViewById(R.id.tv_occurrence)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.tvCharacter.text = item.character
        holder.tvOccurrence.text = item.occurrence
    }

}