package com.example.firstproject.irregularverb

import android.animation.AnimatorInflater
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class IrregularAdapter(val context: Context, val list: List<IrregularModel>)
    :RecyclerView.Adapter<IrregularAdapter.MyViewHolder>() {

    private val cardFlipOutAnimator = AnimatorInflater.loadAnimator(context, R.animator.card_flip_out)
    private val cardFlipInAnimator = AnimatorInflater.loadAnimator(context, R.animator.card_flip_in)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.irregular_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.txtword.text = data.word

        if (data.flip) {
            holder.container2.visibility = View.VISIBLE
            holder.txtword.visibility = View.GONE
        } else {
            holder.container2.visibility = View.GONE
            holder.txtword.visibility = View.VISIBLE
            holder.txtword.text = data.word
        }

        holder.container.setOnClickListener {
            cardFlipOutAnimator.setTarget(holder.container)
            cardFlipOutAnimator.start()
            cardFlipInAnimator.setTarget(holder.container)
            cardFlipInAnimator.start()

            if (!data.flip) {
                holder.container2.visibility = View.VISIBLE
                holder.txtword.visibility = View.GONE
            } else {
                holder.container2.visibility = View.GONE
                holder.txtword.visibility = View.VISIBLE
                holder.txtword.text = data.word
            }
            data.flip = !data.flip
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtword = itemView.findViewById<TextView>(R.id.word)
        var container = itemView.findViewById<CardView>(R.id.container)
        var container2 = itemView.findViewById<LinearLayout>(R.id.container2)
    }
}