package com.example.firstproject.irregularverb.videoEndWithT

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.irregularverb.videoEndWithT.Util.Companion.mediaPlayer
import com.example.firstproject.irregularverb.videoEndWithT.Util.Companion.speak
import com.example.firstproject.irregularverb.videoEndWithT.Util.Companion.textToSpeech

class VideoEndWithTAdapter(val context: Context, val list: List<VerbsModel>) :
    RecyclerView.Adapter<VideoEndWithTAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.videoendwitht_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.first_form.text = data.firstform
        holder.sec_form.text = data.secform
        holder.thr_form.text = data.thirdform
        holder.verb_image.setImageResource(data.image)

        if (data.usesList.size == 0){
            holder.more.visibility = View.INVISIBLE
        }else{
            holder.more.visibility = View.VISIBLE
        }

        holder.more.setOnClickListener {
            val intent = Intent(context,VerbMore::class.java)
            intent.putExtra("msj",data.usesList[1])
            context.startActivity(intent)
        }

        holder.first_form.setOnClickListener {
            var f=MyApplication.lisnten
            if (!f){
                holder.sentence.visibility = View.INVISIBLE
                speak(context,data.firstform,data.firstformaudio)
            }
            else{
                holder.sentence.visibility = View.VISIBLE
                holder.sentence.text = data.sentrnce1form
                speak(context,data.firstform,data.sentrnce1formaudio)
                mediaPlayer?.setOnCompletionListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
                textToSpeech?.setOnUtteranceCompletedListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
            }
        }

        holder.sec_form.setOnClickListener {
            var f=MyApplication.lisnten
            if (!f){
                holder.sentence.visibility = View.INVISIBLE
                speak(context,data.secform,data.secformaudio)
            }
            else{
                holder.sentence.visibility = View.VISIBLE
                holder.sentence.text = data.sentrnce2form
                speak(context,data.secform,data.sentrnce2formaudio)
                mediaPlayer?.setOnCompletionListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
                textToSpeech?.setOnUtteranceCompletedListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
            }
        }

        holder.thr_form.setOnClickListener {
            var f=MyApplication.lisnten
            if (!f){
                holder.sentence.visibility = View.INVISIBLE
                speak(context,data.thirdform,data.thirdformaudio)
            }
            else{
                holder.sentence.visibility = View.VISIBLE
                holder.sentence.text = data.sentrnce3form
                speak(context,data.thirdform,data.sentrnce3formaudio)
                mediaPlayer?.setOnCompletionListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
                textToSpeech?.setOnUtteranceCompletedListener {
                    holder.sentence.visibility = View.INVISIBLE
                }
            }
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val first_form = itemView.findViewById<TextView>(R.id.first_form)
        val sec_form = itemView.findViewById<TextView>(R.id.sec_form)
        val thr_form = itemView.findViewById<TextView>(R.id.thr_form)
        val sentence = itemView.findViewById<TextView>(R.id.sentence)
        val verb_image = itemView.findViewById<ImageView>(R.id.verb_image)
        val more = itemView.findViewById<TextView>(R.id.more)

    }
}