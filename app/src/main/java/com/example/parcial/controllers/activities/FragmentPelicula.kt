package com.example.parcial.controllers.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.R
import com.example.parcial.adapter.PeliculaAdapter
import com.example.parcial.models.ApiResponse
import com.example.parcial.models.Pelicula
import com.example.parcial.network.PeliculaService
import kotlinx.android.synthetic.main.fragment_pelicula.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentPelicula : Fragment(), PeliculaAdapter.OnItemClickListener {

    var pelicula: List<Pelicula> = ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pelicula, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvPeliculas)
        btSearch.setOnClickListener{
            loadPeliculas(view.context)
        }
    }

    private fun loadPeliculas(context: Context) {
        val query = etquery.text.toString()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PeliculaService::class.java)
        val request = service.getPeliculas("3cae426b920b29ed2fb1c0749f258325", query)
        request.enqueue(object  : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("Fail", "error: "+ t.toString())
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    Log.d("Fail3", response.code().toString())
                    val peliculas : List<Pelicula> = response.body()!!.results ?: ArrayList()
                    recyclerView.layoutManager  = LinearLayoutManager(context)
                    recyclerView.adapter = PeliculaAdapter(peliculas, context, this@FragmentPelicula)
                }
                else{
                    Log.d("Fail2", response.code().toString())
                }
            }

        })
    }

    override fun onItemClicked(pelicula: Pelicula) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
