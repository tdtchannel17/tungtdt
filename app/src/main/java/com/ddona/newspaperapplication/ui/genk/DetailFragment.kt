package com.ddona.newspaperapplication.ui.genk

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ddona.newspaperapplication.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import org.jsoup.Jsoup
import java.lang.StringBuilder

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val data = arguments?.getString("data")
        if (data != null) {
            getDatas(data)
        }

        return binding.root
    }

    private fun getDatas(link: String) {
        var content = ""
        var title = ""
        var introduce = ""
        var linkImage = ""
        val stringBuilder = StringBuilder()
        val asyn = object : AsyncTask<String, Void, String>() {
            override fun doInBackground(vararg params: String?): String {
                val linkCrawl = params!![0]
                val doc = Jsoup.connect(linkCrawl).get()
                title = doc.select("div.w710").first().select("div.kbwc-header").first().select("h1").text().toString()
                introduce = doc.select("div.w710").first().select("h2").text().toString()
                linkImage = doc.select("div.w710").first().select("img").attr("src").toString()
                for (d in doc.select("div.w710").first().select("div.knc-content").select("p")) {
                    stringBuilder.append("\n").append(d.text()).append("\n")
                    content = stringBuilder.toString()
                }

                return content
            }

            override fun onPostExecute(result: String) {
                binding.tvDetailTitle.setText(title)
                binding.tvDetailIntroduce.setText(introduce)
                binding.tvDetailContent.setText(result)
                Glide.with(iv_link.context)
                    .load(linkImage)
                    .into(iv_link)
            }
        }
        asyn.execute(link)
    }
}