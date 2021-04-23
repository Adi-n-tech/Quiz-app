package com.example.quizeapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    int result;
   MainActivity mMainActivity;

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

        int Result;

       Question mquestionlistresponces = questionArrayList.get(position);
        holder.tv_sr.setText(mquestionlistresponces.getSrNo().toString());
        holder.tv_que.setText(mquestionlistresponces.getQue());
        holder.tv_op1.setText(mquestionlistresponces.getOptions().get(0).getOption().toString());
        holder.tv_op2.setText(mquestionlistresponces.getOptions().get(1).getOption().toString());
        holder.tv_op3.setText(mquestionlistresponces.getOptions().get(2).getOption().toString());
        holder.tv_op4.setText(mquestionlistresponces.getOptions().get(3).getOption().toString());
        holder.tv_op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_op2.setEnabled(false);
                holder.tv_op3.setEnabled(false);
                holder.tv_op4.setEnabled(false);

               // right
                if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(0).getId())){
                    holder.linearLayout1.setBackgroundResource(R.drawable.optionbg);
                    holder.imageone.setVisibility(View.VISIBLE);
                    result =+ 10;


                }else {
                    //w rong highlight
                    holder.linearLayout1.setBackgroundResource(R.drawable.optionbgred);
                    holder.imagered1.setVisibility(View.VISIBLE);


                    //highlight correct
                   if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(1).getId())){
                        holder.linearLayout2.setBackgroundResource(R.drawable.optionbg);
                        holder.imagetwo.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(2).getId())){
                        holder.linearLayout3.setBackgroundResource(R.drawable.optionbg);
                        holder.imagethree.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(3).getId())){
                        holder.linearLayout4.setBackgroundResource(R.drawable.optionbg);
                        holder.imagefour.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        holder.tv_op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_op1.setEnabled(false);
                holder.tv_op3.setEnabled(false);
                holder.tv_op4.setEnabled(false);


                // right
                if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(1).getId())){
                    holder.linearLayout2.setBackgroundResource(R.drawable.optionbg);
                    holder.imagetwo.setVisibility(View.VISIBLE);
                    result =+ 10;


                }else {
                    //w rong highlight
                    holder.linearLayout2.setBackgroundResource(R.drawable.optionbgred);
                    holder.imagered2.setVisibility(View.VISIBLE);


                    //highlight correct
                    if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(3).getId())){
                        holder.linearLayout4.setBackgroundResource(R.drawable.optionbg);
                        holder.imagefour.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(2).getId())){
                        holder.linearLayout3.setBackgroundResource(R.drawable.optionbg);
                        holder.imagethree.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(0).getId())){
                        holder.linearLayout1.setBackgroundResource(R.drawable.optionbg);
                        holder.imageone.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        holder.tv_op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_op2.setEnabled(false);
                holder.tv_op1.setEnabled(false);
                holder.tv_op4.setEnabled(false);

                // right
                if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(2).getId())){
                    holder.linearLayout3.setBackgroundResource(R.drawable.optionbg);
                    holder.imagethree.setVisibility(View.VISIBLE);
                    result =+ 10;

                }else {
                    //w rong highlight
                    holder.linearLayout3.setBackgroundResource(R.drawable.optionbgred);
                    holder.imagered3.setVisibility(View.VISIBLE);


                    //highlight correct
                    if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(1).getId())){
                        holder.linearLayout2.setBackgroundResource(R.drawable.optionbg);
                        holder.imagetwo.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(2).getId())){
                        holder.linearLayout3.setBackgroundResource(R.drawable.optionbg);
                        holder.imagethree.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(3).getId())){
                        holder.linearLayout4.setBackgroundResource(R.drawable.optionbg);
                        holder.imagefour.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        holder.tv_op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_op2.setEnabled(false);
                holder.tv_op3.setEnabled(false);
                holder.tv_op1.setEnabled(false);

                // right
                if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(3).getId())){
                    holder.linearLayout4.setBackgroundResource(R.drawable.optionbg);
                    holder.imagefour.setVisibility(View.VISIBLE);
                    result =+ 10;
                }else {
                    //w rong highlight
                    holder.linearLayout4.setBackgroundResource(R.drawable.optionbgred);
                    holder.imagefour.setVisibility(View.VISIBLE);

                    //highlight correct
                    if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(1).getId())){
                        holder.linearLayout2.setBackgroundResource(R.drawable.optionbg);
                        holder.imagetwo.setVisibility(View.VISIBLE);

                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(2).getId())){
                        holder.linearLayout3.setBackgroundResource(R.drawable.optionbg);
                        holder.imagethree.setVisibility(View.VISIBLE);
                    }
                    else  if (mquestionlistresponces.getCorrectAnsID().equalsIgnoreCase(mquestionlistresponces.getOptions().get(0).getId())){
                        holder.linearLayout1.setBackgroundResource(R.drawable.optionbg);
                        holder.imageone.setVisibility(View.VISIBLE);
                    }


                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }

    public class QuelistViewholder extends RecyclerView.ViewHolder {
        TextView tv_sr,tv_que,tv_op1,tv_op2,tv_op3,tv_op4;
        ImageView imageone,imagetwo,imagethree,imagefour,imagered1,imagered2,imagered3,imagered4;
        LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;


        public QuelistViewholder(@NonNull View itemView) {
            super(itemView);
            tv_sr = itemView.findViewById(R.id.srno);

            tv_que = itemView.findViewById(R.id.question);
            tv_op1 = itemView.findViewById(R.id.radio1);
            tv_op2 = itemView.findViewById(R.id.radio2);
            tv_op3 = itemView.findViewById(R.id.radio3);
            tv_op4 = itemView.findViewById(R.id.radio4);
            imageone = itemView.findViewById(R.id.image1);
            imagetwo = itemView.findViewById(R.id.image2);
            imagethree = itemView.findViewById(R.id.image3);
            imagefour = itemView.findViewById(R.id.image4);
            linearLayout1 = itemView.findViewById(R.id.options1);
            linearLayout2 = itemView.findViewById(R.id.options2);
            linearLayout3 = itemView.findViewById(R.id.options3);
            linearLayout4 = itemView.findViewById(R.id.options4);
            imagered1 = itemView.findViewById(R.id.red1);
            imagered2 = itemView.findViewById(R.id.red2);
            imagered3 = itemView.findViewById(R.id.red3);
            imagefour = itemView.findViewById(R.id.red4);




        }
    }
}
