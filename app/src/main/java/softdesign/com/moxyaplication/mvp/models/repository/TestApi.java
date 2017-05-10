package softdesign.com.moxyaplication.mvp.models.repository;


import java.util.Date;
import java.util.List;

import rx.Observable;
import softdesign.com.moxyaplication.mvp.models.intities.Contractor;

/**
 * Created by user on 10.05.2017.
 */

public class TestApi {

    public static List<Contractor> getList(){


        List<Contractor> list =  Observable.range(0, 50)
                .map(i -> new Contractor("Item " + i + " - "+ new Date(),""+i))
                .toList().toBlocking().single();

        return list;
    }
}
