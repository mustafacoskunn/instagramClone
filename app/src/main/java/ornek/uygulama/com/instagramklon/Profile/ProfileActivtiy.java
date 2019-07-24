package ornek.uygulama.com.instagramklon.Profile;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Utils.BottomNavigationViewHelper;

public class ProfileActivtiy extends AppCompatActivity {
    private  static final int ACTIVTY_NUM=4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       BottomNavigationArayuz();
        toolbarKurulum();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }
}
