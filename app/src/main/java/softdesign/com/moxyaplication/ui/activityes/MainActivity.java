package softdesign.com.moxyaplication.ui.activityes;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import softdesign.com.moxyaplication.R;
import softdesign.com.moxyaplication.mvp.presenters.HomePresenter;
import softdesign.com.moxyaplication.mvp.view.HomeView;
import softdesign.com.moxyaplication.ui.controller.ControllerScreen;


public class MainActivity extends MvpActivity implements HomeView {

    @BindView(R.id.hello_tv_mainactivity)
    TextView tvHello;

    @InjectPresenter
    HomePresenter mHomePresenter;

    ControllerScreen mControllerScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mControllerScreen = new ControllerScreen(getFragmentManager());

        //tvHello.setText("Hello butter knife!");
    }

    @OnClick(R.id.hello_tv_mainactivity)
    public void clickTvMessage(){
        mHomePresenter.onClickMessage();
    }


    @OnClick(R.id.main_activity_frame_layout)
    public void clickFragment(){
        mControllerScreen.startListScreen();
    }


    @Override
    public void showHelloText(String mess) {
        tvHello.setText(mess);
    }
}
