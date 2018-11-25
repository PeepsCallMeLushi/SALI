package pt.sali.sali.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragOcorrencia extends Fragment {

    ViewPager viewPager;
    WormDotsIndicator dotsIndicator;
    FragMyProfile fragMyProfile;
    FragPartnerProfile fragPartnerProfile;
    Toolbar toolbar;

    public FragOcorrencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Ocorrencia");
        View v = inflater.inflate(R.layout.fragment_frag_ocorrencia, container, false);
        toolbar = getActivity().findViewById(R.id.toolbar);
        fragMyProfile = new FragMyProfile();
        fragPartnerProfile = new FragPartnerProfile();
        viewPager = (ViewPager) v.findViewById(R.id.av_vp);
        dotsIndicator = (WormDotsIndicator) v.findViewById(R.id.dotsindicator);
        viewPager.setAdapter(new FragPageAdapter(getChildFragmentManager()));
        dotsIndicator.setViewPager(viewPager);
        toolbar.getMenu().clear();

        return v;
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
