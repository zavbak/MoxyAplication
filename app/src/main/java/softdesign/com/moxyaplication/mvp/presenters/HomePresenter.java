package softdesign.com.moxyaplication.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;

import softdesign.com.moxyaplication.mvp.view.HomeView;

/**
 * Created by user on 10.05.2017.
 */

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {
    public void showHelloText(String mess){
        getViewState().showHelloText(mess);
    }

    public void onClickMessage(){
        showHelloText("Home click: " + new Date());
    }
}
