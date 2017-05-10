package softdesign.com.moxyaplication.mvp.presenters;

import softdesign.com.moxyaplication.mvp.models.intities.Contractor;
import softdesign.com.moxyaplication.mvp.models.repository.TestApi;
import softdesign.com.moxyaplication.mvp.view.ListView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;
import java.util.List;

@InjectViewState
public class ListPresenter extends MvpPresenter<ListView> {

    List<Contractor> mContractors;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showlist();
    }

    public void showMessage(String mess){
        getViewState().showMessage(mess);
    }

    void refreshContractors(){
        mContractors = TestApi.getList();
    }

    public List<Contractor> getContractors(){
        if(mContractors == null){
            refreshContractors();
        }
        return mContractors;
    }


    public void click(){
        showMessage("click list fragment: " + new Date());
        refreshContractors();
        getViewState().showlist();
    }

}
