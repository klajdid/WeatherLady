package bussinessLogic;

import services.Iservice;
import services.Weather1;
import services.Weather2;
import services.Weather3;

import java.util.ArrayList;
import java.util.List;

public class AvgDatas {
    List<Iservice>list=new ArrayList<>();

    public List<Iservice> getList() {
        return list;
    }

    public void downloadData(String location) throws Exception {
        list.add(new Weather2(location));
        list.add(new Weather3(location));
    }



}
