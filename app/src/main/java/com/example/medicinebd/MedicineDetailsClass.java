package com.example.medicinebd;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MedicineDetailsClass extends AppCompatActivity {
    int postion,brand_id;
    DatabaseHelper myDbHelper;
    MedAdapter medAdapter;
    ArrayList<MedClass> medicinelistdata;
    TextView brandname,price,form,strenght,genname,uses,nonuses,prec,sideeffect,comapyname,packsize,y;
    Cursor d;
    String pr;
    int geneticid,brandid,companyid;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details_class);

        brandname=findViewById(R.id.mednameid);
          price=findViewById(R.id.priceid);
          packsize=findViewById(R.id.packsizeid);
          strenght=findViewById(R.id.strid);

       // strenght=findViewById(R.id.strenghtid);
        form=findViewById(R.id.formid);
       // prize=findViewById(R.id.prizeid);
        genname=findViewById(R.id.gennameid);
        uses=findViewById(R.id.useid);
        nonuses=findViewById(R.id.notuseid);
        prec=findViewById(R.id.preid);
        sideeffect=findViewById(R.id.sideeffctid);
        comapyname=findViewById(R.id.comnameid);


        medicinelistdata=new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            postion = bundle.getInt("position");
            brand_id=bundle.getInt("brand_id");

        }


        loadetails();
    }

    private void loadetails() {


        myDbHelper = new DatabaseHelper(MedicineDetailsClass.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

           Cursor c = myDbHelper.displaymedicinebybrandid(brand_id);



        if (c.getCount() == 0) {

            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_LONG).show();

        }    else {

            while (c.moveToNext())
            {

                brandid= c.getInt(0);
                geneticid= c.getInt(1);
                companyid= c.getInt(2);
                String brandname1 =c.getString(3);
                String form1 =c.getString(4);
                String strength1 =c.getString(5);
                 pr =c.getString(6);
                //String name =c.getString(1);
                brandname.setText(brandname1);
                form.setText(form1);
                comapyname.setText(c.getString(9));
                packsize.setText(c.getString(7));
                price.setText(c.getString(6));
                strenght.setText(strength1);

               // strenght.setText(strength1);
              //  prize.setText(pr);

                // MedClass medclass= new MedClass(brandid,geneticid,companyid,brandname,form,strength,packsize);
                //medicinelistdata.add(medclass);

            }


        }


   brandname.setText(medicinelistdata.get(postion).getBrandname());




        // hoscata.setText(amblistdata.get(i).getSepcialty());
        gendetails();
    }
    private void gendetails(){


        myDbHelper = new DatabaseHelper(MedicineDetailsClass.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

     d = myDbHelper.displaymedicinebygenid(geneticid);



        if (d.getCount() == 0) {

            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_LONG).show();

        }    else {

            while (d.moveToNext())
            {

                geneticid= d.getInt(0);
 String gname=d.getString(1);
                genname.setText(gname);


               genname.setText(d.getString(1));
               uses.setText(d.getString(5));
                nonuses.setText(d.getString(7));
                prec.setText(d.getString(3));
                sideeffect.setText(d.getString(11));




            }


        }


    }
}

