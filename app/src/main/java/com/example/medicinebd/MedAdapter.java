package com.example.medicinebd;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MedAdapter extends BaseAdapter {



    private int[] img = {R.drawable.medicine4};
      private  ValueFilter mFilter;

        int fo;
        Context context;
        ArrayList<MedClass> arrayList;
        ArrayList<MedClass> filterdata;

    public MedAdapter(Context context, ArrayList<MedClass>arrayList){

        this.context=context;
        this.arrayList=arrayList;
        this.filterdata=arrayList;


    }
        @Override
        public int getCount() {
        return arrayList.size();
    }

        @Override
        public Object getItem(int i) {
        return arrayList.get(i);
    }

        @Override
        public long getItemId(int i) {
        return i;
    }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.medlist,null);
        TextView tid=view.findViewById(R.id.nameid);
        TextView tform=view.findViewById(R.id.formid);
            TextView tgen=view.findViewById(R.id.genid);
            TextView tsize=view.findViewById(R.id.sizeid);
        ImageView imageView=view.findViewById(R.id.imgid);
        MedClass hosClass = arrayList.get(i);
        fo=i;
        tid.setText(hosClass.getBrandname());
        tform.setText(hosClass.getForm());
        tsize.setText(hosClass.getStrength());
            tgen.setText(hosClass.getComname());
            imageView.setImageResource(img[0]);
        view.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String fox = arrayList.get(i).brandname;
              int genetic = arrayList.get(i).brandid;
              String fo = arrayList.get(i).form;

             // Toast.makeText(context.getApplicationContext(),"Name:=="+fox+" Brand id:=="+genetic+" Form=="+fo,Toast.LENGTH_LONG).show();
              Intent intent = new Intent(context.getApplicationContext(),MedicineDetailsClass.class);
              intent.putExtra("position",i);
              intent.putExtra("brand_id",genetic);
              context.startActivity(intent);

          }
      });
        return view;
    }

    public Filter getFilter(){


        if(mFilter == null)
        {
            mFilter=new ValueFilter();
        }

        return mFilter;
    }

        private class ValueFilter extends Filter {


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint != null && constraint.length() > 0) {
                    ArrayList<MedClass> filterList = new ArrayList<MedClass>();
                    for (int i = 0; i < filterdata.size(); i++) {
                        if ((filterdata.get(i).getBrandname().toUpperCase())
                                .contains(constraint.toString().toUpperCase())) {
                            MedClass babydata = new MedClass(filterdata.get(i)
                                    .getBrandid(), filterdata.get(i).getGeneticid(),filterdata.get(i)
                                    .getCompanyid(),filterdata.get(i)
                                    .getBrandname(),filterdata.get(i)
                                    .getForm(),filterdata.get(i)
                                    .getStrength(),filterdata.get(i)
                                    .getPrice(),filterdata.get(i).getPakesize(),
                                    filterdata.get(i)
                                            .getGenname(),
                                    filterdata.get(i).getComname());
                            filterList.add(babydata);
                        }
                    }
                    results.count = filterList.size();
                    results.values = filterList;
                } else {
                    results.count = filterdata.size();
                    results.values = filterdata;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                //Toast.makeText(context.getApplicationContext(),"publishResults",Toast.LENGTH_LONG).show();
                 arrayList = (ArrayList<MedClass>) results.values;


                notifyDataSetChanged();
            }
        }
}

