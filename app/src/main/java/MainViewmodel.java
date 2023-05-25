package algonquin.cst2335.love0115.data;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewmodel extends ViewModel {
    public String theText;
    public String buttonText;
    //public String editString;
    public MutableLiveData<String> editString=new MutableLiveData<>();
    public MutableLiveData<Boolean> isSelected=new MutableLiveData<>();

}
