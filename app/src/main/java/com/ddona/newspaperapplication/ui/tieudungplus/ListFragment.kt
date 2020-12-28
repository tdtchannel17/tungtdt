package com.ddona.newspaperapplication.ui.tieudungplus

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.newspaperapplication.adapter.NewspaperAdapter
import com.ddona.newspaperapplication.databinding.FragmentListBinding
import com.ddona.newspaperapplication.model.ItemData
import com.ddona.newspaperapplication.ui.genk.GenkFragment
import org.jsoup.Jsoup

class ListFragment : Fragment(), NewspaperAdapter.INewAdapter {
    private lateinit var binding: FragmentListBinding
    private val itemNews = mutableListOf<ItemData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.rc.layoutManager = LinearLayoutManager(context)
        binding.rc.adapter = NewspaperAdapter(this)
        getDatas(requireArguments().getString("LINK")!!)
        return binding.root
    }

    private fun getDatas(link: String) {
        val asyn = object : AsyncTask<String, Void, MutableList<ItemData>>() {
            override fun doInBackground(vararg params: String?): MutableList<ItemData> {
                val linkCrawl = params!![0]
                val items = mutableListOf<ItemData>()
                val doc = Jsoup.connect(linkCrawl).get()
                for (d in doc.select("div.feed").first().select("div.top-post")) {
                    val title = d.select("a").first().attr("title")
                    val linkImage = d.select("a").first().select("img").attr("src")
                    val link = d.select("a").first().attr("href")
                    items.add(
                        ItemData(linkImage, title, "", "https://tieudungplus.vn/" + link)
                    )
                }

                return items
            }

            override fun onPostExecute(result: MutableList<ItemData>) {
                itemNews.clear()
                itemNews.addAll(result)
                binding.rc.adapter!!.notifyDataSetChanged()
            }
        }
        asyn.execute(link)
    }

    override fun onClickDetail(position: Int) {
        (parentFragment as TieuDungFragment).openDetailTieuDungPlus(itemNews[position].linkDetail)
    }

    override fun getCount() = itemNews.size

    override fun getData(position: Int) = itemNews[position]
}