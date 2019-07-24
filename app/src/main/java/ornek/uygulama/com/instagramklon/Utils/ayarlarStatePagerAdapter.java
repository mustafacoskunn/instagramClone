package ornek.uygulama.com.instagramklon.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//bunu Profili düzenledeki listview tıkladıgında fragment açılsın diye adapterini oluşturduk
public class ayarlarStatePagerAdapter extends FragmentStatePagerAdapter {

   private  final List<Fragment> mfragmentList=new ArrayList<>(); // fragment arraylistimiz
    private HashMap<Fragment,Integer> mFragments=new HashMap<>();//fragmente göre
    private HashMap<String,Integer> mFragmentsNumbers=new HashMap<>();//fragment numarasına göre
    private HashMap<Integer,String> mFragmentName=new HashMap<>();//ismine  göre
    public ayarlarStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
    public void fragmentEkle(Fragment fragment ,String fragmentName ){ //dışardan eklemek için public
        mfragmentList.add(fragment);
        mFragments.put(fragment,mfragmentList.size()-1); //anahtar değer şeklinde kaydet
        mFragmentsNumbers.put(fragmentName,mfragmentList.size()-1);
        mFragmentName.put(mfragmentList.size()-1,fragmentName);
    }
    private  Integer getFragmentNumarasi(String fragmentName){
        if (mFragmentsNumbers.containsKey(fragmentName)){ //containsKey (Object key): Belli bir anahtar daha önceden girilmiş mi sorgular.
            return mFragmentsNumbers.get(fragmentName); //get (fragmentName): Anahtara karşılık gelen objeyi döndürür.
        }
        else return null;
    }
    private  Integer getFragmentNumarasi(Fragment fragment){
        if (mFragmentsNumbers.containsKey(fragment)){ //containsKey (Object key): Belli bir anahtar daha önceden girilmiş mi sorgular.
            return mFragmentsNumbers.get(fragment); //get (fragmentName): Anahtara karşılık gelen objeyi döndürür.
        }
        else return null;
    }
    private  Integer getFragmentName(Integer fragmentNumber){
        if (mFragmentsNumbers.containsKey(fragmentNumber)){ //containsKey (Object key): Belli bir anahtar daha önceden girilmiş mi sorgular.
            return mFragmentsNumbers.get(fragmentNumber); //get (fragmentName): Anahtara karşılık gelen objeyi döndürür.
        }
        else return null;
    }
}
