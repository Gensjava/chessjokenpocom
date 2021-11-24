package com.example.gena.chessjokenpocom.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import java.util.*

class ListOfGamersAdapter() : RecyclerView.Adapter<ListOfGamersAdapter.BindingHolder>() {

    private var holderLayout = 0
    private var variableId: Int = 0
    private var items: List<UsersPersonalInformation> = ArrayList<UsersPersonalInformation>()
    private var onItemClickListener: OnItemClickListener? = null
    private var context: Context? = null

    constructor(
        holderLayout: Int,
        variableId: Int,
        context: Context?
    ) : this() {
        this.holderLayout = holderLayout
        this.variableId = variableId
        this.context = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListOfGamersAdapter.BindingHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(holderLayout, parent, false)
        return BindingHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val item: UsersPersonalInformation = items[position]

        val textViewName = holder.binding!!.root.findViewById<TextView>(R.id.name)
        textViewName.text = item.firstName + " " + item.secondName

        val textViewAddress = holder.binding.root.findViewById<TextView>(R.id.address)
        textViewAddress.text = " Canada "

        holder.binding.root
            .setOnClickListener { v: View? ->
                if (onItemClickListener != null) onItemClickListener!!.onItemClick(item)
            }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(item: UsersPersonalInformation?)
    }

    class BindingHolder internal constructor(v: View?) : RecyclerView.ViewHolder(v!!) {
        val binding: ViewDataBinding?

        init {
            binding = DataBindingUtil.bind(v!!)
        }
    }

    fun setItems(items: List<UsersPersonalInformation>?) {
        if (items != null) {
            this.items = items
        }
    }
}