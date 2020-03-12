package com.gp.healthqrgenerator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gp.healthqrgenerator.R;
import com.gp.healthqrgenerator.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] que = new String[]{"Have you recently traveled to an area with known local spread of COVID-19?",
            "Have you come into close contact (within 6 feet) with someone who has a laboratory confirmed COVID – 19 diagnosis in the past 14 days?",
            "Do you have a fever (greater than 100.4 F or 38.0 C) more then 1 day",
            "Do you have symptoms of lower respiratory illness such as cough, shortness of breath",
            "Do you have difficulty in breathing?"};
    private RecyclerView recyclerView;
    List<Question> questionList;
    private EditText etName, etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);

        createQuetions();

        findViewById(R.id.btn_generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etName.getText())) {
                    etName.setError("Enter your Name");
                    return;
                }

                if (TextUtils.isEmpty(etId.getText())) {
                    etId.setError("Enter your ID");
                    return;
                }

                int mark = 0;
                int total = 0;

                for (int i = 0; i < questionList.size(); i++) {
                    total = total + questionList.get(i).getPoins();
                    if (questionList.get(i).isAnswer()) {
                        mark = mark + questionList.get(i).getPoins();
                    }
                }
                Intent i = new Intent(getApplicationContext(), QrCreateActivity.class);
                i.putExtra("total", total);
                i.putExtra("mark", mark);
                i.putExtra("name", etName.getText().toString());
                i.putExtra("id", etId.getText().toString());
                startActivity(i);
            }
        });
    }

    private void createQuetions() {

        questionList = new ArrayList<>();

        // points means weight of symtns Max 5 and means 0
        // Color qr code generate using this point. If you add more questions then you need to changes in calculation for generate color qr code

        questionList.add(new Question(que[0], false, 5));
        questionList.add(new Question(que[1], false, 5));
        questionList.add(new Question(que[2], false, 1));
        questionList.add(new Question(que[3], false, 1));
        questionList.add(new Question(que[4], false, 4));
        QuestionAdapter questionAdapter = new QuestionAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {

        /*public QuestionAdapter(Context context){

        }*/

        @NonNull
        @Override
        public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.row_question, parent, false);
            return new QuestionHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final QuestionHolder holder, final int position) {
            holder.txtQue.setText("Q. " + questionList.get(position).getQue());
            if (questionList.get(position).isAnswer()) {
                holder.rbGroup.check(R.id.rb_true);
            } else {
                holder.rbGroup.check(R.id.rb_false);
            }
            holder.rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.rb_true:
                            questionList.get(position).setAnswer(true);
                            break;
                        case R.id.rb_false:
                            questionList.get(position).setAnswer(false);
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return questionList.size();
        }

        public class QuestionHolder extends RecyclerView.ViewHolder {

            private TextView txtQue;
            private RadioGroup rbGroup;

            public QuestionHolder(@NonNull View itemView) {
                super(itemView);
                txtQue = itemView.findViewById(R.id.txt_row_question);
                rbGroup = itemView.findViewById(R.id.rb_group);
            }
        }
    }
}
