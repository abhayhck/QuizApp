package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mainQues: TextView? = null
    private var img: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var txtProgressBar: TextView? = null
    private var opt1: TextView? = null
    private var opt2: TextView? = null
    private var opt3: TextView? = null
    private var opt4: TextView? = null
    private var btnSubmit: Button? = null
    private val questionList = Constants.getQuestions()

    private var currentSelectedOpt: TextView? = null
    private var currentQuestion: Int = 0
    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        mainQues = findViewById(R.id.mainQues)
        img = findViewById(R.id.imgId)
        progressBar = findViewById(R.id.progressBar)
        txtProgressBar = findViewById(R.id.txtProgress)
        opt1 = findViewById(R.id.opt1)
        opt2 = findViewById(R.id.opt2)
        opt3 = findViewById(R.id.opt3)
        opt4 = findViewById(R.id.opt4)
        btnSubmit = findViewById(R.id.btnSubmit)

        opt1?.setOnClickListener(this)
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)



        setQuestion(currentQuestion)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(questionNumber: Int) {
        defaultOptionView()
        mainQues?.text = questionList[questionNumber].question
        img?.setImageResource(questionList[questionNumber].image)
        progressBar?.progress = questionNumber + 1
        txtProgressBar?.text = "${questionNumber + 1}/${progressBar?.max}"
        opt1?.text = questionList[questionNumber].option1
        opt2?.text = questionList[questionNumber].option2
        opt3?.text = questionList[questionNumber].option3
        opt4?.text = questionList[questionNumber].option4
    }

    private fun defaultOptionView() {
        var options: ArrayList<TextView> = ArrayList()
        opt1?.let { options.add(it) }
        opt2?.let { options.add(it) }
        opt3?.let { options.add(it) }
        opt4?.let { options.add(it) }

        for (opt in options) {
            opt.setTextColor(ContextCompat.getColor(this, R.color.purple))
            opt.typeface = Typeface.DEFAULT
            opt.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }

    }


    private fun selectedOptionView(opt: TextView?) {
        defaultOptionView()
        opt?.let {
            it.setTextColor(ContextCompat.getColor(this, R.color.orange))
            it.typeface = Typeface.DEFAULT_BOLD
            it.background = ContextCompat.getDrawable(
                this, R.drawable.selected_option_border_bg
            )
            when (it) {
                opt1 -> {
                    currentSelectedOpt = opt1
                }

                opt2 -> {
                    currentSelectedOpt = opt2
                }

                opt3 -> {
                    currentSelectedOpt = opt3
                }

                opt4 -> {
                    currentSelectedOpt = opt4
                }

            }
        }
    }

    private fun correctOptionView(opt: TextView) {
        defaultOptionView()
        opt?.let {
            it.setTextColor(ContextCompat.getColor(this, R.color.black))
            it.typeface = Typeface.DEFAULT_BOLD
            it.background = ContextCompat.getDrawable(
                this, R.drawable.correct_option_border_bg
            )
        }
    }

    private fun wrongOptionView(opt: TextView, correct: Int) {
        defaultOptionView()
        var correctOpt: TextView? = getOptionTextView(correct)


        opt?.let {
            it.setTextColor(ContextCompat.getColor(this, R.color.black))
            it.typeface = Typeface.DEFAULT_BOLD
            it.background = ContextCompat.getDrawable(
                this, R.drawable.wrong_option_border_bg
            )
        }
        correctOpt?.let {
            it.setTextColor(ContextCompat.getColor(this, R.color.black))
            it.typeface = Typeface.DEFAULT_BOLD
            it.background = ContextCompat.getDrawable(
                this, R.drawable.correct_option_border_bg
            )
        }
    }


    override fun onClick(view: View?) {
        when (view) {
            opt1, opt2, opt3, opt4 -> {
                selectedOptionView(view as TextView)
            }

            btnSubmit -> {
                if(btnSubmit?.text == "NEXT")
                {
                    currentQuestion++
                    currentSelectedOpt = null
                    if (currentQuestion < questionList.size) {
                        setQuestion(currentQuestion)
                    } else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("Result", result)
                        intent.putExtra("max",questionList.size)
                        startActivity(intent)
                        TODO("make a finish activity" )
                    }
                    btnSubmit?.let { it.text="SUBMIT" }
                }
                else
                {
                    Log.i("Inside Button", "Button")
                    currentSelectedOpt?.let { selectedOpt ->
                        Log.i("Inside CurrentSelected", "Inside")
                        val correct = questionList[currentQuestion].correctOption
                        if (selectedOpt == getOptionTextView(correct)) {
                            correctOptionView(selectedOpt)
                            result++
                        } else {
                            wrongOptionView(selectedOpt, correct)
                        }
                        if(currentQuestion>=questionList.size)
                            btnSubmit?.let { it.text = "FINISH" }
                        else
                            btnSubmit?.let { it.text = "NEXT" }
                    }
                }
            }
        }
    }


    private fun getOptionTextView(optionNumber: Int): TextView? {
        return when (optionNumber) {
            1 -> opt1
            2 -> opt2
            3 -> opt3
            4 -> opt4
            else -> opt1 // Default fallback
        }
    }
}