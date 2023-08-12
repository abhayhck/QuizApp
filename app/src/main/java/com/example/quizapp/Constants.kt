package com.example.quizapp

object Constants {
     fun getQuestions():ArrayList<Question>
     {
         val questionList:ArrayList<Question> = ArrayList()

         val que1=Question(
             1,
             "Which country flag is this?",
             R.drawable.india,
             "Bharat",
             "Japan",
             "Malaysia",
             "Bhutan",
             1
         )
         val que2=Question(
             2,
             "Which country flag is this?",
             R.drawable.indonesia,
             "Bharat",
             "Indonesia",
             "China",
             "Bhutan",
             2
         )
         val que3=Question(
             3,
             "Which country flag is this?",
             R.drawable.iran,
             "Saudi Arabia",
             "Kuwait",
             "Malaysia",
             "Iran",
             4
         )
         val que4=Question(
             4,
             "Which country flag is this?",
             R.drawable.japan,
             "South Korea",
             "Japan",
             "North Korea",
             "New Zealand",
             2
         )
         val que5=Question(
             5,
             "Which country flag is this?",
             R.drawable.niger,
             "Africa",
             "Somalia",
             "Burkina Faso",
             "Niger",
             4
         )
         val que6=Question(
         6,
         "Which country flag is this?",
         R.drawable.syria,
         "Afghanistan",
         "Syria",
         "Malaysia",
         "Iran",
         2
     )
         questionList.add(que1)
         questionList.add(que2)
         questionList.add(que3)
         questionList.add(que4)
         questionList.add(que5)
         questionList.add(que6)

    return questionList
     }
}