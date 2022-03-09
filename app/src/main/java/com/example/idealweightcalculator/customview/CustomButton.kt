package com.example.idealweightcalculator.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.idealweightcalculator.R

class CustomButton(context: Context, attributeSet: AttributeSet): ConstraintLayout(context, attributeSet) {

    private val tvCalculate: TextView
    private val progressBar: ProgressBar
    private val constraintLayout: ConstraintLayout
    private var onClickAction: ()->Unit = {}

    var text: String = ""
    set(value){
        field = value
        tvCalculate.text = value
        invalidate()
    }

    var loading: Boolean = false
    set(value){
        field = value
        if(value == false){
            progressBar.visibility = View.GONE
        } else{
            progressBar.visibility = View.VISIBLE
        }
        invalidate()
    }


    fun onClick(action: ()->Unit){
        onClickAction = action
    }

    init {
        inflate(context, R.layout.custom_button, this)

        tvCalculate = findViewById(R.id.tx_calculate)
        progressBar = findViewById(R.id.progress_bar)
        constraintLayout = findViewById(R.id.customLayout)

        attributeSet?.let {
            val attribute = context.theme.obtainStyledAttributes(attributeSet, R.styleable.ButtonWithLoadingBar,0,0)

            try{
                text = attribute.getString(R.styleable.ButtonWithLoadingBar_infoTitle) ?: ""
                loading = attribute.getBoolean(R.styleable.ButtonWithLoadingBar_infoVisibility,false)

            } finally {
                attribute.recycle()
            }
        }
    constraintLayout.setOnClickListener {
        onClickAction.invoke()
    }


    }
}