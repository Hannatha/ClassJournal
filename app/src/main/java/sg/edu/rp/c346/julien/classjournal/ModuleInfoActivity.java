package sg.edu.rp.c346.julien.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleInfoActivity extends AppCompatActivity {

    ListView lv;
    DailyAdapter aa;
    ArrayList<DailyCA> dca;
    Button info, btnAdd;
    Button email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_info);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");

        lv = (ListView) this.findViewById(R.id.lvDaily);
        info = findViewById(R.id.btnInfo);
        email=findViewById(R.id.btnEmail);
        btnAdd = (Button) findViewById(R.id.btnAddWeek);
        dca = new ArrayList<DailyCA>();
        dca.add(new DailyCA("B", 1));
        dca.add(new DailyCA("C", 2));
        dca.add(new DailyCA("A", 3));

        aa = new DailyAdapter(this, R.layout.row, dca);
        lv.setAdapter(aa);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/diploma-in-digital-design-and-development"));
                startActivity(rpIntent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //The action you want intent to do;
                //ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject& bodytext
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jason_lim@rp.edu.sg"});

                String text = "";
                text = "Hi faci, \n" +"I am your student \n" +"Please see my remarks so far, thank you! \n ";
                for(int i =0;i<dca.size();i++){

                    text += "Week " + dca.get(i).getWeek() + ": DG: " +dca.get(i).getDgGrade() + "\n";
                    email.putExtra(Intent.EXTRA_TEXT, text);
                }

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ModuleInfoActivity.this, AddInfoActivity.class);
                int weekNumber = dca.size();
                i.putExtra("currWk", weekNumber);
                startActivity(i);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("TAG", String.valueOf(resultCode));
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){

            if (data != null) {
                int newWeek = data.getIntExtra("newWkNum",0);
                String newGrade = data.getStringExtra("gradeSelected");
                dca.add(new DailyCA(newGrade, newWeek));
                notifyAll();



            }
        }
    }
}
