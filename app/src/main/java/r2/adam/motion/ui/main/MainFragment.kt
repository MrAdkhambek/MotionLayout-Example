package r2.adam.motion.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import r2.adam.motion.R
import r2.adam.motion.model.CustomModel
import r2.adam.motion.ui.main.adapter.MyAdapter

class MainFragment : Fragment(), MyAdapter.Listener {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var myAdapter: MyAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.screen_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        myAdapter = MyAdapter(this)

        setupRecycler()
        viewModel.customLiveData.observe(viewLifecycleOwner, Observer(myAdapter::submitList))
    }


    private fun setupRecycler() = with(recyclerView) {
        layoutManager = LinearLayoutManager(context)
        adapter = myAdapter
    }

    override fun onSelectLesson(data: CustomModel) {

    }

}