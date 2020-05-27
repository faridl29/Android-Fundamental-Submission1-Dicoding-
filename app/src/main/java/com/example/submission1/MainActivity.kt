package com.example.submission1

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        initData();
        addData()

    }

    private fun initData(){
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addData(){
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataPhoto.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )
            users.add(user)
        }

        adapter = UserAdapter(this,users)
        recycler_view.adapter = adapter
    }

}
