package ornek.uygulama.com.instagramklon.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Utils.BottomNavigationViewHelper;
import ornek.uygulama.com.instagramklon.Utils.PagerAdapter;
import ornek.uygulama.com.instagramklon.Utils.UniversalImageLoader;

public class MainActivity extends AppCompatActivity {

    private  static final int ACTIVTY_NUM=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationArayuz();
        viewPagerKurulum();
        initImageLoader();



    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getApplicationContext());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    //3 tane fragment ekle camera home messages
    private void viewPagerKurulum( ){
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment()); //fragmentleri ekliyoruz //index 0
        adapter.addFragment(new HomeFragment()); //index 1
        adapter.addFragment(new MessagesFragment()); //index 2

        ViewPager viewPager=findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout=findViewById(R.id.topToolbar);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_insta);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);

    }


    //BottomNavigation ayarları
    private void BottomNavigationArayuz(){
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottomnavi);// 3. kütüphanenin animasyonunun kullanmak için
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(MainActivity.this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVTY_NUM);
        menuItem.setChecked(true);

    }
}
