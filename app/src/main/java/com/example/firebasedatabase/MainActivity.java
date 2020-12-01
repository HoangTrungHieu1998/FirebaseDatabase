package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lưu dữ liệu dạng chuỗi
//        myRef.child("Trung tâm").setValue("Khoa Pham").addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Lưu dữ liệu dạng object
//        Phuongtien phuongtien = new Phuongtien("xe đạp",2);
//        myRef.child("Phương tiện").setValue(phuongtien).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Lưu dữ liệu dạng hash map
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("Khu vực","Quận 4");
//        myRef.child("Địa điểm ").setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Lưu dữ liệu dạng danh sách
//        myRef
//                .child("Sinh viên")
//                .push()
//                .setValue(new Sinhvien("Trần Văn B",20))
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Đọc dữ liệu String
//        myRef.child("Trung tâm").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = (String) dataSnapshot.getValue();
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        // Đọc dữ liệu object
//         myRef.child("Phương tiện").addValueEventListener(new ValueEventListener() {
//             @Override
//             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                 Phuongtien phuongtien = dataSnapshot.getValue(Phuongtien.class);
//                 Toast.makeText(MainActivity.this, phuongtien.ten+","+phuongtien.sobanh, Toast.LENGTH_SHORT).show();
//             }
//
//             @Override
//             public void onCancelled(@NonNull DatabaseError databaseError) {
//
//             }
//         });

        // Đọc dữ liệu hash map
//        myRef.child("Địa điểm").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                HashMap<String, String> hashMap = (HashMap<String, String>) dataSnapshot.getValue();
//                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
//                    Log.d("BBB",dataSnapshot1.getKey());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        // Đọc dữ liệu dạng list
        myRef.child("Sinh viên").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Sinhvien sinhvien = dataSnapshot.getValue(Sinhvien.class);
//                HashMap<String, Integer> hashMap = (HashMap<String, Integer>) dataSnapshot.getValue();
                Log.d("BBB", sinhvien.ten +"/"+sinhvien.tuoi);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Sinhvien sinhvien = dataSnapshot.getValue(Sinhvien.class);
                Log.d("BBB", "Item change "+ sinhvien.ten +"/"+ sinhvien.tuoi);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}