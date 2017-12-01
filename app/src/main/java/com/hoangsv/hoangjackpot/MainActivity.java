package com.hoangsv.hoangjackpot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hoangsv.hoangjackpot.model.Jackpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    private int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
    private List<Integer> mZeroList;
    private List<Integer> mList;
    private List<Jackpot> mJackpotList;

    @BindView(R.id.mainActivity_tv_result)                  TextView mResult;
    @BindView(R.id.mainActivity_tv_result2)                 TextView mResult2;




    @BindView(R.id.mainActivity_edt_number1)                EditText mEditText1;
    @BindView(R.id.mainActivity_edt_number2)                EditText mEditText2;
    @BindView(R.id.mainActivity_edt_number3)                EditText mEditText3;
    @BindView(R.id.mainActivity_edt_number4)                EditText mEditText4;
    @BindView(R.id.mainActivity_edt_number5)                EditText mEditText5;

    @BindView(R.id.mainActivity_edt_number11)               EditText mEditText11;
    @BindView(R.id.mainActivity_edt_number12)               EditText mEditText12;
    @BindView(R.id.mainActivity_edt_number13)               EditText mEditText13;
    @BindView(R.id.mainActivity_edt_number14)               EditText mEditText14;
    @BindView(R.id.mainActivity_edt_number15)               EditText mEditText15;

    @BindView(R.id.mainActivity_edt_number21)               EditText mEditText21;
    @BindView(R.id.mainActivity_edt_number22)               EditText mEditText22;
    @BindView(R.id.mainActivity_edt_number23)               EditText mEditText23;
    @BindView(R.id.mainActivity_edt_number24)               EditText mEditText24;
    @BindView(R.id.mainActivity_edt_number25)               EditText mEditText25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    /*
    * đếm xem mỗi số đã xuất hiện bao nhiêu lần
    */
    private void countAndPlus(int n) {
        switch (n) {
            case 1:
                i1 += 1;
                break;
            case 2:
                i2 += 1;
                break;
            case 3:
                i3 += 1;
                break;
            case 4:
                i4 += 1;
                break;
            case 5:
                i5 += 1;
                break;
            case 6:
                i6 += 1;
                break;
            case 7:
                i7 += 1;
                break;
            case 8:
                i8 += 1;
                break;
            case 9:
                i9 += 1;
                break;
            case 10:
                i10 += 1;
                break;
        }
    }

    /*
    * kiểm tra xem có số nào chưa được chọn hay không, kết hợp thêm việc tạo list thống kê các số chưa được chọn
    */
    private boolean checkNumberNotExist() {
        if (i1 == 0 || i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0 || i6 == 0 || i7 == 0 || i8 == 0 || i9 == 0 || i10 == 0) {
            // thay vì tạo new ArrayList ở trong onCreate thì ta tạo ở đây, như vậy đỡ phải clear ArrayList khi kiểm tra lại
            mZeroList = new ArrayList<>();
            if (i1 == 0)
                mZeroList.add(1);
            if (i2 == 0)
                mZeroList.add(2);
            if (i3 == 0)
                mZeroList.add(3);
            if (i4 == 0)
                mZeroList.add(4);
            if (i5 == 0)
                mZeroList.add(5);
            if (i6 == 0)
                mZeroList.add(6);
            if (i7 == 0)
                mZeroList.add(7);
            if (i8 == 0)
                mZeroList.add(8);
            if (i9 == 0)
                mZeroList.add(9);
            if (i10 == 0)
                mZeroList.add(10);
            return true;
        } else {
            return false;
        }
//        return i1 == 0 || i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0 || i6 == 0 || i7 == 0 || i8 == 0 || i9 == 0 || i10 == 0;
    }

//    @OnTouch(R.id.mainActivity_btn_noJackpot)
//    boolean onTouch(MotionEvent motionEvent) {
//        switch (motionEvent.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e("onTouch ACTION_DOWN", "onTouch");
//                return true;
//            case MotionEvent.ACTION_UP:
//                Log.e("onTouch ACTION_UP", "onTouch");
//                onClick();
//                break;
//        }
//        return false;
//    }

    @OnClick(R.id.mainActivity_btn_noJackpot)
    void onClick() {
        Log.e("onClick", "onClick");




        // giả lập các BỘ 5 số và add vào danh sách
        mJackpotList = new ArrayList<>();

        if (mEditText1.getText().toString().equals("") || mEditText2.getText().toString().equals("") || mEditText3.getText().toString().equals("") || mEditText4.getText().toString().equals("") ||
                mEditText5.getText().toString().equals("") || mEditText11.getText().toString().equals("") || mEditText12.getText().toString().equals("") || mEditText13.getText().toString().equals("") ||
                mEditText14.getText().toString().equals("") || mEditText15.getText().toString().equals("") || mEditText21.getText().toString().equals("") || mEditText22.getText().toString().equals("") ||
                mEditText23.getText().toString().equals("") || mEditText24.getText().toString().equals("") || mEditText25.getText().toString().equals("")) {
            Toast.makeText(getBaseContext(), "Bạn chưa nhập đủ các số", Toast.LENGTH_SHORT).show();
            return;
        }
        Jackpot jackpot1 = new Jackpot(Integer.parseInt(mEditText1.getText().toString()), Integer.parseInt(mEditText2.getText().toString()),
                Integer.parseInt(mEditText3.getText().toString()), Integer.parseInt(mEditText4.getText().toString()), Integer.parseInt(mEditText5.getText().toString()));
        Jackpot jackpot2 = new Jackpot(Integer.parseInt(mEditText11.getText().toString()), Integer.parseInt(mEditText12.getText().toString()),
                Integer.parseInt(mEditText13.getText().toString()), Integer.parseInt(mEditText14.getText().toString()), Integer.parseInt(mEditText15.getText().toString()));
        Jackpot jackpot3 = new Jackpot(Integer.parseInt(mEditText21.getText().toString()), Integer.parseInt(mEditText22.getText().toString()),
                Integer.parseInt(mEditText23.getText().toString()), Integer.parseInt(mEditText24.getText().toString()), Integer.parseInt(mEditText25.getText().toString()));
        mJackpotList.add(jackpot1);
        mJackpotList.add(jackpot2);
        mJackpotList.add(jackpot3);

        // tạo 1 list bao gồm các số đã đánh (các phần tử không trùng nhau)
        mList = new ArrayList<>();
        for (int i=0 ; i<mJackpotList.size() ; i++) {
            if (!mList.contains(mJackpotList.get(i).getN1()))
                mList.add(mJackpotList.get(i).getN1());
            if (!mList.contains(mJackpotList.get(i).getN2()))
                mList.add(mJackpotList.get(i).getN2());
            if (!mList.contains(mJackpotList.get(i).getN3()))
                mList.add(mJackpotList.get(i).getN3());
            if (!mList.contains(mJackpotList.get(i).getN4()))
                mList.add(mJackpotList.get(i).getN4());
            if (!mList.contains(mJackpotList.get(i).getN5()))
                mList.add(mJackpotList.get(i).getN5());
            // sắp xếp lại để in ra cho dễ nhìn :D
            Collections.sort(mList);


            // cách code bên dưới dễ nhìn hơn...
//            int n1, n2, n3, n4, n5;
//            n1 = mJackpotList.get(i).getN1();
//            n2 = mJackpotList.get(i).getN2();
//            n3 = mJackpotList.get(i).getN3();
//            n4 = mJackpotList.get(i).getN4();
//            n5 = mJackpotList.get(i).getN5();
//
//            countAndPlus(n1);
//            countAndPlus(n2);
//            countAndPlus(n3);
//            countAndPlus(n4);
//            countAndPlus(n5);

            // tạo 1 list bao gồm các số đã đánh (các phần tử cho phép trùng nhau), mục đích là để đếm xem 1 số đã xuất hiện bao lần
            List<Integer> listInteger = new ArrayList<>();
            listInteger.add(mJackpotList.get(i).getN1());
            listInteger.add(mJackpotList.get(i).getN2());
            listInteger.add(mJackpotList.get(i).getN3());
            listInteger.add(mJackpotList.get(i).getN4());
            listInteger.add(mJackpotList.get(i).getN5());
            // đếm xem 1 số đã xuất hiện bao lần
            for (Integer integer : listInteger) {
                countAndPlus(integer);
            }


        }

        StringBuilder pickedNumber = new StringBuilder();

        for (int i=0 ; i<mList.size() ; i++) {
            if (i == 0)
                pickedNumber = new StringBuilder(String.valueOf(mList.get(0)));
            else pickedNumber.append(", ").append(mList.get(i));
        }

        mZeroList = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        boolean exist = checkNumberNotExist();
        if (exist) {
            a = new StringBuilder("Có "+mZeroList.size()+" số không được chọn từ 1-10:\n");
            for (int i=0; i<mZeroList.size() ; i++) {
                if (i==0)
                    a.append(String.valueOf(mZeroList.get(i)));
                else a.append("-").append(String.valueOf(mZeroList.get(i)));
            }
        } else {
            a = new StringBuilder("Tất cả các số từ 1-10 đều đã được chọn");
        }

        mResult.setText("Tổng số số đã được chọn: " + mList.size() + ", gồm các số: \n" + pickedNumber
                + "\n\n tần suất xuất hiện của các số 1-10:\n"
                + String.valueOf(i1) + "-" + String.valueOf(i2) + "-" + String.valueOf(i3) + "-" + String.valueOf(i4) + "-" + String.valueOf(i5)
                + "\n" + String.valueOf(i6) + "-" + String.valueOf(i7) + "-" + String.valueOf(i8) + "-" + String.valueOf(i9) + "-" + String.valueOf(i10)
                + "\n\n" + a);

        if (!exist) {
            
        }
    }
}
