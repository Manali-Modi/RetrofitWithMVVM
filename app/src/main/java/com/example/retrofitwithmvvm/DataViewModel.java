package com.example.retrofitwithmvvm;

import com.example.retrofitwithmvvm.model.Data;
import com.example.retrofitwithmvvm.model.Users;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    private MutableLiveData<List<Data>> liveData;
    int page=1, limit;

    public LiveData<List<Data>> getUsersData(){
        if(liveData == null){
            liveData = new MutableLiveData<>();

            Call<Users> call = ApiClient.getInstance().getAPI().getUserData(page,limit);
            call.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    limit = response.body().getTotal_pages();
                    liveData.setValue(response.body().getData());
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {

                }
            });
        }
        return liveData;
    }
}
