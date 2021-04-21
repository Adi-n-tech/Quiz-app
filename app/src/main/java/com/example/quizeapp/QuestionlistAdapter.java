package com.example.quizeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.Question;
import Models.Questionlistresponce;

public class QuestionlistAdapter extends RecyclerView.Adapter<QuestionlistAdapter.QuelistViewholder> {
    ArrayList<Question> questionArrayList ;
    Context context;

    public QuestionlistAdapter(ArrayList<Question> questionArrayList, Context context) {
        this.questionArrayList = questionArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuelistViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_questionlist,parent,false);
        return new QuelistViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuelistViewholder holder, int position) {

       Question mquestionlistresponces = questionArrayList.get(position);
        holder.tv_sr.setText(mquestionlistresponces.getSrNo().toString());
        holder.tv_que.setText(mquestionlistresponces.getQue());
        holder.tv_ans1.setText(mquestionlistresponces.getOptions().get(0).getOption().toString());
        holder.tv_ans2.setText(mquestionlistresponces.getOptions().get(1).getOption().toString());
        holder.tv_ans3.setText(mquestionlistresponces.getOptions().get(2).getOption().toString());
        holder.tv_ans4.setText(mquestionlistresponces.getOptions().get(3).getOption().toString());

    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }

    public class QuelistViewholder extends RecyclerView.ViewHolder {
        TextView tv_sr,tv_que,tv_ans1,tv_ans2,tv_ans3,tv_ans4;
        RadioButton tv_op2,tv_op3,tv_op4,tv_op1;

        public QuelistViewholder(@NonNull View itemView) {
            super(itemView);
            tv_sr = itemView.findViewById(R.id.srno);
            tv_que = itemView.findViewById(R.id.question);
            tv_ans1 = itemView.findViewById(R.id.ans1);
            tv_ans2 = itemView.findViewById(R.id.answer2);
            tv_ans3 = itemView.findViewById(R.id.answer3);
            tv_ans4 = itemView.findViewById(R.id.answer4);
            tv_op1 = itemView.findViewById(R.id.radio1);
            tv_op2 = itemView.findViewById(R.id.radio2);
            tv_op3 = itemView.findViewById(R.id.radio3);
            tv_op4 = itemView.findViewById(R.id.radio4);
        }
    }
}
