package com.example.codinground

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codinground.adapter.UserAdapter
import com.example.codinground.api.RetrofitClient
import com.example.codinground.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        recycler = findViewById(R.id.recycler)

        setSupportActionBar(toolbar)

        recycler.layoutManager =
            LinearLayoutManager(this)

        loadUsers()
    }


    private fun loadUsers() {

        RetrofitClient.instance.getUsers()
            .enqueue(object : Callback<UserResponse> {

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {

                    if (response.isSuccessful) {

                        val list =
                            response.body()!!.users

                        recycler.adapter =
                            UserAdapter(
                                list,
                                this@MainActivity
                            )
                    }
                }

                override fun onFailure(
                    call: Call<UserResponse>,
                    t: Throwable
                ) {

                    t.printStackTrace()
                }
            })
    }


    // menu show
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(
            R.menu.menu_main,
            menu
        )

        return true
    }


    // logout
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logout) {

            startActivity(
                Intent(
                    this,
                    Loginpage::class.java
                )
            )

            finish()
        }

        return true
    }
}