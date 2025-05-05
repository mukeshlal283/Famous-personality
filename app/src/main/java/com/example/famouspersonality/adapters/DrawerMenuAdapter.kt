package com.example.famouspersonality.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.famouspersonality.R
import com.example.famouspersonality.models.ChildMenu
import com.example.famouspersonality.models.DrawerMenuItem

class DrawerMenuAdapter(private val items: MutableList<Any>, val changeFragment: (Fragment, String?) -> Unit)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_PARENT = 0
        private const val TYPE_CHILD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is DrawerMenuItem) TYPE_PARENT else TYPE_CHILD
    }

// class DrawerMenuViewHolder(val binding: DrawerMenuItemBinding)
//      : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return if(viewType == TYPE_PARENT) {
            val view = inflater.inflate(R.layout.drawer_menu_item, parent, false)
            ParentViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.drawer_menu_sub_item, parent, false)
            ChildViewHolder(view)
        }

//        return DrawerMenuViewHolder(DrawerMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ParentViewHolder) {
            val item = items[position] as DrawerMenuItem
            holder.bind(item)

            holder.itemView.setOnClickListener {

                if(item.isExpandable) {
                    item.isExpanded = !item.isExpanded
                    notifyItemChanged(position)

                    if (item.isExpanded) {
                        expandItem(position, item)
                    } else {
                        collapseItem(position, item)
                    }
                } else {
                    changeFragment(item.fragment!!, item.fCode)
                    val c = items[3] as DrawerMenuItem
                    if (c.isExpanded) {
                        collapseItem(3, c)
                        c.isExpanded = !c.isExpanded
                        notifyItemChanged(3)
                    }
                }


            }

        } else if (holder is ChildViewHolder) {
            val subItem = items[position] as ChildMenu
            holder.itemView.setOnClickListener {
                changeFragment(subItem.fragment!!, subItem.fCode)
                val c = items[3] as DrawerMenuItem
                if (c.isExpanded) {
                    collapseItem(3, c)
                    c.isExpanded = !c.isExpanded
                    notifyItemChanged(3)
                }


            }
            holder.bind(subItem)
        }


//        val data = list[position]
//
//        holder.binding.menuTitle.setText(data.title)
//        if (data.showIcon) {
//            holder.binding.icon.visibility = View.VISIBLE
//        }
//        holder.itemView.setOnClickListener {
//            if (data.showIcon) {
//
//            }
//        }
    }

    private fun collapseItem(position: Int, item: DrawerMenuItem) {
        items.subList(position + 1, position + 1 + item.subItems.size).clear()
        notifyItemRangeRemoved(position + 1, item.subItems.size)
    }

    private fun expandItem(position: Int, item: DrawerMenuItem) {
        items.addAll(position + 1, item.subItems)
        notifyItemRangeInserted(position + 1, item.subItems.size)
    }

    class ChildViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(subItem: ChildMenu) {
            itemView.findViewById<TextView>(R.id.menuSubTitle).text = subItem.title
        }

    }

    class ParentViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val tvTitle = itemView?.findViewById<TextView>(R.id.menuTitle)
        private val ivArrow = itemView?.findViewById<ImageView>(R.id.icon)

        fun bind(item: DrawerMenuItem) {
            tvTitle?.text = item.title
            ivArrow?.visibility = if (item.isExpandable) View.VISIBLE else View.GONE
            ivArrow?.rotation = if (item.isExpanded) 180f else 0f
        }

    }



}

