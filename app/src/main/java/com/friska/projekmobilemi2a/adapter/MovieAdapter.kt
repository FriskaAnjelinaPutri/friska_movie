package com.friska.projekmobilemi2a.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.friska.projekmobilemi2a.DetailMovie
import com.friska.projekmobilemi2a.MovieActivity
import com.friska.projekmobilemi2a.R
import com.friska.projekmobilemi2a.model.ModelMovie

class MovieAdapter(
    private val getActivity: MovieActivity, // parameter untuk item recycle bisa di klik
    private val movieList: List<ModelMovie>
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardMovie: CardView = itemView.findViewById(R.id.cardMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(nView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = movieList[position].nama
        holder.imgMovie.setImageResource(movieList[position].image)

        // Agar bisa di klik
        holder.cardMovie.setOnClickListener {
            Toast.makeText(getActivity, movieList[position].nama, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(getActivity, DetailMovie::class.java) // Ganti DetailBuah menjadi DetailMovie
            intent.putExtra("image", movieList[position].image)
            intent.putExtra("nama", movieList[position].nama)
            getActivity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
