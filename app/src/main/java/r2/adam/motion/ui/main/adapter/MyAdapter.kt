package r2.adam.motion.ui.main.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import r2.adam.motion.R
import r2.adam.motion.model.CustomModel


class MyAdapter(
    private val listener: Listener
) : ListAdapter<CustomModel, MyAdapter.MyVH>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        return MyVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_fields, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val item = getItem(position) ?: return

        holder.itemView.setOnClickListener {
            listener.onSelectLesson(item)
        }
    }

    class MyVH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer

    interface Listener {
        fun onSelectLesson(data: CustomModel)
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CustomModel>() {

    override fun areItemsTheSame(oldItem: CustomModel, newItem: CustomModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CustomModel, newItem: CustomModel): Boolean {
        return oldItem == newItem
    }
}