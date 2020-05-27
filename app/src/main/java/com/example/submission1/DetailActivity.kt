package com.example.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user =intent.getParcelableExtra(EXTRA_USER) as User

        mainName.text = user.name
        name.text = user.name
        username.text = user.username
        image.setImageResource(user.avatar)
        repository.text = user.repository
        follower.text = user.follower
        following.text = user.following
        company.text = user.company
        location.text = user.location

        initToolbar()
        initComponent()
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Detail User")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initComponent() {
        val image = findViewById(R.id.image) as CircleImageView
        val collapsing_toolbar = findViewById(R.id.collapsing) as CollapsingToolbarLayout
        app_bar_layout.addOnOffsetChangedListener(object :
            AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                val min_height = collapsing_toolbar.scrimVisibleHeightTrigger * 2 - 270
                val scale = (min_height + verticalOffset).toFloat() / min_height
                image.setScaleX(if (scale >= 0) scale else 0f)
                image.setScaleY(if (scale >= 0) scale else 0f)
            }
        })
    }

}
