package com.turanapps.cnctorna.view.fragments.institutional

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.adapter.FrequentlyAskedQuestionRecyclerAdapter
import com.turanapps.cnctorna.adapter.ServiceRecyclerAdapter
import com.turanapps.cnctorna.databinding.FragmentFrequentlyAskedQuestionsBinding
import com.turanapps.cnctorna.model.institutional.FAQ

class FrequentlyAskedQuestionsFragment : Fragment() {

    private var _binding: FragmentFrequentlyAskedQuestionsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FrequentlyAskedQuestionRecyclerAdapter

    private lateinit var faqArrayList: ArrayList<FAQ>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        faqArrayList = arrayListOf(
            FAQ(faqQuestion = getString(R.string.firstQuestion), faqAnswer = getString(R.string.firstAnswer), expand = false),
            FAQ(faqQuestion = getString(R.string.secondQuestion), faqAnswer = getString(R.string.secondAnswer), expand = false),
            FAQ(faqQuestion = getString(R.string.thirdQuestion), faqAnswer = getString(R.string.thirdAnswer), expand = false),
            FAQ(faqQuestion = getString(R.string.fourthQuestion), faqAnswer = getString(R.string.fourthAnswer), expand = false),
            FAQ(faqQuestion = getString(R.string.fifthQuestion), faqAnswer = getString(R.string.fifthAnswer), expand = false),
            FAQ(faqQuestion = getString(R.string.sixthQuestion), faqAnswer = getString(R.string.sixthAnswer), expand = false)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFrequentlyAskedQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FrequentlyAskedQuestionRecyclerAdapter(faqArrayList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)

        adapter.notifyDataSetChanged()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}