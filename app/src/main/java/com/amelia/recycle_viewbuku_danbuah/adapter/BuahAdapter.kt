package com.amelia.recycle_viewbuku_danbuah.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amelia.recycle_viewbuku_danbuah.DetailBuah
import com.amelia.recycle_viewbuku_danbuah.R
import com.amelia.recycle_viewbuku_danbuah.RecycleBuahActivity
import com.amelia.recycle_viewbuku_danbuah.model.ModelBuah


 class BuahAdapter (
    val itemList: ArrayList<ModelBuah>,
    val getActivity: RecycleBuahActivity
):


    RecyclerView.Adapter<BuahAdapter.MyViewHolder>()
{
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        //deklarasi widget dari layout item
        var itemImage : ImageView
        var itemNama : TextView

        init {
            itemImage = itemView.findViewById(R.id.gambar) as ImageView
            itemNama = itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahAdapter.MyViewHolder {
        //manggil layout
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycle_images, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BuahAdapter.MyViewHolder, position: Int) {
        //set data ke widget
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemNama.setText(itemList[position].nama)

        holder.itemView.setOnClickListener(){
            val intent = Intent(getActivity, DetailBuah::class.java)

            intent.putExtra("image", itemList[position].image)
            intent.putExtra("nama", itemList[position].nama)
            intent.putExtra("lokasi", itemList[position].lokasi)
            intent.putExtra("deskripsi", itemList[position].deskripsi .toString())

            getActivity.startActivity(intent)
        }
    }


}
