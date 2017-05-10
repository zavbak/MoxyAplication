package softdesign.com.moxyaplication.ui.controller;



import android.app.Fragment;
import android.app.FragmentManager;

import softdesign.com.moxyaplication.R;
import softdesign.com.moxyaplication.ui.fragments.ListFragment;


public class ControllerScreen {

    FragmentManager mFragmentManager;

    public ControllerScreen(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public void startListScreen(){
        Fragment fragment = new ListFragment();

        mFragmentManager.beginTransaction()          // получаем экземпляр FragmentTransaction
                .replace(R.id.main_activity_frame_layout, fragment)
                //.addToBackStack("myStack")
                .commit();
    }
}
