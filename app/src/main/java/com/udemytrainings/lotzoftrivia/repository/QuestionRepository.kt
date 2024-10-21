package com.udemytrainings.lotzoftrivia.repository

import android.util.Log
import com.udemytrainings.lotzoftrivia.data.DataOrException
import com.udemytrainings.lotzoftrivia.model.QuestionItem
import com.udemytrainings.lotzoftrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("TAG", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}