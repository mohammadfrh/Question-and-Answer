package com.frh.questionanswer.Data;

import com.frh.questionanswer.Model.QuestionModel;
import com.frh.questionanswer.ViewModel.QuestionViewModel;
import java.util.ArrayList;

public class QuestionApi {
    ArrayList<QuestionModel> questionModel = new ArrayList<>();

    public void QuestionApi(QuestionViewModel questionViewModel) {
        for (int i = 0; i < 4; i++) {

            QuestionModel model = new QuestionModel();
            model.setTitleQuestion(DataQuestions.titleQuestionArray[i]);
            model.setDescriptionQuestion(DataQuestions.descriptionQuestionArray[i]);
            model.setIdQuestion(DataQuestions.idQuestionArray[i]);
            questionModel.add(model);
        }
        questionViewModel.getQuestionModel().postValue(questionModel);
    }

}
