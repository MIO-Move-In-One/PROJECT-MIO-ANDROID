package com.gdsc.mio.tabaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gdsc.mio.adapter.ReviewTabAdapter
import com.gdsc.mio.databinding.ActivityAccountReviewBinding
import com.google.android.material.tabs.TabLayoutMediator

class AccountReviewActivity : AppCompatActivity() {

    private lateinit var arBinding : ActivityAccountReviewBinding
    private var type : String? = null
    private var userId = 0

    private val tabTextList = listOf("받은 후기", "작성 가능한 후기", "작성한 후기")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arBinding = ActivityAccountReviewBinding.inflate(layoutInflater)
        setContentView(arBinding.root)


        type = intent.getStringExtra("type")

        if (type.equals("REVIEW")) {
            userId = intent.getIntExtra("userId", -1)
        }

        arBinding.backArrow.setOnClickListener {
            this@AccountReviewActivity.finish()
        }

        arBinding.accountReviewViewpager.adapter = ReviewTabAdapter(this)

        TabLayoutMediator(arBinding.accountReviewTabLayout, arBinding.accountReviewViewpager) { tab, pos ->
            tab.text = tabTextList[pos]
        }.attach()

    }
}