package com.frh.questionanswer.View;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.frh.questionanswer.Data.DataQuestions;
import com.frh.questionanswer.Model.QuestionModel;
import com.frh.questionanswer.R;

import java.util.ArrayList;


public class ExpandableTestAdapter extends ExpandableRecyclerView.Adapter<ExpandableTestAdapter.ChildViewHolder, ExpandableRecyclerView.SimpleGroupViewHolder, String, String> implements ExpandableRecyclerView.OnGroupItemClickedListener, ExpandableRecyclerView.OnChildItemClickedListener {

    private ArrayList<QuestionModel> questionModels;

    @Override
    public int getGroupItemCount() {
        if (questionModels != null)
            return questionModels.size() - 1;
        else return 0;
    }

    @Override
    public int getChildItemCount(int group) {
        return 1;
    }

    @Override
    public String getGroupItem(int position) {
        return "group :" + position;
    }

    @Override
    public String getChildItem(int group, int position) {
        return DataQuestions.titleQuestionArray[group];
    }

    @Override
    protected ExpandableRecyclerView.SimpleGroupViewHolder onCreateGroupViewHolder(ViewGroup parent) {
        return new ExpandableRecyclerView.SimpleGroupViewHolder(parent.getContext());
    }

    @Override
    protected ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_row_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public int getChildItemViewType(int group, int position) {
        return 1;
    }

    @Override
    public void onBindGroupViewHolder(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        super.onBindGroupViewHolder(holder, group);
        setGroupdata(holder, group);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int group, final int position) {
        super.onBindChildViewHolder(holder, group, position);
        onChildItemClicked(group, position);
        setRowdata(holder, group);
    }

    private void setRowdata(ChildViewHolder holder, int group) {
        holder.textviewDescription.setText(questionModels.get(group).getDescriptionQuestion());
    }


    private void setGroupdata(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        holder.setTextViewGroupText(questionModels.get(group).getTitleQuestion());
    }

    public void setDataQuestion(ArrayList<QuestionModel> questionModels) {
        this.questionModels = questionModels;
        notifyDataSetChanged();
    }

    @Override
    public void onGroupItemClicked(int group) {
        Log.e("Tag", "onGroupItemClicked: " + group);
    }

    @Override
    public void onChildItemClicked(int group, int position) {

    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        private final TextView textviewDescription;

        public ChildViewHolder(View itemView) {
            super(itemView);
            textviewDescription = itemView.findViewById(R.id.textView_description);
        }
    }

}