package com.example.ejemplolistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView

class AdaptadorCustom(var context: Context, items: ArrayList<Fruta>): BaseAdapter() {

    var items:ArrayList<Fruta>? = null

    init {
        this.items = items
    }
    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var holder:ViewHolder? = null
        var vista:View? = convertView

        if (vista == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.template,null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)

        return vista!!
    }

    private class ViewHolder(Vista:View){
        var nombre:TextView? = null
        var imagen:ImageView? = null

        init {
            this.nombre = Vista.findViewById(R.id.nombre)
            this.imagen = Vista.findViewById(R.id.imagen)
        }
    }
}