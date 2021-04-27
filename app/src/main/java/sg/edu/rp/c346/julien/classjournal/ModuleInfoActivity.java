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
    DailyAdapter aa;
    ArrayList<DailyCA> dca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_info);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");

        lv = (ListView) this.findViewById(R.id.lvDaily);

        dca = new ArrayList<DailyCA>();
        dca.add(new DailyCA("B", 1));
        dca.add(new DailyCA("C", 2));
        dca.add(new DailyCA("A", 3));

        aa = new DailyAdapter(this, R.layout.row, dca);
        lv.setAdapter(aa);






    }
}
