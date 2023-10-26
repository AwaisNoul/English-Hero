package com.example.firstproject.alphabet

import android.animation.AnimatorInflater
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Alphabet_Adapter(val context: Context, val list: List<AlphabetModel>) :
    RecyclerView.Adapter<Alphabet_Adapter.MyViewHolder>() {

    private val cardFlipOutAnimator = AnimatorInflater.loadAnimator(context, R.animator.card_flip_out)
    private val cardFlipInAnimator = AnimatorInflater.loadAnimator(context, R.animator.card_flip_in)
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.alphabet_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.imageView.setImageResource(data.img)

        if (data.flip) {
            holder.txtword.text = data.word
            holder.txtLetter.visibility = View.GONE
            holder.txtword.visibility = View.VISIBLE
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.txtLetter.text = data.letter
            holder.txtLetter.visibility = View.VISIBLE
            holder.imageView.visibility = View.GONE
            holder.txtword.visibility = View.GONE
        }

        holder.speak.setOnClickListener {
            if (data.flip) {
                mediaPlayer = MediaPlayer.create(context, data.audioWord)
                mediaPlayer?.start()
            } else {
                mediaPlayer = MediaPlayer.create(context, data.audioLetter)
                mediaPlayer?.start()
            }
        }

        holder.container.setOnClickListener {
            cardFlipOutAnimator.setTarget(holder.container)
            cardFlipOutAnimator.start()
            cardFlipInAnimator.setTarget(holder.container)
            cardFlipInAnimator.start()

            CoroutineScope(Dispatchers.Main).launch {
                delay(300)
                if (!data.flip) {
                    holder.txtword.text = data.word
                    holder.txtword.visibility = View.VISIBLE
                    holder.imageView.visibility = View.VISIBLE
                    holder.txtLetter.visibility = View.GONE
                } else {
                    holder.txtLetter.visibility = View.VISIBLE
                    holder.txtword.visibility = View.GONE
                    holder.imageView.visibility = View.GONE
                    holder.txtLetter.text = data.letter
                }
                data.flip = !data.flip
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtword = itemView.findViewById<TextView>(R.id.word)
        var txtLetter = itemView.findViewById<TextView>(R.id.letter)
        var speak = itemView.findViewById<ImageView>(R.id.speak)
        var imageView = itemView.findViewById<ImageView>(R.id.image)
        var container = itemView.findViewById<ConstraintLayout>(R.id.container)
    }
}