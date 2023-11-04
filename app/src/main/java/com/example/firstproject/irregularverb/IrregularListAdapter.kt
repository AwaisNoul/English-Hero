package com.example.firstproject.irregularverb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class IrregularListAdapter(val context : Context, var list : List<String>):
    RecyclerView.Adapter<IrregularListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.irregular_item_view, parent, false)
        return IrregularListAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position]
        var s=position+1
        holder.count.text="($s)"
        holder.container.setOnClickListener {
            if (holder.title.text == "hello"){
                val intent = Intent(context, IrregularVerb::class.java)
                context.startActivity(intent)
            }
            else{
                Toast.makeText(context, "No set Anyone Activity", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title  = itemView.findViewById<TextView>(R.id.title)
        val count  = itemView.findViewById<TextView>(R.id.count)
        val container  = itemView.findViewById<ConstraintLayout>(R.id.container)

        }


}