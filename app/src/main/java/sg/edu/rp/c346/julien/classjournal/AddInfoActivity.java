package sg.edu.rp.c346.julien.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AddInfoActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rdGrade;
    TextView tvWeek;
    String choice = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

         btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        rdGrade = (RadioGroup) findViewById(R.id.radioGrades);
        tvWeek = (TextView) findViewById(R.id.weekNumber);



//        int radioButtonID = rdGrade.getCheckedRadioButtonId();
//        View radioButton = rdGrade.findViewById(radioButtonID);
//        int idx = rdGrade.indexOfChild(radioButton);
//        int selectedId = rdGrade.getCheckedRadioButtonId();




        Intent i = getIntent();
        int wkNum = i.getIntExtra("currWk",0) + 1;

        tvWeek.setText("Week " + (wkNum));


        rdGrade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selected = radioGroup.getCheckedRadioButtonId();
                Log.d("TAG",  String.valueOf(selected));

                switch(selected){
                    case 2131231018:
                        choice = "A";
                        break;
                    case 2131231019:
                        choice = "B";
                        break;
                    case 2131231020:
                        choice = "C";
                        break;
                    case 2131231021:
                        choice = "D";
                        break;
                    case 2131231022:
                        choice = "F";
                        break;
                    case 2131231023:
                        choice = "X";
                        break;

                }
                //2131231018 A
                //2131231019 B
                //2131231020 C
                //2131231021 D
                //2131231022 F
                //2131231023 X


            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Intent a = new Intent();

                a.putExtra("gradeSelected", choice );
                a.putExtra("newWkNum", wkNum );
                setResult(RESULT_OK, a);
                finish();
            }
        });
    }
}
