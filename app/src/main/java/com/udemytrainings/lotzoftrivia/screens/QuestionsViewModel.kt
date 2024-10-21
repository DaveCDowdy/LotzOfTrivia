package com.udemytrainings.lotzoftrivia.screens


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemytrainings.lotzoftrivia.data.DataOrException
import com.udemytrainings.lotzoftrivia.model.QuestionItem
import com.udemytrainings.lotzoftrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception>> = mutableStateOf(
              DataOrException(null, true, Exception("")))

    init{ getAllQuestions() }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }

    fun getTotalQuestions(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}