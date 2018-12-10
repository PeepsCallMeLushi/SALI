package pt.sali.sali.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import pt.sali.sali.R;
import pt.sali.sali.fragments.FragMyProfile;
import pt.sali.sali.fragments.FragPageOne;
import pt.sali.sali.fragments.FragPageTwo;
import pt.sali.sali.fragments.FragPartnerProfile;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class AvOcorrencia extends AppCompatActivity {

    ViewPager viewPager;
    WormDotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_av_ocorrencia);
        setTitle("Nova Ocorrencia");
        viewPager = (ViewPager) findViewById(R.id.av_vp);
        dotsIndicator = (WormDotsIndicator) findViewById(R.id.dotsindicator);
        viewPager.setAdapter(new FragPageAdapter(getSupportFragmentManager()));
        dotsIndicator.setViewPager(viewPager);
    }

    public class FragPageAdapter extends FragmentPagerAdapter {

        public FragPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return FragPageOne.newInstance();
                case 1:
                    return FragPageTwo.newInstance();
                default:
                    return FragPageOne.newInstance();
            }

        }


    }
}
