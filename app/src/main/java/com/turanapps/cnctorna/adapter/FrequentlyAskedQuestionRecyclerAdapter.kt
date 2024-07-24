package com.turanapps.cnctorna.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.turanapps.cnctorna.databinding.FrequentlyAskedQuestionRecyclerRowBinding
import com.turanapps.cnctorna.model.institutional.FAQ

class FrequentlyAskedQuestionRecyclerAdapter(private var faqList: ArrayList<FAQ>) : RecyclerView.Adapter<FrequentlyAskedQuestionRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: FrequentlyAskedQuestionRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FrequentlyAskedQuestionRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            faqList[position].apply {

                questionTextView.text = faqList[position].faqQuestion
                answerTextView.text = faqList[position].faqAnswer

                expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }

            }
        }

    }


}