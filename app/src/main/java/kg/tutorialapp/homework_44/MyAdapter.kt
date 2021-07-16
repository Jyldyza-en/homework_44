package kg.tutorialapp.homework_44

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(data: List<String>, var itemClickListener: OnItemClickListener ) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var listData: MutableList<String> = data as MutableList<String>

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(property: String, index: Int) {
            val text = view.findViewById<TextView>(R.id.item_text)
            view.findViewById<ImageView>(R.id.item_icon)
            val delete = view.findViewById<ImageButton>(R.id.btn_delete)

            text.text = property

            delete.setOnClickListener {
                itemClickListener.onItemClick(index)
            }
            

        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData[position], position)
    }

    fun deleteItem(index: Int) {
        listData.removeAt(index)
        notifyDataSetChanged()
    }


}