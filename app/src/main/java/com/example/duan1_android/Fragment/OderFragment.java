package com.example.duan1_android.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.Adapter.AdapterThemSanPham;
import com.example.duan1_android.Adapter.RecyclerAdapterHoaDon;
import com.example.duan1_android.Adapter.RecyclerOderAdapter;
import com.example.duan1_android.CustomView.CustomViewGridOder;
import com.example.duan1_android.DTO.GioHang;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.DTO.ItemGridOder;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.DTO.SanPhamBanhOder;
import com.example.duan1_android.DTO.SanPhamCoffeOder;
import com.example.duan1_android.DTO.SanPhamDaXayOder;
import com.example.duan1_android.DTO.SanPhamTraSuaOder;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;
import com.example.duan1_android.SuaSanPham;
import com.example.duan1_android.ThemSanPham;
import com.example.duan1_android.XoaSanPham;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OderFragment extends Fragment {
    private TextView btnClear;

    private Context context;
    private GridView gridView;
    public RecyclerView recyclerViewOderCoffe;
    private List<ItemGridOder> listItemGrid = new ArrayList<>();
    private ArrayList<SanPhamCoffeOder> list;
    private RecyclerOderAdapter recyclerOderAdapter;
    private SelectAllOrder selectAllCoffeeOrder;
    private Toolbar myToolbar;
    CustomViewGridOder customViewGridOder;
    Bitmap cafe, traTraiCay, daXay;
    public  static ArrayList<GioHang> manggiohang;
    private TextInputEditText edSearchSP;




    private KhachHang khachHang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.oder_fragment,container,false);
       gridView = (GridView)view.findViewById(R.id.myGridViewOder);
       customViewGridOder = new CustomViewGridOder(getContext(),R.layout.row_img_oder, (ArrayList<ItemGridOder>) listItemGrid);
        gridView.setAdapter(customViewGridOder);
        btnClear = (TextView) view.findViewById(R.id.btnClear);

        recyclerViewOderCoffe = view.findViewById(R.id.recyclerOderCoffe);
        selectAllCoffeeOrder = new SelectAllOrder(context);
        list = new ArrayList<>();
        recyclerOderAdapter = new RecyclerOderAdapter(context, list);
        list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.getListSP();
        recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerOderAdapter.setData(list);
        recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    list.clear();
                    recyclerOderAdapter = new RecyclerOderAdapter(context, list);
                    list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.SP1();
                    recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    recyclerOderAdapter.setData(list);
                    recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
                    Toast.makeText(getContext(), "Bạn đã chọn các sản phẩm Coffee", Toast.LENGTH_SHORT).show();
                    return;
                }else if (position == 1){
                    list.clear();
                    recyclerOderAdapter = new RecyclerOderAdapter(context, list);
                    list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.SP2();
                    recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    recyclerOderAdapter.setData(list);
                    recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
                    Toast.makeText(getContext(), "Bạn đã chọn các sản phẩm Trà trái cây", Toast.LENGTH_SHORT).show();
                    return;

                }else if (position == 2){
                    list.clear();
                    recyclerOderAdapter = new RecyclerOderAdapter(context, list);
                    list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.SP3();
                    recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    recyclerOderAdapter.setData(list);
                    recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
                    Toast.makeText(getContext(), "Bạn đã chọn các sản phẩm Đá xay và Bánh ngọt", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edSearchSP.setText("");
                list = new ArrayList<>();
                recyclerOderAdapter = new RecyclerOderAdapter(context, list);
                list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.getListSP();
                recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                recyclerOderAdapter.setData(list);
                recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
                Toast.makeText(getContext(), "Danh sách toàn bộ sản phẩm", Toast.LENGTH_SHORT).show();
            }
        });

         khachHang = (KhachHang) this.getActivity().getIntent().getSerializableExtra("khachhang");

        myToolbar = (Toolbar) view.findViewById(R.id.myToolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.like:
                    if(khachHang.isCheckAdmin() == 0){
                        Toast.makeText(getActivity(), "Bạn không phải là ADMIN", Toast.LENGTH_SHORT).show();
                        return false;
                    }else if(khachHang.isCheckAdmin() == 1){
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.Theme_Design_BottomSheetDialog);
                        View bottomSheetView = LayoutInflater.from(getActivity()).inflate(
                                R.layout.bottom_sheet,
                                (LinearLayout) bottomSheetDialog.findViewById(R.id.bottomSheetContainer));
                         TextView txtThemSP = (TextView) bottomSheetView.findViewById(R.id.txt_ThemSP);
                         TextView txtSuaSP = (TextView) bottomSheetView.findViewById(R.id.txt_SuaSP);
                         TextView txtXoaSP = (TextView) bottomSheetView.findViewById(R.id.txt_XoaSP);
                         TextView txtHuy = (TextView) bottomSheetView.findViewById(R.id.txt_Huy);

                         txtThemSP.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 Intent intent = new Intent(getActivity(), ThemSanPham.class);
                                 startActivity(intent);
                                 bottomSheetDialog.dismiss();
                             }
                         });

                         txtSuaSP.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 Intent intent = new Intent(getActivity(), SuaSanPham.class);
                                 startActivity(intent);
                                 bottomSheetDialog.dismiss();
                             }
                         });

                         txtXoaSP.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 Intent intent = new Intent(getActivity(), XoaSanPham.class);
                                 startActivity(intent);
                                 bottomSheetDialog.dismiss();
                             }
                         });

                         txtHuy.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 bottomSheetDialog.dismiss();
                             }
                         });

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();

                    }
                    break;
                }
                return false;
            }
        });

        edSearchSP = (TextInputEditText) view.findViewById(R.id.edSearchSP);
        edSearchSP.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    list.clear();
                    recyclerOderAdapter = new RecyclerOderAdapter(context, list);
                    list = (ArrayList<SanPhamCoffeOder>) selectAllCoffeeOrder.sreachSP(edSearchSP.getText().toString());
                    recyclerViewOderCoffe.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    recyclerOderAdapter.setData(list);
                    recyclerViewOderCoffe.setAdapter(recyclerOderAdapter);
                return false;
            }
        });
        return view;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cafe = BitmapFactory.decodeResource(this.getResources(),R.drawable.loaicaphe);
        traTraiCay = BitmapFactory.decodeResource(this.getResources(),R.drawable.loaitra);
        daXay = BitmapFactory.decodeResource(this.getResources(),R.drawable.loaidaxay);



        listItemGrid.add(new ItemGridOder(cafe,"Coffee"));
        listItemGrid.add(new ItemGridOder(traTraiCay,"Trà trái cây"));
        listItemGrid.add(new ItemGridOder(daXay,"Đồ thêm"));

        if (manggiohang!= null){

        }else{
            manggiohang = new ArrayList<>();
        }
    }



}
