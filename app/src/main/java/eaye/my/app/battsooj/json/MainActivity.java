package eaye.my.app.battsooj.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        String students_array = "{\"students\": [\n" +
                "  {\"id\":\"1\",\"name\":\"abcd\",\"email\":\"abcd@gmail.com\"},\n" +
                "  {\"id\":\"2\",\"name\":\"efgh\",\"email\":\"efgh@gmail.com\"},\n" +
                "  {\"id\":\"3\",\"name\":\"ijkl\",\"email\":\"ijkl@gmail.com\"},\n" +
                "  {\"id\":\"4\",\"name\":\"mnop\",\"email\":\"mnop@gmail.com\"},\n" +
                "  {\"id\":\"5\",\"name\":\"qrst\",\"email\":\"qrst@gmail.com\"},\n" +
                "  {\"id\":\"6\",\"name\":\"uvwx\",\"email\":\"uvwx@gmail.com\"},\n" +
                "  {\"id\":\"7\",\"name\":\"yz\",\"email\":\"yz@gmail.com\"}]\n" +
                "}";

        try {
            JSONObject jsonObject = new JSONObject(students_array);
            JSONArray jsonArray = jsonObject.getJSONArray("students");
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String studentID = object.getString("id");
                String studentName = object.getString("name");
                String studentEmail = object.getString("email");
                arrayList.add(studentID +") " + studentName + " || " + studentEmail);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext()
                        ,arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}