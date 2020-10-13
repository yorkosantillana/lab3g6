package pe.edu.pucp.tel306.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorMainSeg extends ViewModel {

    private MutableLiveData<Integer> contadorSeg = new MutableLiveData<>();

    private Thread thread1 = null;

    public void iniciarContador1(){

        setThread1(new Thread(new Runnable() {
            @Override
            public void run() {

                for(int contadorLocalSeg=59;contadorLocalSeg>=0;contadorLocalSeg--){

                    Log.d("contadorMainSeg",String.valueOf(contadorLocalSeg));
                    getContadorSeg().postValue(contadorLocalSeg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }



            }
        }));

        getThread1().start();



    }


    public MutableLiveData<Integer> getContadorSeg() {
        return contadorSeg;
    }

    public void setContadorSeg(MutableLiveData<Integer> contadorSeg) {
        this.contadorSeg = contadorSeg;
    }


    public Thread getThread1() {
        return thread1;
    }

    public void setThread1(Thread thread1) {
        this.thread1 = thread1;
    }
}
