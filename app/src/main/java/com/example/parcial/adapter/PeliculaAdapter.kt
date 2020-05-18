package com.example.parcial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.R
import com.example.parcial.models.Pelicula

class PeliculaAdapter(private val peliculas : List<Pelicula>, private val context: Context, private val itemClickListener: OnItemClickListener)
    : RecyclerView.Adapter<PeliculaAdapter.ViewHolder>(){

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById(R.id.tvTitle) as TextView
        val tvOverview= view.findViewById(R.id.tvOverview) as TextView
        val cvPeliculas = view.findViewById(R.id.cvPeliculas) as CardView
    }
    interface OnItemClickListener {
        fun onItemClicked(pelicula: Pelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_pelicula,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.tvTitle.text = pelicula.title
        holder.tvOverview.text = pelicula.overview
        holder.cvPeliculas.setOnClickListener {
            itemClickListener.onItemClicked(pelicula)
        }
    }
}