package com.example.duan1_android;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1_android.Adapter.AdapterThemSanPham;
import com.example.duan1_android.DTO.SanPham;
import com.example.duan1_android.DTO.SanPhamThem;
import com.example.duan1_android.Fragment.OderFragment;
import com.example.duan1_android.SelectAll.SelectAllOrder;
import com.google.android.gms.common.server.converter.StringToIntConverter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ThemSanPham extends AppCompatActivity implements AdapterThemSanPham.Listionner{
    private EditText edtAddTenSP;
    private EditText edtAddGiaSP;
    private Spinner spinnerLoai;
    private ImageView imageChonAnh;
    private ImageView imageChupAnh;
    private RecyclerView recyclerviewAnhSP;
    private AppCompatButton btnAddSP;
    private AppCompatButton btnHuySP;
    private int index;
    private List<SanPhamThem> listSPT;
    private AdapterThemSanPham adapterThemSanPham;
    private OderFragment oderFragment;
    private FragmentContainerView fragmentContainerViewb1;
    private SelectAllOrder selectAllOrder;
    private int idTherLoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham);
        edtAddTenSP = (EditText) findViewById(R.id.edtAddTenSP);
        edtAddGiaSP = (EditText) findViewById(R.id.edtAddGiaSP);
        spinnerLoai = (Spinner) findViewById(R.id.spinnerLoai);
        imageChonAnh = (ImageView) findViewById(R.id.imageChonAnh);
        imageChupAnh = (ImageView) findViewById(R.id.imageChupAnh);
        recyclerviewAnhSP = (RecyclerView) findViewById(R.id.recyclerviewAnhSP);
        btnAddSP = (AppCompatButton) findViewById(R.id.btnAddSP);
        btnHuySP = (AppCompatButton) findViewById(R.id.btnHuySP);
        selectAllOrder = new SelectAllOrder(this);
        intspinner();
        listSPT = new ArrayList<>();
        adapterThemSanPham = new AdapterThemSanPham(this, this);

        imageChonAnh.setOnClickListener(v->{
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} ,2);
        });

        imageChupAnh.setOnClickListener(v->{
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.CAMERA} ,1);
        });

        recyclerviewAnhSP.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        btnHuySP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThemSanPham.this, "Bạn không thêm sản phẩm mới", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        btnAddSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidate()>0){
                    SanPhamThem sanPhamThem = new SanPhamThem();
                    sanPhamThem.setTenSanPham(edtAddTenSP.getText().toString());
                    sanPhamThem.setGiaSanPham(Integer.parseInt(edtAddGiaSP.getText().toString()));
                    sanPhamThem.setMaTheLoai(idTherLoai);

                    if (idTherLoai==1){

                    }
                    listSPT.add(sanPhamThem);
                    selectAllOrder.insertSP(listSPT);

                    Toast.makeText(ThemSanPham.this, "Sản phẩm thêm thành công", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                }
            }
        });



    }

    private static int convertByteArrayToInt(byte[] bytes)
    {
        return (bytes[0] << 32) | (bytes[1] << 24) | (bytes[2] << 16) | (bytes[3] <<8) | bytes[4];
    }
    public int checkValidate(){
        int check = 1;
        if (edtAddGiaSP.getText().toString().length()==0 || edtAddTenSP.getText().toString().length()==0){
            Toast.makeText(getBaseContext(),"Bạn phải nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void ShowData(){
        adapterThemSanPham.setData(listSPT);
        recyclerviewAnhSP.setAdapter(adapterThemSanPham);
    }
    @Override
    public void onCLickdelect(View view, int position) {
        listSPT.remove(position);
        ShowData();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        ShowData();
    }
    ActivityResultLauncher<Intent> onCreate = registerForActivityResult(new ActivityResultContracts.StartActivityForResult() , rs->{
        if(rs.getResultCode() == Activity.RESULT_OK){
            Intent intent = rs.getData();
            if(index == 1){
                ClipData clipData = intent.getClipData();
                for(int i=0; i<clipData.getItemCount() ; i++){
                    ClipData.Item item = clipData.getItemAt(i);
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), item.getUri());
                        ByteArrayOutputStream output =new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG , 100 , output );
                        bitmap.recycle();
                        SanPhamThem sanPhamThem = new SanPhamThem();
                        sanPhamThem.setAnhSanPham(output.toByteArray());
                        listSPT.add(sanPhamThem);
                    }catch (Exception e){

                    }
                }
            }else {
                Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
                ByteArrayOutputStream output =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG , 100 , output );
                bitmap.recycle();
                SanPhamThem sanPhamThem = new SanPhamThem();
                sanPhamThem.setAnhSanPham(output.toByteArray());
                listSPT.add(sanPhamThem);
            }
        }
    });

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    index = 2;
                    onCreate.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                }else{
                    Toast.makeText(this, "Bạn không cho phép truy cập mục chụp ảnh", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    index =1;
                    Intent inte =new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    inte.putExtra(Intent.EXTRA_ALLOW_MULTIPLE , true );
                    onCreate.launch(inte);
                }else{
                    Toast.makeText(this, "Bạn không cho phép truy cập thư mục ảnh", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void intspinner(){
        ArrayAdapter<String> adapte = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , selectAllOrder.getLsitTheLoai());
        spinnerLoai.setAdapter(adapte);
        spinnerLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idTherLoai = selectAllOrder.getIdTheLoai(spinnerLoai.getSelectedItem().toString()) +1;
                Toast.makeText(ThemSanPham.this, "id là " +idTherLoai, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}