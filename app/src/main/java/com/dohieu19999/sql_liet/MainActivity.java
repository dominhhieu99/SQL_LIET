package com.dohieu19999.sql_liet;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewND;
    ArrayList<BaiHoc> arrayList;
    BaiHocAdapter adapter;
    BaiHocHelper baiHocHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listViewND = findViewById(R.id.listViewND);
        arrayList = new ArrayList<>();
        adapter = new BaiHocAdapter(this, R.layout.item_noidung_baihoc, arrayList);
        listViewND.setAdapter(adapter);


//   Tạo DATABASE
        baiHocHelper = new BaiHocHelper(this, "BaiHoc.sqlite", null, 1);
//        Tạo bảng
        baiHocHelper.QueryData("CREATE TABLE IF NOT EXISTS NoiDung(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNoiDung VARCHAR(200))");
//        Thêm dữ liệu
//        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES(null,'Bài 1: Giới thiệu về Android')");
//        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES(null,'Bài 2: Cài đặt môi trường lập trình Android')");

//        Hiện thị dữ liệu
        Cursor dataBaiHoc = baiHocHelper.GetData("SELECT * FROM NoiDung");
        while (dataBaiHoc.moveToNext()) {

            int id = dataBaiHoc.getInt(0);
            String ten = dataBaiHoc.getString(1);
            arrayList.add(new BaiHoc(id, ten));
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
}
