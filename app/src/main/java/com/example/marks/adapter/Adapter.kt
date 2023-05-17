package com.example.marks.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marks.Data.Entity.Students
import com.example.marks.databinding.StudentListBinding

class Adapter(val list: List<Students>,val itemClick:OnClickItem):RecyclerView.Adapter<Adapter.My_Holder>() {
    class My_Holder(val binding:StudentListBinding):RecyclerView.ViewHolder(binding.root){
        val text = binding.nameandclass
        val item = binding.item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): My_Holder {
        return My_Holder(StudentListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: My_Holder, position: Int) {
        holder.text.text = "${list[position].clas} -> ${list[position].name}"
        holder.item.setOnClickListener{itemClick.onClickitem()}
    }

    interface OnClickItem{
        fun onClickitem()
    }
}