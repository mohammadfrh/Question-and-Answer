package com.frh.questionanswer.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.frh.questionanswer.Data.QuestionApi;
import com.frh.questionanswer.Model.QuestionModel;

import java.util.ArrayList;

public class QuestionViewModel extends ViewModel {
    MutableLiveData<ArrayList<QuestionModel>> questionModel = new MutableLiveData<>();
    QuestionApi questionApi = new QuestionApi();

    public MutableLiveData<ArrayList<QuestionModel>> getQuestionModel() {
        return questionModel;
    }

    public void callQuestionApi(QuestionViewModel questionViewModel) {
        questionApi.QuestionApi(questionViewModel);
    }
}
