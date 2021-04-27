package sg.edu.rp.c346.julien.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleInfoActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCA> dca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");

        lv = (ListView) this.findViewById(R.id.listViewModule);

        dca = new ArrayList<DailyCA>();
        dca.add(new DailyCA("B", 1));
        dca.add(new DailyCA("C", 2));
        dca.add(new DailyCA("A", 3));

        aa = new DailyAdapter(this, R.layout.row, dca);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DailyCA selected = dca.get(position);
                Toast.makeText(ModuleInfoActivity.this, selected.getWeek() + ", " + selected.getDgGrade(), Toast.LENGTH_LONG).show();
            }
        });



    }
}
