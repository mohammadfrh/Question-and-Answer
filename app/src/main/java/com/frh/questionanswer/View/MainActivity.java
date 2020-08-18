package com.frh.questionanswer.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.frh.questionanswer.Model.QuestionModel;
import com.frh.questionanswer.R;
import com.frh.questionanswer.View.ExpandableRecyclerView;
import com.frh.questionanswer.View.ExpandableTestAdapter;
import com.frh.questionanswer.ViewModel.QuestionViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ExpandableRecyclerView recyclerView;
    ExpandableTestAdapter expandableAdapter;
    QuestionViewModel questionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        questionViewModel.callQuestionApi(questionViewModel);

        questionViewModel.getQuestionModel().observe(this, new Observer<ArrayList<QuestionModel>>() {
            @Override
            public void onChanged(ArrayList<QuestionModel> transactionModels) {
                expandableAdapter.setDataQuestion(transactionModels);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        expandableAdapter = new ExpandableTestAdapter();
        recyclerView.setAdapter(expandableAdapter);
    }
}
