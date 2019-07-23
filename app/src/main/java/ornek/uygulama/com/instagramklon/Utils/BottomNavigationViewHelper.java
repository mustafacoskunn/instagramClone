package ornek.uygulama.com.instagramklon.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import ornek.uygulama.com.instagramklon.Like.LikeActivty;
import ornek.uygulama.com.instagramklon.Home.MainActivity;
import ornek.uygulama.com.instagramklon.Profile.ProfileActivtiy;
import ornek.uygulama.com.instagramklon.R;
import ornek.uygulama.com.instagramklon.Search.SearchActivty;
import ornek.uygulama.com.instagramklon.Share.ShareActivty;


public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        //ayarları yaptık

    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){ //bottom navigationda tıkladıgımız activtye geçmek için
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              switch (menuItem.getItemId()){


                  case R.id.ic_house:
                      Intent intent1=new Intent(context, MainActivity.class);
                      context.startActivity(intent1);
                      break;
                  case R.id.ic_search:
                      Intent intent2=new Intent(context, SearchActivty.class);
                      context.startActivity(intent2);
                      break;
                  case R.id.ic_circle:
                      Intent intent3=new Intent(context, ShareActivty.class);
                      context.startActivity(intent3);
                      break;
                  case R.id.ic_alert:
                      Intent intent4=new Intent(context, LikeActivty.class);
                      context.startActivity(intent4);
                      break;
                  case R.id.ic_android:
                      Intent intent5=new Intent(context, ProfileActivtiy.class);
                      context.startActivity(intent5);
                      break;
              }


                return false;
            }
        });
    }
}