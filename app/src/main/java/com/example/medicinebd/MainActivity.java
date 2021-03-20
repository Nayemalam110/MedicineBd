package com.example.medicinebd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.database.SQLException;
import java.io.IOException;
//import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView medicinelistview;
    DatabaseHelper myDbHelper;
     MedAdapter medAdapter;
    private SearchView searchView;
     ArrayList<MedClass> medicinelistdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); medicinelistview=findViewById(R.id.medicinelistview);
        medicinelistdata=new ArrayList<>();

         loadmedicine();
    }

    private void loadmedicine() {

         myDbHelper = new DatabaseHelper(MainActivity.this);
         try {
             myDbHelper.createDataBase();
        } catch (IOException ioe) {
             throw new Error("Unable to create database");
         }
         try {
             myDbHelper.openDataBase();
        }
         catch (SQLException sqle) {
             throw sqle;
         }

        Cursor c = myDbHelper.displayallemedicine();
       if (c.getCount()==0)
         {

             Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_LONG).show();

        }
       else {

             while (c.moveToNext())
              {

                int brandid= c.getInt(0);
                 int geneticid= c.getInt(1);
                 int companyid= c.getInt(2);
                 String brandname =c.getString(3);
                 String form =c.getString(4);
                 String strength =c.getString(5);
                 String price=c.getString(6);
                 String packsize =c.getString(7);

                String genname =c.getString(8);
                String comname=c.getString(9);


                MedClass medclass= new MedClass(brandid,geneticid,companyid,brandname,form,strength,price,packsize,genname,comname);
                medicinelistdata.add(medclass);

             }


         }

         medAdapter = new MedAdapter(this,medicinelistdata);
         medicinelistview.setAdapter(medAdapter);
        //adapter =new ArrayAdapter<String>(SpinnerClass.this,R.layout.list_item,R.id.listitemid,listData);
     /*    medicinelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 int brand_id = medicinelistdata.get(i).getBrandid();
                //Toast.makeText(getApplicationContext(),"Brandid"+brand_id,Toast.LENGTH_LONG).show();
                 Intent intent = new Intent(MedAct.this,MedicineDetailsClass.class);
                 intent.putExtra("position",i);
                 intent.putExtra("brand_id",brand_id);
                 startActivity(intent);

             }
        });*/


    }
    public boolean onCreateOptionsMenu(Menu menu) {

         MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
         MenuItem menuItem = menu.findItem(R.id.secVid);
          searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
             public boolean onQueryTextSubmit(String s) {
                return false;
             }

            @Override
             public boolean onQueryTextChange(String s) {
                 medAdapter.getFilter().filter(s);
                 return false;


             }
         });
         return super.onCreateOptionsMenu(menu);
     }
}