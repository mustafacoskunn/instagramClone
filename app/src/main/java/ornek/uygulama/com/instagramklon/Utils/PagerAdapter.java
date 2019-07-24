package ornek.uygulama.com.instagramklon.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;
import java.util.List;
//yukarı paneldedeki fragmentler için
public class PagerAdapter extends FragmentPagerAdapter { //adapterimizi oluşturduk
    private final List<Fragment> mFragmentList =new ArrayList<>();
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
//https://emrealtunbilek.com/android/34-fragment-pager-ve-fragmentstatepager-adapter-android-material-design-egitim-seti/
    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment){ //yolladıgım fragmentleri listeye ekle
        mFragmentList.add(fragment);
    }
}
