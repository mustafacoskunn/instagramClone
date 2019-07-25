package ornek.uygulama.com.instagramklon.Profile;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Utils.BottomNavigationViewHelper;
import ornek.uygulama.com.instagramklon.Utils.GridImageAdapter;
import ornek.uygulama.com.instagramklon.Utils.UniversalImageLoader;

public class ProfileActivtiy extends AppCompatActivity {
    private  static final int ACTIVTY_NUM=4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext=ProfileActivtiy.this;
    private ImageView profile_photo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       BottomNavigationArayuz();
        toolbarKurulum();
        fotoKurulum();
        profile_photo=findViewById(R.id.profile_image);
        setProfilFoto();
        fotolarıGrideEkle();


    }

    private void fotoKurulum(){
        ProgressBar progressBar;
        progressBar=findViewById(R.id.profilProgress);
        progressBar.setVisibility(View.GONE);
    }

    private void setProfilFoto(){

        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
        UniversalImageLoader.setImage(imgURL, profile_photo, null, "https://");
    }


    private void toolbarKurulum(){
        Toolbar toolbar=findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.profilmenu:
                        System.out.println("menuye tıklandı");
                }
                return false;

            }
        });

        ImageView profilAyarlariImageView;
        profilAyarlariImageView=findViewById(R.id.profilAyarlariImageView);
        profilAyarlariImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,hesapayarlari.class);
                startActivity(intent);
            }
        });
    }

    //BottomNavigation ayarları
    private void BottomNavigationArayuz(){
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottomnavi);// 3. kütüphanenin animasyonunun kullanmak için
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivtiy.this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVTY_NUM);
        menuItem.setChecked(true);

    }
    private void fotolarıGrideEkle(){ //suanlık fotoları elimizle eklicegiz
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        profilImageGrid(imgURLs);
    }

    private void profilImageGrid(ArrayList<String> imgURLs){ // profildeki resimleri tek tek sıralıyoruz


        GridView gridView=findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);
        GridImageAdapter adapter=new GridImageAdapter(getApplicationContext(),R.layout.layout_grid_imageview,"",imgURLs);
        gridView.setAdapter(adapter);


    }



}
