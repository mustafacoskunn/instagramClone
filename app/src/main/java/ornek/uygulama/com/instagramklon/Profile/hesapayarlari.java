package ornek.uygulama.com.instagramklon.Profile;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Utils.BottomNavigationViewHelper;
import ornek.uygulama.com.instagramklon.Utils.ayarlarStatePagerAdapter;

public class hesapayarlari extends AppCompatActivity {

    private static final String TAG ="hesapayarlari" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_hesapayarlari);

        ImageView ımageView;
        ımageView=findViewById(R.id.geriImageview);
        ımageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ProfileActivtiy.class);
                startActivity(intent);
            }
        });
        viewPager=findViewById(R.id.container);//oluşturdugmuz container
        relativeLayout=findViewById(R.id.relative1);
        listviewFragmentKurulum();
        listviewDoldur();
    }
    private ayarlarStatePagerAdapter ayarlarStatePagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;
    private void listviewFragmentKurulum(){

        ayarlarStatePagerAdapter=new ayarlarStatePagerAdapter(getSupportFragmentManager());
        ayarlarStatePagerAdapter.fragmentEkle(new ProfilDuzenleFragment(),"Profili Düzenle"); //fragment 0
        ayarlarStatePagerAdapter.fragmentEkle(new CikisYapFragment(),"Cıkış Yap"); //fragment 1

    }
    private void setViewPager(int fragmentNumber){
        relativeLayout.setVisibility(View.GONE);
       

        viewPager.setAdapter(ayarlarStatePagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }
    private void listviewDoldur(){
        ListView listView;
        listView=findViewById(R.id.ayarListView);
        ArrayList<String> ayarlar=new ArrayList<>();
        ayarlar.add("Profili Düzenle"); //fragment 0
        ayarlar.add("Çıkış Yap"); //fragment 1
        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,ayarlar);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setViewPager(position);
            }
        });

    }




}
